<#assign text>${json}</#assign>
<#assign jsonobj=text?eval />
<#assign keys = jsonobj?keys> 

package ${packageName};

import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;



/**
 * create by freemaker
 */
public class ${beanClass}Dao {
    public static final String TAG = "${beanClass}Dao";
    public static final String TABLE_NAME = "${beanClass}TB";
    public SQLiteOpenHelper mOpenHelper;
    
    public static class Columns implements BaseColumns{
		<#list keys as key>
			public static final String ${key} = "${key}";
		</#list>
    }
    
     public String[] allkeyjection = new String[]{
     				Columns._ID,
     	<#list keys as key>
			 <#if key_has_next>
	                Columns.${key},
					</#if>
					<#if !key_has_next>
	                Columns.${key}
	                </#if>
		</#list>
		
		};
    
    
    public ${beanClass}Dao(Context context) {
        mOpenHelper = DatabaseHelper.getInstance(context);
        L.d(TAG, "In onCreate method, create the keyvider: " + this
                + ", and DatabaseHelper: " + mOpenHelper);
    }
    
    /**
     * Use this static method to create the table
     * It will be called by {@link DatabaseHelper} during first launch time to create DB.
     * @param db
     */
    public static void createTable(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(" + Columns._ID + " integer primary key autoincrement, "
                <#list keys as key>
	                <#if key_has_next>
	                + Columns.${key} + " text, "
					</#if>
					<#if !key_has_next>
	                + Columns.${key} + " text "
	                </#if>
				</#list>
                + ");");
    }
    
    public long insert(${beanClass} bean) {
        SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        ContentValues values = ${beanClass}.bean2CV(bean);
        long id = db.insert(TABLE_NAME, null, values);
        db.close();
        return id;
    }

    public void delete(String columnsName,String value) {
        SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        String selection = columnsName + " = ?";
        String[] selectionArgs = {value};
        db.delete(TABLE_NAME, selection, selectionArgs);
        db.close();
    }

    public void update(String columnsName,${beanClass} bean) {
        SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        ContentValues values = ${beanClass}.bean2CV(bean);
        String selection = columnsName + " = ?";
        String[] selectionArgs = {"id"};

        db.update(TABLE_NAME, values, selection, selectionArgs);
        db.close();
    }

    public ${beanClass} get${beanClass}ByKey(String columnsName,String key) {
        ${beanClass} bean = null;
        SQLiteDatabase db = mOpenHelper.getReadableDatabase();
        String selection = columnsName + " = ?";
        String[] selectionArgs = {key};
        Cursor c = db.query(
                TABLE_NAME, allkeyjection, selection, selectionArgs, null, null, null);
        if (c != null && c.getCount() > 0) {
            while (c.moveToNext()) {
                bean = ${beanClass}.cursor2Bean(c);
                break;
            }
        }
        if (c != null) {
            c.close();
        }
        db.close();
        return bean;
    }

    public List<${beanClass}> get${beanClass}List() {
        List<${beanClass}> list = new ArrayList<${beanClass}>();
        SQLiteDatabase db = mOpenHelper.getReadableDatabase();
        Cursor c = db.query(
                TABLE_NAME, allkeyjection, null, null, null, null, null);
        if (c != null && c.getCount() > 0) {
            ${beanClass} bean = null;
            while (c.moveToNext()) {
                bean = ${beanClass}.cursor2Bean(c);
                list.add(bean);
            }
        }
        if (c != null) {
            c.close();
        }
        db.close();
        return list;
    }
    
}


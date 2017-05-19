package pay.lib.data.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.support.annotation.NonNull;

import com.potato.library.util.L;

import java.util.ArrayList;
import java.util.List;

import pay.lib.chips.common.DatabaseHelper;

/**
 * Use this provider to access the cache(缓存表) table
 *
 * @author ztw
 */
public class DemoDAO {
    private static final String TAG = "DemoDAO";

    protected SQLiteOpenHelper mOpenHelper;
    public static final String TABLE_PATH = "DemoDAO";

    public static class Columns implements BaseColumns {
        public static final String requestType = "requestType";
        public static final String requestStr = "requestStr";
        public static final String responseStr = "responseStr";
        public static final String specStr = "specStr";
        public static final String time = "time";
    }

    String[] mProjection = new String[]{
            Columns._ID,
            Columns.requestType,
            Columns.requestStr,
            Columns.responseStr,
            Columns.specStr,
            Columns.time};


    public static class Cache {
        public String requestType = "requestType";
        public String requestStr = "requestStr";
        public String responseStr = "responseStr";
        public String specStr = "specStr";
        public long time = 0l;
    }

    /**
     * Use this static method to create the table It will be called by
     * {@link } during first launch time to create DB.
     *
     * @param db
     */
    public static void createTable(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_PATH + "("
                + Columns._ID + " integer , "
                + Columns.requestType + " text, "
                + Columns.requestStr + " text primary key not null UNIQUE ON CONFLICT REPLACE, "
                + Columns.responseStr + " text, "
                + Columns.specStr + " text, "
                + Columns.time + " integer" + ");");
    }

    public DemoDAO(Context context) {
        mOpenHelper = DatabaseHelper.getInstance(context);
        L.d(TAG, "In onCreate method, create the provider: " + this
                + ", and DatabaseHelper: " + mOpenHelper);
    }

    public long insert(@NonNull Cache cache) {
        SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        ContentValues values = bean2CV(cache);
        long id = db.insert(TABLE_PATH, null, values);
        db.close();
        return id;
    }

    public void delete(@NonNull String key) {
        SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        String selection = Columns.requestStr + " = ?";
        String[] selectionArgs = {key};
        db.delete(TABLE_PATH, selection, selectionArgs);
        db.close();
    }

    public void update(@NonNull Cache cache) {
        SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        ContentValues values = bean2CV(cache);
        String selection = Columns.requestStr + " = ?";
        String[] selectionArgs = {cache.requestStr};

        db.update(TABLE_PATH, values, selection, selectionArgs);
        db.close();
    }

    public Cache getCacheByKey(String key) {
        Cache bean = null;
        SQLiteDatabase db = mOpenHelper.getReadableDatabase();
        String selection = Columns.requestStr + " = ?";
        String[] selectionArgs = {key};
        Cursor c = db.query(
                TABLE_PATH, mProjection, selection, selectionArgs, null, null, null);
        if (c != null && c.getCount() > 0) {
            while (c.moveToNext()) {
                bean = cursor2bean(c);
                break;
            }
        }
        if (c != null) {
            c.close();
        }
        db.close();
        return bean;
    }

    public List<Cache> getCacheList() {
        List<Cache> list = new ArrayList<Cache>();
        SQLiteDatabase db = mOpenHelper.getReadableDatabase();
        Cursor c = db.query(
                TABLE_PATH, mProjection, null, null, null, null, null);
        if (c != null && c.getCount() > 0) {
            Cache bean = null;
            while (c.moveToNext()) {
                bean = cursor2bean(c);
                list.add(bean);
            }
        }
        if (c != null) {
            c.close();
        }
        db.close();
        return list;
    }

    public static Cache cursor2bean(Cursor c) {
        Cache bean = new Cache();
        if (c != null) {
            bean.requestStr = c.getString(c.getColumnIndexOrThrow(Columns.requestStr));
            bean.requestType = c.getString(c.getColumnIndexOrThrow(Columns.requestType));
            bean.responseStr = c.getString(c.getColumnIndexOrThrow(Columns.responseStr));
            bean.specStr = c.getString(c.getColumnIndexOrThrow(Columns.specStr));
            bean.time = c.getLong(c.getColumnIndexOrThrow(Columns.time));
        } else {
            return null;
        }
        return bean;
    }

    /*public static Cache json2bean(JSONObject json) throws JSONException {
        if (json == null)
            return null;
        return video;
    }*/

    public static ContentValues bean2CV(Cache bean) {
        ContentValues values = new ContentValues();
        values.put(Columns.requestType, bean.requestType);
        values.put(Columns.requestStr, bean.requestStr);
        values.put(Columns.responseStr, bean.responseStr);
        values.put(Columns.specStr, bean.specStr);
        if (bean.time > 0) {
            values.put(Columns.time, bean.time);
        } else {
            values.put(Columns.time, System.currentTimeMillis());
        }

        return values;
    }

}

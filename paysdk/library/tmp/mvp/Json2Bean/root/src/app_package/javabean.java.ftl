<#assign text>${json}</#assign>
<#assign jsonobj=text?eval />
<#assign keys = jsonobj?keys> 

package ${packageName};

//import
import java.util.Date;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
import android.database.Cursor;


import android.content.ContentValues;

public class ${beanClass} extends BaseBean implements Serializable{

	//keypslist
<#list keys as key>
	private String ${key};
</#list>

	//set get list	
<#list keys as key>
	public void set${key?cap_first}(String ${key}){
		this.${key}=${key};
	}
	
	public String get${key?cap_first}(){
		return this.${key};
	}
	
</#list>

	//other
	//createFromCursor
    public static ${beanClass}  cursor2Bean(Cursor cursor){
     if (cursor == null) return null;
        ${beanClass} bean = new ${beanClass}();
        <#list keys as key>
			bean.set${key?cap_first}(cursor.getString(cursor.getColumnIndex(${beanClass}Dao.Columns.${key})));
		</#list>
		return bean;
	}
	
    //createFromJSON
    public static ${beanClass}  json2Bean(JSONObject json)throws JSONException{
     if (json == null) return null;
        ${beanClass} bean = new ${beanClass}();
        <#list keys as key>
			bean.set${key?cap_first}(json.optString("${key}"));
		</#list>
		return bean;
	}
	
	//createFromJSONArray
    public static ArrayList<${beanClass}> jsonArray2BeanList(JSONArray jsonArray) throws JSONException {

        if (jsonArray == null) return null;

        ArrayList<${beanClass}> list = new ArrayList<${beanClass}>();

        int count = jsonArray.length();
        for (int i = 0; i < count; i++) {
            JSONObject jsonObj = jsonArray.optJSONObject(i);
            ${beanClass} entity = ${beanClass}.json2Bean(jsonObj);
            list.add(entity);
        }
        return list;
    }
	
    //buildContentValues
    public static ContentValues bean2CV(BaseBean baseBean) {
        ${beanClass} bean = new ${beanClass}();

        if (baseBean != null) {
            bean = (${beanClass}) baseBean;
        }
        ContentValues values = new ContentValues();
        <#list keys as key>
        values.put(${beanClass}Dao.Columns.${key}, bean.get${key?cap_first}());
        </#list>
        return values;
    }

}
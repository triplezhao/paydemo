package pay.lib.chips.util;


import com.lzy.okhttputils.model.HttpParams;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


/**
 * Created by admin on 2016/9/12.
 */
public class ApiTool {


    public static HttpParams bean2Map(Object bean) {

        HttpParams map = new HttpParams();
        Field[] field = bean
                .getClass()
                .getDeclaredFields();        //获取实体类的所有属性，返回Field数组
        for (int j = 0; j < field.length; j++) {     //遍历所有属性
            String fieldname = field[j].getName();    //获取属性的名字
            String name = fieldname;    //获取属性的名字
            name = name
                    .substring(0, 1)
                    .toUpperCase() + name.substring(1); //将属性的首字符大写，方便构造get，set方法
            String type = field[j]
                    .getGenericType()
                    .toString();    //获取属性的类型
            if (type.equals("class java.lang.String")) {   //如果type是类类型，则前面包含"class "，后面跟类名
                Method m = null;
                try {
                    m = bean
                            .getClass()
                            .getMethod("get" + name);
                    String value = (String) m.invoke(bean);    //调用getter方法获取属性值
                    if (value != null) {
                        map.put(fieldname, value);
                    }
                    System.out.println("attribute value:" + value);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            if (type.equals("class java.lang.Integer")) {   //如果type是类类型，则前面包含"class "，后面跟类名
                Method m = null;
                try {
                    m = bean
                            .getClass()
                            .getMethod("get" + name);
                    Integer value = (Integer) m.invoke(bean);    //调用getter方法获取属性值
                    if (value != null) {
                        map.put(fieldname, value + "");
                    }
                    System.out.println("attribute value:" + value);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return map;
    }

    public static void main(String args[]) {
//
//        HttpParams map = new HttpParams();
//        map.put("id", "35");
//
//        map.put("uid", "78");
//        map.put("userid", "118");
//
//        map.put("source", "app");
//        map.put("client_type", "android");
//        map.put("version", BuildConfig.VERSION_NAME + "");
//
//        String sign = ApiTool.getSign(map);
//        L.i("sign=" + sign);
    }
}

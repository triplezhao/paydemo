package pay.lib.chips.api;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by ztw on 2016/5/25.
 */
public abstract class BaseResultEntity implements Serializable {

    //透传的属性，可以在onresp时，进行设置，会被保存到cache里，下次读取从cache里读取的时候，这会有值。
    public long   cacheTime;
    public String testKey;
    /**
     * 返回码
     */
    public String code = "-1";
    /**
     * 返回Message
     */
    public String message;

    /**
     * 返回总个数
     */
    public int total;
    /**
     * 列表数据
     */
    public ArrayList list = new ArrayList();


    public abstract boolean isSucc();

    public abstract String getMsg();

    public abstract BaseResultEntity parse(String json);
}

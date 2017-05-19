package pay.lib.chips.common;

/**
 * Created by admin on 2016/8/15.
 */
public class CommonEvent {
    public String message = "";
    public int    what    = 0;  //页面自定义对照表，一般不会出现两个页面都收到event，如果出现，则另外设置页面type类型

    public CommonEvent() {

    }
}

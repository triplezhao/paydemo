package pay.lib.chips.event;

/**
 * Created by admin on 2016/8/15.
 */
public class PayEvent {
    public String message = "";
    public int    what    = 0;  //0 失败 1成功

    public PayEvent(int what) {
        this.what = what;
    }
}

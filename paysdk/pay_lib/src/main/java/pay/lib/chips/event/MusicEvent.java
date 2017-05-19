package pay.lib.chips.event;

/**
 * Created by admin on 2016/8/15.
 */
public class MusicEvent {
    public  String message="";
    public  int what=0;  //0 开始，1暂停 ，2 继续， 3，停止

    public MusicEvent(int what) {
        this.what = what;
    }
}

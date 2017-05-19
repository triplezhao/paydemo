package pay.lib.chips.api;

/**
 * Created by Administrator on 2016/11/9 0009.
 */
public class Err extends Exception {

    public static final int NET_CONNECTFAIL = 0;
    public static final int NET_FAIL        = 1;
    public static final int SERVER_FAIL     = 2;
    public static final int API_FAIL        = 3;
    public static final int CACHE_FAIL      = 4;

    public int type = NET_FAIL;

    public Err(int type, String msg) {
        super(msg);
        this.type = type;
    }
}

package pay.lib.chips.common;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ztw on 2015/12/25.
 */
public class AppPool {
    public static ExecutorService FixedPool = Executors.newFixedThreadPool(2);
    public static ExecutorService SinglePool = Executors.newSingleThreadExecutor();
}

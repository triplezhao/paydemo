package pay.lib.chips.app;

import android.app.Application;
import android.content.Context;

/**
 * Created by zhaobingfeng on 14-12-22.
 */
public class DemoApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        PayHelper
                .getInstance()
                .init(this);

    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }


}

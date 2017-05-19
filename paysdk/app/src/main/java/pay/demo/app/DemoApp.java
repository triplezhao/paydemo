package pay.demo.app;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import pay.lib.chips.app.PayHelper;

/**
 * Created by zhaobingfeng on 14-12-22.
 */
public class DemoApp extends MultiDexApplication {

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
        MultiDex.install(this);
    }


}

package pay.lib.chips.app;

import android.app.Application;
import android.content.Context;
import android.util.DisplayMetrics;

import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;
import com.potato.library.util.L;

import pay.lib.chips.api.ApiManager;
import pay.lib.chips.util.ImageLoaderUtil;
import pay.lib.chips.util.PhoneUtils;

/**
 * Created by zhaobingfeng on 14-12-22.
 */
public class PayHelper {
    /**
     * 获取屏幕的宽和高
     */
    public static int screenHight = 0;
    public static int screenWidth = 0;
    public static DisplayMetrics displayMetrices;
    /**
     * 获取全局的上下文
     */
    public static Context        context;
    public static Application    app;


    private static final PayHelper ourInstance = new PayHelper();

    public static PayHelper getInstance() {
        return ourInstance;
    }

    private PayHelper() {
    }


    public void init(Application context) {
        this.app = context;
        this.context = context;
        init();
    }


    /**
     */
    private void init() {
        initLog();
        initDeviceWidthAndHeight();

        //请求缓存管理
        ApiManager.init(app);
        initUIL();

    }

    private void initLog() {
        if (GlobleConstant.isDebug) {
//            Stetho.initializeWithDefaults(this);  // 开启 Stetho 调试模式
            L.openLog();
            Logger
                    .init("=aiyouyun=")
                    .logLevel(LogLevel.FULL)
                    .methodOffset(1);
        } else {
            L.closeLog();
            Logger
                    .init()
                    .logLevel(LogLevel.NONE);
        }
    }


    public void initUIL() {
        ImageLoaderUtil.init(context);
    }

    /**
     * 获取设备的宽和高 WangQing 2013-8-12 void
     */
    private void initDeviceWidthAndHeight() {
        displayMetrices = PhoneUtils.getAppWidthAndHeight(context);
        screenHight = displayMetrices.heightPixels;
        screenWidth = displayMetrices.widthPixels;
    }


}



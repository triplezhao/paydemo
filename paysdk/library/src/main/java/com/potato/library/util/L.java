package com.potato.library.util;

import android.content.Context;
import android.os.Environment;

import com.orhanobut.logger.Logger;
import com.potato.library.PotatoConfig;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * 日志工具�?
 */

public final class L {

    public static final int VERBOSE = 2;
    public static final int DEBUG = 3;
    public static final int INFO = 4;
    public static final int WARN = 5;
    public static final int ERROR = 6;
    public static final int ASSERT = 7;
    private static int RECORD_LEVEL = 5;
    private static Context mContext;
    private static String LOG_DIR_PATH = "/potato/logs";
    public static boolean isOpen = PotatoConfig.IS_DEBUG;
    ;
    public static boolean isWrite = false;
    public static String TAG = "LOG";
    private static String logPath;

    public static void openLog() {
        if (!isOpen) {
            isOpen = true;
        }

    }

    public static void closeLog() {
        if (isOpen) {
            isOpen = false;
        }

    }

    public static void openWrite(Context context) {
        mContext = context;
        if (!isWrite) {
            isWrite = true;
        }

    }

    public static void closeWrite() {
        if (isWrite) {
            isWrite = false;
        }

    }

    public static void setRecordLevel(int level) {
        RECORD_LEVEL = level;
    }

    public static void i(String log) {
        i(null, log);
    }

    public static void i(String TAG, String log) {
        String name = TAG;
        if (TAG == null) {
            name = getFunctionName();
        }
        if (isOpen) {
            Logger.i(name +","+ log);
        }
        if (isWrite && RECORD_LEVEL <= 4) {
            record(name + " - " + log);
        }
    }

    public static void d(String log) {
        d(null, log);
    }

    public static void d(String TAG, String log) {
        String name = TAG;
        if (TAG == null) {
            name = getFunctionName();
        }
        if (isOpen) {
            Logger.d(name +","+ log);
        }
        if (isWrite && RECORD_LEVEL <= 3) {
            record(name + " - " + log);
        }

    }

    public static void w(String log) {
        w(null, log);
    }

    public static void w(String TAG, String log) {
        String name = TAG;
        if (TAG == null) {
            name = getFunctionName();
        }
        if (isOpen) {
            Logger.w(name +","+ log);
        }

        if (isWrite && RECORD_LEVEL <= 5) {
            record(name + " - " + log);
        }

    }

    public static void e(String log) {
        e(null, log);
    }

    public static void e(String TAG, String log) {
        String name = TAG;
        if (TAG == null) {
            name = getFunctionName();
        }
        if (isOpen) {
            Logger.e(name +","+ log);
        }

        if (isWrite && RECORD_LEVEL <= 6) {
            record(name + " - " + log);
        }

    }

    private static String getFunctionName() {
        StackTraceElement[] sts = Thread.currentThread().getStackTrace();
        if (sts == null) {
            return "";
        } else {
            StackTraceElement[] var4 = sts;
            int var3 = sts.length;

            for (int var2 = 0; var2 < var3; ++var2) {
                StackTraceElement st = var4[var2];
                if (!st.isNativeMethod() && !st.getClassName().equals(Thread.class.getName()) && !st.getClassName().equals(L.class.getName())) {
                    return st.getMethodName() + "()丨" + st.getFileName() + "丨line " + st.getLineNumber();
                }
            }

            return "";
        }
    }

    private static void record(String msg) {
        writeToFile(mContext, msg, "app.log", true);
    }

    private static void writeToFile(Context context, String msg, String filename, boolean append) {
        try {
            String e = getStorePath(context) + "/" + filename;
            logPath = e;
            BufferedWriter bos = new BufferedWriter(new FileWriter(e, append));
            bos.write(msg + "\n");
            bos.flush();
            bos.close();
        } catch (Exception var6) {
            var6.printStackTrace();
        }

    }

    private static String getStorePath(Context context) {
        String dirPath = context.getFilesDir().getAbsolutePath();
        if ("mounted".equals(Environment.getExternalStorageState())) {
            if (Environment.getExternalStorageDirectory().canWrite()) {
                dirPath = Environment.getExternalStorageDirectory().getPath() + LOG_DIR_PATH;
            }
        } else {
            dirPath = context.getFilesDir().getAbsolutePath() + LOG_DIR_PATH;
        }

        File file = new File(dirPath);
        if (!file.exists()) {
            file.mkdirs();
        }

        return file.getAbsolutePath();
    }

    public static void clearLogFile() {
        File file = new File(logPath);
        if (file.exists()) {
            file.delete();
        }

    }
}

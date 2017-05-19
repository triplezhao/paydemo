package com.potato.library.util;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;

import java.io.File;


/**
 * Created by admin on 2016/9/23.
 */

public class FileUtil {
    public static File getTmpFile(Context application, String dir, String filename) {
        String path = "";
        if (application.getExternalCacheDir() != null && !TextUtils.isEmpty(
                application.getExternalCacheDir().getAbsolutePath())) {
            path =
                    application.getExternalCacheDir().getAbsolutePath() + File.separator + dir;
        }
        if (path == null) {
            path = Environment.getExternalStorageDirectory() + File.separator + application.getPackageName() + File.separator + dir;
            ;
        }
        if (path == null) {
            path = application.getCacheDir().getAbsolutePath() + File.separator + dir;
            ;
        }
        final File dirfile = new File(path);
        if (!dirfile.exists()) {
            if (!dirfile.mkdir()) {
            }
        }
        //得到那个生成的文件
        File file = new File(path + File.separator + filename);
        return file;
    }


}

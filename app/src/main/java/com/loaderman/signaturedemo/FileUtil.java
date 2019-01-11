package com.loaderman.signaturedemo;

import android.os.Environment;

import java.io.File;


public class FileUtil {
    public static File getFile() {
        File appDir = new File(Environment.getExternalStorageDirectory(), "Signature");

        if (!appDir.exists()) {
            appDir.mkdirs();
        }
        return appDir;
    }
}

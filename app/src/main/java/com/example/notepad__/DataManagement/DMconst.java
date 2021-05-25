package com.example.notepad__.DataManagement;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.provider.ContactsContract;

import androidx.annotation.RequiresApi;

import java.io.File;

public class DMconst {
    Context appContext;
    static public File BASE_DIR;            // Android 4.4 이상에 적용됨
    static public File OLD_BASE_DIR =       // Android 4.3 이하에 적용됨
            new File(Environment.getExternalStorageDirectory().getAbsolutePath(), "/Notepad--");

    private DMconst() { } // 객체 생성 금지

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    static public void init(Application app) {
        BASE_DIR = app.getApplicationContext().getExternalFilesDir(ContactsContract.Directory.PACKAGE_NAME);
    }

    static public File getBasePath() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
            return BASE_DIR;
        else
            return OLD_BASE_DIR;
    }
}

package com.example.notepad__.DataManagement;

import android.os.Environment;

public class DMconst {
    private DMconst() { } // 객체 생성 금지
    static public final String DIR_PATH =       // Android 9 이하에 적용됨
            Environment.getExternalStorageDirectory().getAbsolutePath() + "/Notepad--";
}

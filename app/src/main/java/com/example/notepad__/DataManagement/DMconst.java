package com.example.notepad__.DataManagement;

import android.os.Environment;

public class DMconst {
    private DMconst() {
    }
    ; // 객체 생성 금지
    static public final String DIR_PATH =
            Environment.getExternalStorageDirectory().getAbsolutePath() + "/Notepad--";
}

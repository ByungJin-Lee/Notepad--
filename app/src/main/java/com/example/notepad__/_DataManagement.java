package com.example.notepad__;

import java.util.ArrayList;

class File {
    public String fileName;
    public String path;
    public boolean isNew = false;
    public int index = 0;
}

class DataManager {
    static ArrayList<File> files;

    static public void search(){
        // 외부 저장소에 있는 file을 불러와 files에 append
    }
    static public boolean saveText(File f, String s) {
        // f의 내용을 s로 갱신
        return // 저장 성공/실패 여부
    }
    static public String loadText(File f) {
        // f를 불러와 내용을 return
        return // real content
    }
    static public String loadText(int i) {
        return loadText(files.get(i));
    }
    static public boolean delete(File f) {
        // 저장소와 files에 있는 파일 f를 삭제함
    }
}

public class _DataManagement {
}

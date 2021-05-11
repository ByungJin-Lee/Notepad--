package com.example.notepad__;

import android.os.Environment;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class FileInfo {
    public String fileName;
    public String path;
    public boolean isNew = false;
    public int index = 0;

    public FileInfo(String fileName, String path, boolean isNew, int index) {
        this.fileName = fileName;
        this.path = path;
        this.isNew = isNew;
        this.index = index;
    }
}

class DataManager {
    static public String DIR_PATH =
            Environment.getExternalStorageDirectory().getAbsolutePath() + "Notepad--";

    static ArrayList<FileInfo> files;

    private DataManager() {} // 객체 생성을 막기 위한 private 생성자

    static public boolean isExternalStorageWritable() {
        return Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState());
    }

    static public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        return (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state));
    }

    static public boolean search(){
        /*
         * 외부 저장소에서 파일을 불러와 files에 append.
         */
        if (!isExternalStorageReadable())
            return false;
        File dir = new File(DIR_PATH);
        try {
            if (!dir.exists()) {
                dir.mkdirs(); // Notepad-- 폴더 생성
                return true; // 검색 결과 없음
            }
            if (!dir.isDirectory()) {
                return false; // Notepad--라는 '파일'이 있어 생성 불가
            }
            File[] files = dir.listFiles();
            for (int i = 0; i < dir.list().length; ++i) {
                if (files[i].isDirectory())
                    continue; // "Notepad--/(폴더)" 꼴은 일단 무시
                String name = files[i].getName();
                FileInfo fi = new FileInfo(name, DIR_PATH + name, false, i);
                this.files.add(fi);
            }
            return true;
        }
        catch (IOException e) {
            return false;
        }

    }

    static public boolean saveText(FileInfo f, String s) {
        /*
         * f의 내용을 s로 갱신한 후 files와 외부 저장소에 적용
         * 파일이 없으면 생성됨. 성공 여부를 return함.
         * @param f 내용이 저장될 FileInfo
         * @param s 저장할 내용
         */
        if (!isExternalStorageWritable())
            return false;
        File file = new File(f.path);
        try {
            if (!file.exists())
                file.createNewFile();
            FileWriter writer = new FileWriter(file, false);
            writer.write(s);
            writer.close();
            return true;
        }
        catch (IOException e) {
            return false;
        }
    }

    static public String loadText(FileInfo f) {
        /*
         * f를 불러와 내용을 return함.
         * 불러오기에 실패하면 null을 return함.
         * @param f 내용을 불러올 FileInfo
         */
        if (!isExternalStorageReadable())
            return null; //

        return // real content
    }
    static public String loadText(int i) {
        /*
         * DataManager.files[i]를 불러와 내용을 return함.
         * 불러오기에 실패하면 null을 return함.
         * @param i 불러올 파일의 인덱스
         */
        return loadText(files.get(i));
    }

    static public boolean delete(FileInfo f) {
        /*
         * 외부 저장소에 files에서 f를 삭제함.
         * 성공 여부를 return함.
         * @param f 삭제할 파일의 fileInfo
         */

        return true;
    }
}

public class _DataManagement { /* do nothing */ }

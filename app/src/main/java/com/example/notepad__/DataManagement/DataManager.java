package com.example.notepad__.DataManagement;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DataManager {
    /**
     * @author DoubleDeltas
     * @version 0.1
     * @see FileInfo
     * @see java.util.ArrayList
     * @see java.io.FileReader
     * @see java.io.FileWriter
     * @see android.os.Environment
     */

    public static ArrayList<FileInfo> files = new ArrayList<FileInfo>();

    private DataManager() {
    } // 객체 생성을 막기 위한 private 생성자

    static public boolean isExternalStorageWritable() {
        return Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState());
    }

    static public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        return (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state));
    }

    static public boolean search() {
        /**
         * 외부 저장소에서 파일을 불러와 files에 append.
         */
        if (!isExternalStorageReadable())
            return false;
        files.clear();
        File dir = new File(DMconst.DIR_PATH);
        try {
            if (!dir.exists()) {
                dir.mkdirs();           // Notepad-- 폴더 생성
                return true;            // 검색 결과 없음
            }
            if (!dir.isDirectory()) {
                return false;           // Notepad--라는 '파일'이 있어 생성 불가
            }
            File[] lst = dir.listFiles();
            for (int i = 0; i < dir.list().length; ++i) {
                if (lst[i].isDirectory())
                    continue;           // "Notepad--/(폴더)" 꼴은 일단 무시
                String name = lst[i].getName();
                FileInfo fi = new FileInfo(name, DMconst.DIR_PATH + "/" + name, false, i,
                        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                                .format(lst[i].lastModified()));
                files.add(fi);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    static public boolean saveText(FileInfo f, String s) {
        /**
         * f의 내용을 s로 갱신한 후 files와 외부 저장소에 적용
         * 파일이 없으면 생성됨.
         * @param f 내용이 저장될 FileInfo
         * @param s 저장할 내용
         * @return 파일 생성 성공 여부를 return.
         */
        if (!isExternalStorageWritable())
            return false;
        File file = new File(f.getPath());
        try {
            if (!file.exists()) {
                file.createNewFile();
                Log.v("알림", "save - 새 파일 생성됨");
            }
            FileWriter writer = new FileWriter(file, false);
            writer.write(s);
            writer.close();
            Log.v("알림", "save 완료. (" + f.getFileName() + ", " + s + ")");
            return true;
        } catch (IOException e) {
            Log.e("알림", "save 실패. (" + f.getFileName() + ", " + s + ") - IOException");
            Log.e("알림", e.getMessage());
            return false;
        }
    }

    static public String loadText(FileInfo f) {
        /**
         * f를 불러와 내용을 return함.
         * @param f 내용을 불러올 FileInfo
         * @return f의 내용을 return. 불러오기 실패하면 null을 return.
         */
        if (!isExternalStorageReadable())
            return null;
        File file = new File(f.getPath());
        char[] buffer = new char[1024];
        try {
            FileReader reader = new FileReader(file);
            reader.read(buffer);
            return String.valueOf(buffer);
        } catch (Exception e) {
            return null;
        }
    }

    static public String loadText(int i) {
        /**
         * DataManager.files[i]를 불러와 내용을 return함.
         * @param i 불러올 파일의 인덱스
         * @return files[i]의 내용을 return. 불러오기 실패하면 null을 return.
         */
        return loadText(files.get(i));
    }

    static public boolean delete(FileInfo f) {
        /**
         * 외부 저장소와 files에서 f를 삭제함.
         * @param f 삭제할 파일의 fileInfo
         * @return 성공 여부를 return함.
         */
        if (!isExternalStorageReadable())
            return false;
        try {
            files.remove(f); // 지우려고 시도함.
            File file = new File(f.getPath());
            boolean res = file.delete();
            Log.v("알림", "delete try");
            return res;
        } catch (Exception e) {
            Log.e("알림", "delete 실패 - Exception");
            Log.e("알림", e.getMessage());
            return false;
        }
    }

    static public boolean delete(int i) {
        /**
         * DataManager.files[i]을 외부저장소와 files에서 삭제
         * @param i 삭제할 파일의 인덱스
         * @return 성공 여부를 return함.
         */
        return delete(files.get(i));
    }
}


package com.example.notepad__.DataManagement;

import android.util.Log;

import java.text.SimpleDateFormat;

public class FileInfo {
    /**
     * @author  DoubleDeltas
     * @version 0.1
     * @see     java.io.File
     */

    private String fileName;
    private String path;
    private boolean isNew;
    private int index;
    private String lastModified;

    public FileInfo(String fileName, String path, boolean isNew, int index, String lastModified) {
        this.fileName = fileName;
        this.path = path;
        this.isNew = isNew;
        this.index = index;
        this.lastModified = lastModified;
    }
    public FileInfo(String fileName, int index) {
        this(fileName, DMconst.getBasePath().getAbsolutePath() + "/" + fileName, false, index,
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()));

        Log.v("알림", "FileInfo 객체 생성(2 args)");
    }
    public FileInfo(String fileName, boolean isNew){
        this(fileName, 0);
    }

    public String getPath(){
        return path;
    }
    public String getFileName(){
        return fileName;
    }
    public void setFileName(String fileName){
        this.fileName = fileName;
    }
    public void setPath(String path){
        this.path = path;
    }
    public String getLastModified(){
        return lastModified;
    }
    public int getIndex(){
        return index;
    }
    public boolean getIsNew(){
        return isNew;
    }
}
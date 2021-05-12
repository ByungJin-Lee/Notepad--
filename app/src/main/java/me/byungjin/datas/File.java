package me.byungjin.datas;

public class File {
    private String fileName;
    private String path;
    private boolean isNew = false;

    public File(){
        set("","");
    }
    public File(String _fileName){
        set(_fileName, "");
    }
    public File(String _fileName, String _path){
        set(_fileName, _path);
    }
    public String getFileName(){
        return fileName;
    }
    public String getPath(){
        return path;
    }
    public void setFileName(String _fileName){
        fileName = _fileName;
    }
    public void setPath(String _path){
        path = _path;
    }
    public void set(String _fileName, String _path){
        fileName = _fileName;
        path = _path;
    }
    public void setIsNew(boolean _new){
        isNew = _new;
    }
}

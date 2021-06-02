package me.byungjin.controllers;

import android.util.Log;
import android.widget.TextView;

import com.example.notepad__.DataManagement.DataManager;
import com.example.notepad__.DataManagement.FileInfo;

public class TextViewController {
    //Current Memo File
    static private FileInfo currentFile = null;
    static private TextView title = null;
    static private TextView content = null;

    public static boolean isCheck(){
        if(currentFile == null) return false;
        if(title == null) return false;
        if(content == null) return false;
        return true;
    }


    public static void setCurrentFile(FileInfo f){
        currentFile = f;
    }
    public static void setTitle(TextView t){
        title = t;
    }
    public static void setContent(TextView t){
        content = t;
    }
    public static void adaptContent(){
        if(isCheck()){
            title.setText(currentFile.getFileName());
            try{
                content.setText(DataManager.loadText(currentFile));
            }catch(Exception e){
                Log.e("Error", e.getMessage());
            }
        }
    }
    public static FileInfo getCurrentFile(){
        return currentFile;
    }
}

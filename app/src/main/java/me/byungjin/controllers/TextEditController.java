package me.byungjin.controllers;

import android.util.Log;
import android.widget.EditText;

import com.example.notepad__.DataManagement.DataManager;
import com.example.notepad__.DataManagement.FileInfo;

public class TextEditController {
    //Current Memo File
    static private FileInfo currentFile = null;
    static private EditText title = null;
    static private EditText content = null;

    static public boolean isCheck(){
        if(currentFile == null) return false;
        if(title == null) return  false;
        if(content == null) return false;
        return true;
    }

    static public boolean update(){
        if(isCheck()){
            currentFile.setFileName(getTitleText());
            return true;
        }else{
            return false;
        }
    }

    static public void reset(){
        if(isCheck()){
            title.setText(currentFile.getFileName());
            if(!currentFile.getIsNew()){
                content.setText(DataManager.loadText(currentFile).trim());
            }
        }
    }

    //Setter and Getter
    static public void setCurrentFile(FileInfo f){
        currentFile = f;
    }
    static public FileInfo getCurrentFile(){
        return currentFile;
    }
    static public void setContent(EditText t){
        content = t;
    }
    static public String getContentText(){
        return content.getText().toString();
    }
    static public void setTitle(EditText t){
        title = t;
    }
    static public String getTitleText(){
        return title.getText().toString();
    }
}

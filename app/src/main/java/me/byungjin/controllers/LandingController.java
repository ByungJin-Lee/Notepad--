package me.byungjin.controllers;

import android.util.Log;

import com.example.notepad__.DataManagement.DataManager;
import com.example.notepad__.DataManagement.FileInfo;

import java.util.ArrayList;

import me.byungjin.Manager;
import me.byungjin.views.MemoNode;

public class LandingController {
    public static int countMemos = 0;
    //Start
    public static void start(){
        if(Manager.getMainActivityContext() != null && Manager.getMainActivityLinearLayout() != null){
            DataManager.search();
            initArrayList();
        }
    }
    public static void initArrayList(){
        //Get data todo
        for(int i = 0, size = DataManager.files.size(); i < size; i++){
            MemoNode m = new MemoNode(Manager.getMainActivityContext());
            m.setFile(DataManager.files.get(i));
            m.setText(m.getFile().getFileName());
            Manager.appendViewInMain(m);
            countMemos = i+1;
        }
    }
    public static int aNumberOfMemo(){
        return countMemos;
    }
}

package me.byungjin.controllers;

import com.example.notepad__.DataManagement.DataManager;
import com.example.notepad__.DataManagement.FileInfo;

import java.util.ArrayList;

import me.byungjin.Manager;
import me.byungjin.views.MemoNode;

public class LandingController {
    //Memos
    static private ArrayList<MemoNode> memos = new ArrayList<MemoNode>();
    //Start
    public static void start(){
        if(Manager.getMainActivityContext() != null && Manager.getMainActivityLinearLayout() != null){
            DataManager.search();
            initArrayList();
            appendAll();
        }
    }
    public static void initArrayList(){
        //Get data todo
        for(int i = 0, size = DataManager.files.size(); i < size; i++){
            MemoNode m = new MemoNode(Manager.getMainActivityContext());
            m.setFile(DataManager.files.get(i));
            memos.add(m);
        }
    }
    public static void appendAll(){
        for(MemoNode n : memos){
            n.setText(n.getFile().getFileName());
            Manager.appendViewInMain(n);
        }
    }
    public static int aNumberOfMemo(){
        return memos.size();
    }
}

package me.byungjin.controllers;

import android.content.Context;
import android.widget.LinearLayout;

import java.util.ArrayList;

import me.byungjin.datas.File;
import me.byungjin.views.MemoNode;

public class LandingController {
    //Test File List
    static private File[] filelist = new File[15];
    //Layout
    static public Context context = null;
    static public LinearLayout layout = null;
    //Memos
    static private ArrayList<MemoNode> memos = new ArrayList<MemoNode>();
    //Static
    public static void test(){
        for(int i = 0; i < filelist.length; i++){
            filelist[i] = new File("메모 "+i,""+i);
        }
    }
    public static void start(Context c, LinearLayout l){
        context = c;
        layout = l;
        test();
        if(context != null && layout != null){
            initArrayList();
            appendAll();
        }
    }
    public static void initArrayList(){
        //Get data todo
        for(File f : filelist){
            MemoNode m = new MemoNode(context);
            m.setFile(f);
            memos.add(m);
        }
    }
    public static void appendAll(){
        for(MemoNode n : memos){
            n.setText(n.getFile().getFileName());
            layout.addView(n);
        }
    }
    public static int aNumberOfMemo(){
        return memos.size();
    }
}

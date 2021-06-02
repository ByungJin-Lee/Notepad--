package me.byungjin.listeners;

import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.example.notepad__.MainActivity;
import com.example.notepad__.TextViewerActivity;

import me.byungjin.Manager;
import me.byungjin.controllers.TextViewController;
import me.byungjin.views.MemoNode;

public class NoteNodeListener implements View.OnClickListener {
    @Override
    public void onClick(View v) {
        if(v instanceof MemoNode){
            MemoNode target = (MemoNode) v;
            TextViewController.setCurrentFile(target.getFile());
            Intent textView = new Intent(Manager.getMainActivityContext(), TextViewerActivity.class);
            Manager.getMainActivityContext().startActivity(textView);
            Log.v("NoteNode", "Click!!");
        }
    }
}

package me.byungjin.listeners;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.example.notepad__.DataManagement.FileInfo;
import com.example.notepad__.TextEditorActivity;
import com.example.notepad__.test;

import me.byungjin.Manager;
import me.byungjin.controllers.TextEditController;

//This Class for new Note Btn Click Event
public class NewNoteListener implements View.OnClickListener {
    @Override
    public void onClick(View v) {
        Context currentContext = Manager.getMainActivityContext();

        FileInfo newFile = new FileInfo("No Title", true);
        TextEditController.setCurrentFile(newFile);
        //Switching
        Intent textEdit = new Intent(currentContext.getApplicationContext(), TextEditorActivity.class);
        currentContext.startActivity(textEdit);
    }
}

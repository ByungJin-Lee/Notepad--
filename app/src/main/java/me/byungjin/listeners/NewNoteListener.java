package me.byungjin.listeners;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.example.notepad__.DataManagement.DataManager;
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

        int howManyNoTitle = 0;
        for (FileInfo f: DataManager.files) {
            if (f.getFileName().startsWith("No Title"))
                howManyNoTitle++;
        }

        FileInfo newFile;
        if (howManyNoTitle == 0)
            newFile = new FileInfo("No Title", true);
        else
            newFile = new FileInfo("No Title (" + (howManyNoTitle + 1) + ")", true);
        TextEditController.setCurrentFile(newFile);

        //Switching
        Intent textEdit = new Intent(currentContext.getApplicationContext(), TextEditorActivity.class);
        currentContext.startActivity(textEdit);
    }
}

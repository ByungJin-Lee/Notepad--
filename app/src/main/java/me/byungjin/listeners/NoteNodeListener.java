package me.byungjin.listeners;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.notepad__.DataManagement.DataManager;
import com.example.notepad__.DataManagement.FileInfo;
import com.example.notepad__.TextEditorActivity;

import org.w3c.dom.Text;

import me.byungjin.Manager;
import me.byungjin.controllers.TextEditController;
import me.byungjin.views.MemoNode;

public class NoteNodeListener implements View.OnClickListener {
    @Override
    public void onClick(View v) {
        if (!(v instanceof TextView))
            return;

        Context currentContext = Manager.getMainActivityContext();

        FileInfo chosenFileInfo = null;
        for (FileInfo f : DataManager.files) {
            if (f.getFileName() == ((TextView)v).getText()) {
                chosenFileInfo = f;
                break;
            }
        }

        TextEditController.setCurrentFile(chosenFileInfo);

        //Switching
        Intent textEdit = new Intent(currentContext.getApplicationContext(), TextEditorActivity.class);
        currentContext.startActivity(textEdit);
    }
}

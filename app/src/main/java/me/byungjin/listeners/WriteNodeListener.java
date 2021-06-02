package me.byungjin.listeners;

import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.example.notepad__.TextEditorActivity;

import me.byungjin.Manager;
import me.byungjin.controllers.TextEditController;
import me.byungjin.controllers.TextViewController;

public class WriteNodeListener implements View.OnClickListener {
    @Override
    public void onClick(View v) {
        TextEditController.setCurrentFile(TextViewController.getCurrentFile());

        Intent textEdit = new Intent(Manager.getTextViewActivityContext(), TextEditorActivity.class);
        Manager.getTextViewActivityContext().startActivity(textEdit.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }
}

package me.byungjin.listeners;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.example.notepad__.TextEditorActivity;

import me.byungjin.Manager;

//This Class for new Note Btn Click Event
public class NewNoteListener implements View.OnClickListener {
    @Override
    public void onClick(View v) {
        Context currentContext = Manager.getMainActivityContext();
        Intent textEdit = new Intent(currentContext.getApplicationContext(), TextEditorActivity.class);
        currentContext.startActivity(textEdit);
    }
}

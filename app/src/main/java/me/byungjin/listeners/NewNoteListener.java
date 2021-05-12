package me.byungjin.listeners;

import android.util.Log;
import android.view.View;

//This Class for new Note Btn Click Event
public class NewNoteListener implements View.OnClickListener {
    @Override
    public void onClick(View v) {
        Log.v("NewNote", "Create!");
    }
}

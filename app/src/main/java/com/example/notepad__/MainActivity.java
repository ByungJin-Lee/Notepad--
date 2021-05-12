package com.example.notepad__;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import me.byungjin.controllers.LandingController;
import me.byungjin.listeners.NewNoteListener;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //NoteNodeCountText
        TextView noteNodeCount = (TextView) findViewById(R.id.noteCount);
        //New Note Button
        Button newNoteBtn = (Button) findViewById(R.id.newNoteBtn);
        newNoteBtn.setOnClickListener(new NewNoteListener());
        //LandingController
        LandingController.start(this, (LinearLayout) findViewById(R.id.innerLayout));
        noteNodeCount.setText("메모 "+LandingController.aNumberOfMemo()+"개");
    }
}
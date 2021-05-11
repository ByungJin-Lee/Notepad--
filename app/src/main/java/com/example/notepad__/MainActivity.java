package com.example.notepad__;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import me.byungjin.listener.NewNoteListener;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //New Note Button
        FloatingActionButton newNoteBtn = (FloatingActionButton) findViewById(R.id.fab_newNote);
        newNoteBtn.setOnClickListener(new NewNoteListener());
    }
}
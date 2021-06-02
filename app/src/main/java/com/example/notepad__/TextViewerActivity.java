package com.example.notepad__;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import me.byungjin.Manager;
import me.byungjin.controllers.TextViewController;
import me.byungjin.listeners.WriteNodeListener;

public class TextViewerActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_viewer);

        ((Button)findViewById(R.id.btn_goEdit)).setOnClickListener(new WriteNodeListener());

        Manager.setTextViewActivityContext(this);
        TextViewController.setTitle((TextView)findViewById(R.id.txt_title));
        TextViewController.setContent((TextView)findViewById(R.id.txt_content));
        TextViewController.adaptContent();
    }
}
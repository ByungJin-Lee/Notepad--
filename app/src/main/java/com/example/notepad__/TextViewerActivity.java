package com.example.notepad__;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class TextViewerActivity extends AppCompatActivity {

    TextView txt_title, txt_content;
    ImageButton btn_edit, btn_delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_viewer);

        txt_title = findViewById(R.id.txt_title);
        txt_content = findViewById(R.id.txt_content);
        btn_edit = findViewById(R.id.btn_edit);
        btn_delete = findViewById(R.id.btn_delete);

        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TextViewerActivity.this, TextEditorActivity.class);
                startActivity(i);
            }
        });
    }
}
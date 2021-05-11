package com.example.notepad__;

import com.example.notepad__._DataManagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;

public class TextEditorActivity extends AppCompatActivity {

    EditText et_title, et_content;
    ImageButton btn_undo, btn_redo, btn_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_editor);

        et_title = findViewById(R.id.et_title);
        et_content = findViewById(R.id.et_content);
        btn_undo = findViewById(R.id.btn_undo);
        btn_redo = findViewById(R.id.btn_redo);
        btn_save = findViewById(R.id.btn_save);
    }
}
package com.example.notepad__;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import org.w3c.dom.Text;

import me.byungjin.Manager;
import me.byungjin.controllers.TextEditController;
import me.byungjin.listeners.BackMainListener;
import me.byungjin.listeners.NewNoteListener;

public class TextEditorActivity extends AppCompatActivity {

    private Button backToMain = null;

    private void reset(){
        this.backToMain = (Button)findViewById(R.id.btn_backToMain);
        TextEditController.setTitle((EditText)findViewById(R.id.txt_content_title));
        TextEditController.setContent((EditText)findViewById(R.id.edit_textContent));
    }

    private void bindEvents(){
        if(this.backToMain != null){
            this.backToMain.setOnClickListener(new BackMainListener());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_editor);

        //Init
        this.reset();
        TextEditController.reset();
        //Manager
        Manager.setTextViewActivityContext(this);
        //BindEvents
        this.bindEvents();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();      // 뒤로 가기
        new BackMainListener().onClick(null);
        Toast
            .makeText(this, "저장되었습니다.", Toast.LENGTH_LONG)
            .show();
    }
}
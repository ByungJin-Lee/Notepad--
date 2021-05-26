package com.example.notepad__;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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

    private Button      backToMain      = null;
    private EditText    et_title        = null;
    private EditText    et_textContent  = null;
    private boolean     isEdited        = false;
    private TextWatcher WatcherIfEdited = new TextWatcher() {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            isEdited = true;
        }
        @Override public void afterTextChanged(Editable arg0) {}
        @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
    };

    private void reset(){
        backToMain      = findViewById(R.id.btn_backToMain);
        et_title        = findViewById(R.id.txt_content_title);
        et_textContent  = findViewById(R.id.edit_textContent);

        TextEditController.setTitle(et_title);
        TextEditController.setContent(et_textContent);
    }

    private void bindEvents(){
        if(this.backToMain != null){
            this.backToMain.setOnClickListener(new BackMainListener());
        }
        et_title.addTextChangedListener(WatcherIfEdited);
        et_textContent.addTextChangedListener(WatcherIfEdited);
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
        if (isEdited) {             // 파일이 수정되었으면 저장
            new BackMainListener().onClick(null);
            Toast.makeText(this, "변경사항이 저장되었습니다.", Toast.LENGTH_LONG).show();
        }
    }


}
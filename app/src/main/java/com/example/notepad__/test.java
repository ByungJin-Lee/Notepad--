package com.example.notepad__;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.notepad__._DataManagement;

public class test extends AppCompatActivity {

    Button btn_scan, btn_create, btn_delete, btn_showPath;
    TextView txt_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        btn_scan = findViewById(R.id.btn_scan);
        btn_create = findViewById(R.id.btn_create);
        btn_delete = findViewById(R.id.btn_deleteTest);
        btn_showPath = findViewById(R.id.btn_showPath);
        txt_test = findViewById(R.id.txt_test);

        btn_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = new String();
                boolean res = DataManager.search();
                str += String.valueOf(res) + '\n';

                for (FileInfo file : DataManager.files)
                    str += file.index + ' ' + file.path;

                txt_test.setText(str);
            }
        });

        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btn_showPath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_test.setText(DataManager.DIR_PATH);
            }
        });
    }
}
package com.example.notepad__;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class test extends AppCompatActivity {

    Button btn_scan, btn_create, btn_delete, btn_showPath;
    TextView txt_test;
    EditText et_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        btn_scan = findViewById(R.id.btn_scan);
        btn_create = findViewById(R.id.btn_create);
        btn_delete = findViewById(R.id.btn_deleteTest);
        btn_showPath = findViewById(R.id.btn_showPath);
        txt_test = findViewById(R.id.txt_test);
        et_name = findViewById(R.id.et_tfileName);

        btn_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = "";
                boolean res = DataManager.search();
                str += String.valueOf(res) + '\n';

                if (!res) {
                    txt_test.setText(str);
                    return;
                }

                for (FileInfo file : DataManager.files)
                    str += file.index + " " + file.path + " " +  file.lastModified + "\n";

                txt_test.setText(str);
            }
        });

        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = "";
                FileInfo fi = new FileInfo(et_name.getText().toString(), DataManager.files.size());
                boolean res = DataManager.saveText(fi, "wa sans");

                str += String.valueOf(res) + '\n';

                if (!res) {
                    txt_test.setText(str);
                    return;
                }
                txt_test.setText(str);
                Log.v("알림", "onClick 종료");
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
                txt_test.setText(DMconst.DIR_PATH);
            }
        });
    }
}
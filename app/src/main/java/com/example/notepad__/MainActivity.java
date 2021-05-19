package com.example.notepad__;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.notepad__.DataManagement.DMconst;
import com.example.notepad__.DataManagement.DataManager;

import java.io.File;

import me.byungjin.Manager;
import me.byungjin.controllers.LandingController;
import me.byungjin.listeners.NewNoteListener;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void checkPermission(){
        if(checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
            (new File(DMconst.DIR_PATH)).mkdirs();
        }else{
            (new File(DMconst.DIR_PATH)).mkdirs();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 외부 저장소 권한 물어보기
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) // Marshmellow
            checkPermission();

        //Search Files
        File path = Environment.getExternalStoragePublicDirectory("/Notepad--");
        if(!path.exists()) path.mkdirs();
        //Manager
        Manager.setMainActivityContext(this);
        Manager.setMainActivityLinearLayout((LinearLayout)findViewById(R.id.innerLayout));
        //NoteNodeCountText
        TextView noteNodeCount = (TextView) findViewById(R.id.noteCount);
        //New Note Button
        Button newNoteBtn = (Button) findViewById(R.id.newNoteBtn);
        newNoteBtn.setOnClickListener(new NewNoteListener());
        //Landing
        LandingController.start();
        noteNodeCount.setText("메모 "+LandingController.aNumberOfMemo()+"개");
    }
}
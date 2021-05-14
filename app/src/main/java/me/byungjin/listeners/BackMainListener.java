package me.byungjin.listeners;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.example.notepad__.DataManagement.DataManager;
import com.example.notepad__.DataManagement.FileInfo;
import com.example.notepad__.MainActivity;

import me.byungjin.Manager;
import me.byungjin.controllers.TextEditController;

public class BackMainListener implements View.OnClickListener {
    @Override
    public void onClick(View v) {
        Context textEdit = Manager.getTextViewActivityContext();
        //현재 파일 저장
        if(TextEditController.update()){
            FileInfo newFile = TextEditController.getCurrentFile();
            DataManager.saveText(newFile, TextEditController.getContentText());
        }
        //메인으로 돌아가기
        Intent main = new Intent(textEdit.getApplicationContext(), MainActivity.class);
        textEdit.startActivity(main);
    }
}

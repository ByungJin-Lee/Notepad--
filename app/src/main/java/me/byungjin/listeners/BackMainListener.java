package me.byungjin.listeners;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.example.notepad__.DataManagement.DataManager;
import com.example.notepad__.DataManagement.FileInfo;
import com.example.notepad__.MainActivity;

import java.util.ArrayList;
import java.util.Arrays;

import me.byungjin.Manager;
import me.byungjin.controllers.TextEditController;

public class BackMainListener implements View.OnClickListener {
    @Override
    public void onClick(View v) {
        Context     textEdit    = Manager.getTextViewActivityContext();
        FileInfo    file        = TextEditController.getCurrentFile();

        //현재 파일 저장
        boolean isUpdated = TextEditController.update();
        if(isUpdated){
            String  oldFileName = file.getFileName();
            String  newFileName;

            // 경로의 마지막(파일명)을 바꾼 것을 file.setPath()의 인수로 함
            ArrayList<String> pathArray
                    = new ArrayList(Arrays.asList(file.getPath().split("/")));
            String            newPath   = "";

            pathArray.remove(pathArray.size() - 1);
            pathArray.add(file.getFileName());
            for (int i = 0; i < pathArray.size() - 1; i++) {
                newPath += pathArray.get(i) + "/";
            }
            newFileName = pathArray.get(pathArray.size() - 1);
            newPath += newFileName;

            file.setPath(newPath);
        }
        DataManager.saveText(file, TextEditController.getContentText());

        //메인으로 돌아가기
        Intent main = new Intent(textEdit, MainActivity.class);
        textEdit.startActivity(main);
    }
}

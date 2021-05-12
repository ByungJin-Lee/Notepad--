package me.byungjin.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import me.byungjin.controllers.LandingController;
import me.byungjin.datas.File;
import me.byungjin.listeners.NoteNodeListener;

import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;

import com.example.notepad__.R;

public class MemoNode extends AppCompatButton {
    //Variables
    private String content = "";
    private String title = "";
    private boolean isModified = false;
    private File file;
    //Constructor
    public MemoNode(Context context){
        super(context);
        this.bindEvents();
        this.init();
    }
    public MemoNode(Context context, AttributeSet attrs){
        super(context, attrs);
        this.init();
        this.bindEvents();
    }
    //Methods
    private void bindEvents(){
        this.setOnClickListener(new NoteNodeListener());
    }
    public boolean judgeModified(String _delta){
        if(title.equals(_delta)){
            return false;
        }else{
            return true;
        }
    }
    private void init(){
        setBackground(ContextCompat.getDrawable(LandingController.context, R.drawable.btn_memo));
    }

    //Getter and Setter
    public void setContent(String _content){
        content = _content;
    }
    public String getContent(){
        return content;
    }
    public void setFile(File _f){
        file = _f;
    }
    public File getFile(){
        return file;
    }
    public void setTitle(String _title){
        title = _title;
    }
    public String getTile(){
        return title;
    }
    public void setIsModified(boolean _isM){
        isModified = _isM;
    }
    public boolean getIsModified(){
        return isModified;
    }
}

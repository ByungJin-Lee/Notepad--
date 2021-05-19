package me.byungjin;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

public class Manager {
    //Main
    static private Context mainActivityContext = null;
    static private LinearLayout mainActivityLinearLayout = null;
    //TextView
    static private Context textViewActivityContext = null;
    static private LinearLayout textViewActivityLinearLayout = null;
    //Layout
    //Methods
    static public void appendViewInMain(View v){
        if(mainActivityLinearLayout != null){
            mainActivityLinearLayout.removeView(v);
            mainActivityLinearLayout.addView(v);
        }
    }
    static public void appendViewInTextView(View v){
        if(textViewActivityLinearLayout != null){
            textViewActivityLinearLayout.addView(v);
        }
    }
    //Getter and Setter
    static public Context getMainActivityContext(){
        return mainActivityContext;
    }
    static public void setMainActivityContext(Context c){
        mainActivityContext = c;
    }
    static public LinearLayout getMainActivityLinearLayout(){
        return mainActivityLinearLayout;
    }
    static public void setMainActivityLinearLayout(LinearLayout l){
        mainActivityLinearLayout = l;
    }
    static public Context getTextViewActivityContext(){
        return textViewActivityContext;
    }
    static public void setTextViewActivityContext(Context c){
        textViewActivityContext = c;
    }
    static public void setTextViewActivityLinearLayout(LinearLayout l){
        textViewActivityLinearLayout = l;
    }
    static public LinearLayout getTextViewActivityLinearLayout(){
        return textViewActivityLinearLayout;
    }
}

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
    //TextEdit
    private static Context textEditActivityContext = null;
    //Layout
    //Methods
    static public void appendViewInMain(View v){
        if(mainActivityLinearLayout != null){
            mainActivityLinearLayout.removeView(v);
            mainActivityLinearLayout.addView(v);
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

    static public Context getTextViewActivityContext(){ return textViewActivityContext; }
    static public void setTextViewActivityContext(Context c){ textViewActivityContext = c; }
    public static void setTextEditActivityContext(Context c){textEditActivityContext = c;}
    public static Context getTextEditActivityContext() {return textEditActivityContext;}
}

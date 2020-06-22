package com.example.uasmp;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SharedPreference {

    public static final String Prefs_name = "Shared_Pref_aplikasi";

    public SharedPreference(){
        super();
    }

    public void save(Context context,String key,String text){
        SharedPreferences settings;
        Editor editor;

        settings = context.getSharedPreferences(Prefs_name, Context.MODE_PRIVATE);
        editor = settings.edit();

        editor.putString(key, text);
        editor.commit();
    }

    public String getValue(Context context,String key){
        SharedPreferences settings;
        String text;

        settings = context.getSharedPreferences(Prefs_name, Context.MODE_PRIVATE);
        text = settings.getString(key, null);
        return text;
    }

    public void clearSharedPreference(Context context){
        SharedPreferences settings;
        Editor editor;

        settings = context.getSharedPreferences(Prefs_name, Context.MODE_PRIVATE);
        editor = settings.edit();

        editor.clear();
        editor.commit();
    }
}

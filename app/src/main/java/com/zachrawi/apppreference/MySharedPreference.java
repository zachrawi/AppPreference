package com.zachrawi.apppreference;

import android.content.Context;
import android.content.SharedPreferences;

public class MySharedPreference {
    private static final String PREF_NAME = "pref_name";
    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";

    private Context mContext;
    private SharedPreferences sharedPreferences;

    public MySharedPreference(Context context) {
        this.mContext = context;

        sharedPreferences = mContext.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }


    public String getName() {
        return sharedPreferences.getString(KEY_NAME, null);
    }

    public String getEmail() {
        return sharedPreferences.getString(KEY_EMAIL, null);
    }

    public void saveName(String name) {
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(KEY_NAME, name);
        editor.apply();
    }

    public void saveEmail(String email) {
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(KEY_EMAIL, email);
        editor.apply();
    }
}

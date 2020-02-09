package com.zachrawi.apppreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FragmentForm.OnSaveListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MySharedPreference mySharedPreference = new MySharedPreference(this);

        if (mySharedPreference.getName() == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frameLayout, new FragmentForm())
                    .commit();
        } else {
            FragmentWelcome fragmentWelcome = FragmentWelcome
                    .newInstance(mySharedPreference.getName(), mySharedPreference.getEmail());

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frameLayout, fragmentWelcome)
                    .commit();
        }
    }

    @Override
    public void onSave() {
        MySharedPreference mySharedPreference = new MySharedPreference(this);

        FragmentWelcome fragmentWelcome = FragmentWelcome
                .newInstance(mySharedPreference.getName(), mySharedPreference.getEmail());

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameLayout, fragmentWelcome)
                .commit();
    }
}

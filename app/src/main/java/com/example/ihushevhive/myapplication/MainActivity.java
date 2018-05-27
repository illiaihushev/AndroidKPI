package com.example.ihushevhive.myapplication;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;

public class MainActivity extends Activity {
    private String chosenCategory;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fragment fragmentResult = getFragmentManager().findFragmentById(R.layout.fragment_result_main);
    }
}

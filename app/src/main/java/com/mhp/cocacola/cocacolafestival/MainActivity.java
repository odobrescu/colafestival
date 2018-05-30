package com.mhp.cocacola.cocacolafestival;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 0);

        this.setContentView(R.layout.activity_main);

    }

    public void enterQuiz(View view) {

        Button next = (Button) findViewById(R.id.buttonStart);
        Intent myIntent = new Intent(view.getContext(), FormActivity.class);
        startActivityForResult(myIntent, 0);
        }
}

package com.mhp.cocacola.cocacolafestival;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
    }

    public void didTapContinue(View view) {
        Button next = (Button) findViewById(R.id.continueButton);
        Intent myIntent = new Intent(view.getContext(), FirstQuestion.class);
        startActivityForResult(myIntent, 0);
    }
}

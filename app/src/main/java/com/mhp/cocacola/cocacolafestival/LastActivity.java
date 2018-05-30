package com.mhp.cocacola.cocacolafestival;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class LastActivity extends AppCompatActivity {

    private TextView text, textResult;
    static int count=0;
    String[] results ={
            "Ești persoana care preia conducerea în grupul tău de prieteni, iar persoanele din jurul tău au încredere în deciziile tale.",
            "Pentru tine, experiența de festival este strâns legată de grupul tău de prieteni. Nu îți imaginezi participarea la astfel de evenimente fără să o împărtășești cu cei dragi.",
            "Ești o persoană plăcută, care își face noi prieteni cu foarte mare ușurință, așa că nu ai nicio problemă în a îți face bagajul și a pleca singur la un festival," +
                    " cu siguranță experiența pe care o vei trăi acolo va fi una extraordinară."
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);

        text = (TextView) findViewById(R.id.result);
        textResult = (TextView) findViewById(R.id.textResult);

        Intent intent= getIntent();
        String result = intent.getStringExtra("finalResult");

        count++;
        writeCountInFile(count);

        if (result.equals("LIDER")){
            textResult.setText(results[0]);
        }else if(result.equals("CONECTAT LA GRUP")){
            textResult.setText(results[1]);
        }else{
            textResult.setText(results[2]);
        }
        textResult.setTextSize(16);
        text.setTextSize(42);
        text.setText(result);
    }

    private void writeCountInFile(int count){
        //TODO
    }
}

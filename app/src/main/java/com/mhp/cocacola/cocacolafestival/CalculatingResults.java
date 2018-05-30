package com.mhp.cocacola.cocacolafestival;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CalculatingResults extends AppCompatActivity {
    String finalResult ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculating_results);


        Intent myIntent=getIntent();
        String[] result = myIntent.getStringArrayExtra("result");
        List<String> list = Arrays.asList(result);

        int liderNumber = Collections.frequency(list, "Lider");
        int conectatNumber = Collections.frequency(list, "Conectat la grup");
        int spontan = Collections.frequency(list, "Spontan");


        if(liderNumber>spontan){
            if(liderNumber>conectatNumber){
                finalResult = "LIDER";
            }else if(liderNumber<conectatNumber){
                finalResult="CONECTAT LA GRUP";
            }else{
                finalResult=randomString("LIDER","CONECTAT LA GRUP");
            }
        }else if(liderNumber<spontan) {
            if(spontan>conectatNumber){
                finalResult="SPONTAN";
            }else if(spontan<conectatNumber){
                finalResult = "CONECTAT LA GRUP";
            }
            else{
               finalResult= randomString("CONECTAT LA GRUP","SPONTAN");
            }
        }else{
           finalResult= randomString("LIDER", "SPONTAN");
        }


        Runnable r = new Runnable() {

            @Override
            public void run() {
                // if you are redirecting from a fragment then use getActivity() as the context.
                Intent intent=new Intent(CalculatingResults.this, LastActivity.class);
                intent.putExtra("finalResult",finalResult);
                startActivity(intent);

            }
        };


        Handler h = new Handler();
        // The Runnable will be executed after the given delay time
        h.postDelayed(r, 1500); // will be delayed for 1.5 seconds

    }


    private String randomString(String a, String b){

        String [] arr = {a,b};
        Random random = new Random();
        int select = random.nextInt(arr.length);

        return arr[select];
    }


}

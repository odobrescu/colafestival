package com.mhp.cocacola.cocacolafestival;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

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
        writeFileOnInternalStorage(getBaseContext(),"ColaResults.txt","Numar participanti: " );

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



    private void writeFileOnInternalStorage(Context mcoContext, String sFileName, String count){

        try {
            File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            if(!path.exists()){
                path.mkdirs();
            }

            File myFile = new File(path, "ColaFestival.txt");


            int length = (int) myFile.length();

            byte[] bytes = new byte[length];


            FileInputStream in = new FileInputStream(myFile);

            in.read(bytes);

            in.close();

            int numar2;
            String contents = new String(bytes);

            if (contents.length()>0){
                String  numar=  contents.substring(20);
                numar2= Integer.parseInt(numar);
                numar2++;
            }
            else{
                numar2=1;
            }
            FileOutputStream fOut = new FileOutputStream(myFile,false);
            OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
            String result =count+numar2;
            myOutWriter.append(result);
            myOutWriter.close();
            fOut.close();

            Toast.makeText(this,"Text file Saved !",Toast.LENGTH_LONG).show();
        }

        catch (Exception e) {
            Log.v("*********","***************************************"+ e);
            //do something if an IOException occurs.
            Toast.makeText(this,"ERROR - Text could't be added",Toast.LENGTH_LONG).show();
        }
    }

}

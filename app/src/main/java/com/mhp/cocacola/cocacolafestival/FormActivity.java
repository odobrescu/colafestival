package com.mhp.cocacola.cocacolafestival;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class FormActivity extends AppCompatActivity {

    String nume,prenume, email, adresa;
    EditText numeET, prenumeET, emailET, adresaET, birthday;
    Calendar myCalendar;
    DatePickerDialog.OnDateSetListener date;
    boolean hasDate=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);


        numeET = (EditText)findViewById(R.id.editTextNume);
        prenumeET = (EditText)findViewById(R.id.editTextPrenume);
        emailET = (EditText)findViewById(R.id.emailInput);
        adresaET = (EditText)findViewById(R.id.adressInput);
        birthday= (EditText) findViewById(R.id.birthDateInput);

        nume = numeET.getText().toString();
        prenume =  prenumeET.getText().toString();
        email = emailET.getText().toString();
        adresa =  adresaET.getText().toString();

       
       
        myCalendar = Calendar.getInstance();


         date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        birthday.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(FormActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

    }

    private void updateLabel() {

            String myFormat = "MM/dd/yy"; //In which you need put here
            SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        birthday.setText(sdf.format(myCalendar.getTime()));
        hasDate =true;
        }

    public void didTapContinue(View view) {

        TextValidator inputValidatorHelper = new TextValidator();
        //Validate and Next
        boolean isValidEmail=true;
        boolean allowSave = true;
        if (email == null && !inputValidatorHelper.isValidEmail(email)) {
            allowSave = false;
            isValidEmail=false;
        }
        if (birthday == null || birthday.getText().length()==0) {
            hasDate = false;
            allowSave = false;
        }
        if (numeET.getText().length()==0) {
            allowSave = false;
        }

        if (prenumeET.getText().length()==0) {
            allowSave = false;
        }
        if (adresaET.getText().length()==0) {
            allowSave = false;
        }

        if(allowSave){
            //Proceed with your save logic here
            Button next = (Button) findViewById(R.id.continueButton);
            Intent myIntent = new Intent(view.getContext(), FirstQuestion.class);
            startActivityForResult(myIntent, 0);
        }
        else {
            if(!hasDate){
                Toast.makeText(getApplicationContext(), "Te rugăm introdu o dată validă!",
                        Toast.LENGTH_SHORT).show();
            }else if(!isValidEmail){
                Toast.makeText(getApplicationContext(), "Te rugăm introdu o adresă de email validă!",
                        Toast.LENGTH_SHORT).show();
            }else{
            Toast.makeText(getApplicationContext(), "Te rugăm completează toate datele!",
                    Toast.LENGTH_SHORT).show();
            }
        }


    }

    public void didTapCiteste(View view) {
        Button citeste = (Button) findViewById(R.id.regulament);
        Intent myIntent = new Intent(view.getContext(), Regulament.class);
        startActivityForResult(myIntent, 0);
    }





}

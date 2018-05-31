package com.mhp.cocacola.cocacolafestival;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class FirstQuestion extends AppCompatActivity {

    private CheckBox checkBox1, checkBox2, checkBox3;
    private TextView textQuestionTextView;
    boolean isChecked =false;
    int step = 0;
    String[] questions={"1. Când se anunță datele unui festival, de obicei:",
                        "2. De obicei, la festivaluri, sunt însoțit de:",
                        "3. În general, la festivaluri merg pentru:" ,
                        "4. În timpul concertelor, îmi petrec timpul:",
                        "5. Câștigi un bilet la Untold. Ce faci?"};

    String[][] answers ={
            {"Îmi cumpăr bilete imediat ce se pun în vânzare","Aștept până în ultimul moment","Îi las pe prietenii mei să cumpere biletele"},
            {"Cei mai buni câțiva prieteni","Un grup cât mai mare de prieteni, pe care îl organizez în cel mai mic detaliu","Nimeni, merg singur, sigur mă voi întâlni cu prieteni sau îmi voi face prieteni noi acolo"},
            {"Experiență, mă bucur de festival de la un capăt până la celălalt","Muzică, merg doar dacă sunt prezenți artiștii mei favoriți","Petrecut timpul cu prietenii, ei sunt cel mai important aspect într-un festival reușit"},
            {"Dansând, doar am venit pentru muzică","Asigurându-mă că toți prietenii mei se distrează","Găsind o variantă de a ajunge în spatele scenei, vreau să îmi cunosc artistul preferat"},
            {"Merg să îmi fac bagajul, abia aștept să plec!","Mai conving câțiva prieteni să își cumpere bilete și mergem împreună","Îl fac cadou cuiva, nu pot să merg singur, iar restul prietenilor mei nu și-au luat bilete"}

    };
    String[] result=new String[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_question);

        checkBox1 = (CheckBox)findViewById(R.id.checkbox1);
        checkBox2 = (CheckBox)findViewById(R.id.checkbox2);
        checkBox3 = (CheckBox)findViewById(R.id.checkbox3);
        textQuestionTextView = (TextView) findViewById(R.id.textQuestion);

        changeText(step);
        step++;



    }


    public void didTapContinueQuiz(View view) {

        if(isChecked) {
            switch (step) {

                case (1): {
                    if (checkBox1.isChecked()) {
                        result[step - 1] = "Lider";
                    }
                    if (checkBox2.isChecked()) {
                        result[step - 1] = "Spontan";
                    }
                    if (checkBox3.isChecked()) {
                        result[step - 1] = "Conectat la grup";
                    }
                    changeText(step);
                    step++;
                    break;
                }
                case (2): {
                    if (checkBox1.isChecked()) {
                        result[step - 1] = "Conectat la grup";
                    }
                    if (checkBox2.isChecked()) {
                        result[step - 1] = "Lider";
                    }
                    if (checkBox3.isChecked()) {
                        result[step - 1] = "Spontan";
                    }

                    changeText(step);
                    step++;
                    break;
                }
                case (3): {
                    if (checkBox1.isChecked()) {
                        result[step - 1] = "Spontan";
                    }
                    if (checkBox2.isChecked()) {
                        result[step - 1] = "Lider";
                    }
                    if (checkBox3.isChecked()) {
                        result[step - 1] = "Conectat la grup";
                    }
                    changeText(step);
                    step++;
                    break;
                }
                case (4): {
                    if (checkBox1.isChecked()) {
                        result[step - 1] = "Lider";
                    }
                    if (checkBox2.isChecked()) {
                        result[step - 1] = "Conectat la grup";
                    }
                    if (checkBox3.isChecked()) {
                        result[step - 1] = "Spontan";
                    }
                    changeText(step);
                    step++;
                    break;
                }
                case (5): {
                    if (checkBox1.isChecked()) {
                        result[step - 1] = "Spontan";
                    }
                    if (checkBox2.isChecked()) {
                        result[step - 1] = "Lider";
                    }
                    if (checkBox3.isChecked()) {
                        result[step - 1] = "Conectat la grup";
                    }

                    Button next = (Button) findViewById(R.id.continueButton);
                    Intent myIntent = new Intent(view.getContext(), CalculatingResults.class);
                    myIntent.putExtra("result", result);
                    startActivityForResult(myIntent, 0);
                }

            }
        }else{
            Toast.makeText(getApplicationContext(), "Te rugam alege o varianta.",
                    Toast.LENGTH_SHORT).show();

        }
    }

    private void changeText(int i){
        isChecked=false;
        checkBox1.setChecked(false);
        checkBox2.setChecked(false);
        checkBox3.setChecked(false);
        textQuestionTextView.setText(questions[i]);
        checkBox1.setText(answers[i][0]);
        checkBox2.setText(answers[i][1]);
        checkBox3.setText(answers[i][2]);

    }


    public void onCheckboxClicked(View view) {

        switch(view.getId()) {

            case R.id.checkbox1:
                isChecked=true;
                checkBox1.setChecked(true);
                checkBox2.setChecked(false);
                checkBox3.setChecked(false);

                break;

            case R.id.checkbox2:
                isChecked=true;
                checkBox2.setChecked(true);
                checkBox1.setChecked(false);
                checkBox3.setChecked(false);

                break;

            case R.id.checkbox3:
                isChecked=true;
                checkBox3.setChecked(true);
                checkBox1.setChecked(false);
                checkBox2.setChecked(false);

                break;
        }
    }

}

package com.mhp.cocacola.cocacolafestival;

import android.animation.Animator;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CalculatingResults extends AppCompatActivity {
    String finalResult ="";
    ImageView planeta ;
    ImageView notaStanga, notaDreapta;

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

         planeta = (ImageView)findViewById(R.id.planeta);
         planeta.animate()
                 .rotation(100)
                .setDuration(1500)
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        planeta.animate()
                                .rotation(-100)
                                .setDuration(4000)
                                .setListener(new Animator.AnimatorListener() {
                                    @Override
                                    public void onAnimationStart(Animator animation) {
                                    }

                                    @Override
                                    public void onAnimationEnd(Animator animation) {
                                        // remove image view from framlayout
                                    }
                                    @Override
                                    public void onAnimationCancel(Animator animation) {
                                    }

                                    @Override
                                    public void onAnimationRepeat(Animator animation) {
                                    }
                                }).start();
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                }).start();


        notaDreapta = (ImageView) findViewById(R.id.notaMuzicalaDreapta);
        notaStanga = (ImageView) findViewById(R.id.notaMuzicalaStanga);



        notaStanga.animate()
                .translationX(100).translationY(50)
                .setDuration(1500)
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        notaStanga.animate()
                                .translationX(-100).translationY(-50)
                                .setDuration(1500)
                                .setListener(new Animator.AnimatorListener() {
                                    @Override
                                    public void onAnimationStart(Animator animation) {
                                    }

                                    @Override
                                    public void onAnimationEnd(Animator animation) {
                                        // remove image view from framlayout
                                    }
                                    @Override
                                    public void onAnimationCancel(Animator animation) {
                                    }

                                    @Override
                                    public void onAnimationRepeat(Animator animation) {
                                    }
                                }).start();
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                }).start();

        notaDreapta.animate()
                .translationX(-140)
                .translationY(130).rotation(14)
                .setDuration(700)
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        notaDreapta.animate()
                                .translationX((float)(150.0 * Math.sin(2.0*Math.PI)))
                                .translationY((float)(150.0 * Math.cos(2.0*Math.PI)))
                                .setDuration(1500)
                                .setListener(new Animator.AnimatorListener() {
                                    @Override
                                    public void onAnimationStart(Animator animation) {
                                    }

                                    @Override
                                    public void onAnimationEnd(Animator animation) {
                                        // remove image view from framlayout
                                    }
                                    @Override
                                    public void onAnimationCancel(Animator animation) {
                                    }

                                    @Override
                                    public void onAnimationRepeat(Animator animation) {
                                    }
                                }).start();
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                }).start();




        Handler h = new Handler();
        h.postDelayed(r, 3000); // will be delayed for 1.5 seconds

    }


    private String randomString(String a, String b){

        String [] arr = {a,b};
        Random random = new Random();
        int select = random.nextInt(arr.length);

        return arr[select];
    }




}

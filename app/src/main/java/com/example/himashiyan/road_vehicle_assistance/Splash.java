package com.example.himashiyan.road_vehicle_assistance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;


public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);


//        ImageView imageView = findViewById(R.id.splashLogo);
        Animation animation  = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade);
//        imageView.startAnimation(animation);

        Thread timer = new Thread(){

            @Override
            public  void run(){

                try{

                    sleep(4000);
                    Intent intent = new Intent(getApplicationContext(),opening.class);
                    startActivity(intent);
                    finish();
                    super.run();
                }catch (InterruptedException e){

                   e.printStackTrace();
                }
            }
        };

       timer.start();
    }
}

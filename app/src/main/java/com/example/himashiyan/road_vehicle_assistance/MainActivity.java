package com.example.himashiyan.road_vehicle_assistance;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawer;
    private ActionBarDrawerToggle mToggle;




//
//    @Override
//    protected  void onCreate(Bundle savedInstanceState){
//        super.onCreate(savedInstanceState);
////        setContentView(R.layout.signup);
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        
        //        User Profile Button

        final LinearLayout profile = (LinearLayout) findViewById(R.id.userprofile);


        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,customer_profile.class);
                startActivity(intent);
            }
        });

        //        location Button

        final LinearLayout locationsearch = (LinearLayout) findViewById(R.id.location);


        locationsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Location1.class);
                startActivity(intent);
            }
        });

    //             feedback Button

        final LinearLayout feedbackLyout = (LinearLayout) findViewById(R.id.layout);


        feedbackLyout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, feedback_Activity.class);
                startActivity(intent);
            }
        });

//      Recovery Button

        final LinearLayout recovery = (LinearLayout) findViewById(R.id.secondndlayout);


        recovery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Recovery.class);
                startActivity(intent);
            }
        });

//      Quick Guide Button

        final LinearLayout quick_guide = (LinearLayout) findViewById(R.id.secondndlayout_right);


       quick_guide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Quick_Gudie.class);
                startActivity(intent);
            }
        });

//      Contact Button

        final LinearLayout contact = (LinearLayout) findViewById(R.id.secondndlayout_right_coner);


        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Contact.class);
                startActivity(intent);
            }
        });









    }
}

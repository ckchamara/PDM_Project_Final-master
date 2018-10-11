package com.example.himashiyan.road_vehicle_assistance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.himashiyan.road_vehicle_assistance.Account_Activity.CustomerLogin;

public class opening extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening);


        final Button customer = (Button) findViewById(R.id.button4);
        final Button repair = (Button) findViewById(R.id.button5);



        customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(opening.this,CustomerLogin.class);
                startActivity(intent);
            }
        });

        repair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(opening.this,Garage_Login.class);
                startActivity(intent);
            }
        });



    }
}

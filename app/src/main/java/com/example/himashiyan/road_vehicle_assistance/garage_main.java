package com.example.himashiyan.road_vehicle_assistance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.himashiyan.road_vehicle_assistance.R;
import com.example.himashiyan.road_vehicle_assistance.services_main;
import com.example.himashiyan.road_vehicle_assistance.spareparts_main;
import com.example.himashiyan.road_vehicle_assistance.wishlist_spareparts;

public class garage_main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garage_main);

        //services button
        final Button services = (Button) findViewById(R.id.garage_main_button1);

        services.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(garage_main.this,services_main.class);
                startActivity(intent);
            }
        });

        //spare parts button
        final Button spareparts = (Button) findViewById(R.id.garage_main_button2);

        spareparts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(garage_main.this,spareparts_main.class);
                startActivity(intent);
            }
        });

        //wish list button
        final Button wishlist = (Button) findViewById(R.id.garage_main_button3);

        wishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(garage_main.this,wishlist_spareparts.class);
                startActivity(intent);
            }
        });
    }
}

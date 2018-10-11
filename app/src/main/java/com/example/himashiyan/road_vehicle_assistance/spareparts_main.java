package com.example.himashiyan.road_vehicle_assistance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class spareparts_main extends AppCompatActivity {

    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spareparts_main);

        ListView listview = (ListView) findViewById(R.id.spareparts_main_listview);
        EditText theFilter = (EditText) findViewById(R.id.spareparts_main_searchFilter);

        final ArrayList<String> parts = new ArrayList<>();
        parts.add("Air Filter");
        parts.add("Air Bag");
        parts.add("Alternator");
        parts.add("Ammeter");
        parts.add("Anti-Lock Braking System");
        parts.add("Antistatic Device");
        parts.add("Automotive Battery");
        parts.add("Automotive Navigation System");
        parts.add("Backup Camera");
        parts.add("Ball Joint");
        parts.add("Beam Axle");
        parts.add("Bearing");
        parts.add("Bell Housing");
        parts.add("Belt");
        parts.add("Bench Seat");
        parts.add("Brake Shoe");
        parts.add("Bucket Seat");
        parts.add("Bumper");
        parts.add("Camshaft");
        parts.add("Car Controls");
      /*parts.add("Car Glass");
        parts.add("Car Seat");
        parts.add("Carburetor");
        parts.add("Catalytic Converter");
        parts.add("Canter Console");
        parts.add("Chassis");
        parts.add("Clutch");
        parts.add("Connecting Rod");
        parts.add("Control Arm");
        parts.add("Crankcase Ventilation System");
        parts.add("Crankshaft");
        parts.add("Crankshaft Position Sensor");
        parts.add("Cruise Control");
        parts.add("Cylinder Block");
        parts.add("Cylinder Head");
        parts.add("Dashboard");
        parts.add("Diesel Engine");
        parts.add("Differential");
        parts.add("Disc Brake");
        parts.add("Distributor");*/

        adapter = new ArrayAdapter(this, R.layout.list_item_layout3, parts);
        listview.setAdapter(adapter);

        //spare parts list view item select
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(spareparts_main.this, "You Clicked on " +parts.get(position), Toast.LENGTH_SHORT).show();

                if (position == 0){
                    Intent appInfo = new Intent(spareparts_main.this, sparepart1.class);
                    startActivity(appInfo);
                }
                if (position == 1){
                    Intent appInfo = new Intent(spareparts_main.this, sparepart2.class);
                    startActivity(appInfo);
                }
                if (position == 2){
                    Intent appInfo = new Intent(spareparts_main.this, sparepart3.class);
                    startActivity(appInfo);
                }
                if (position == 3){
                    Intent appInfo = new Intent(spareparts_main.this, sparepart4.class);
                    startActivity(appInfo);
                }
                if (position == 4){
                    Intent appInfo = new Intent(spareparts_main.this, sparepart5.class);
                    startActivity(appInfo);
                }
                if (position == 5){
                    Intent appInfo = new Intent(spareparts_main.this, sparepart6.class);
                    startActivity(appInfo);
                }
                if (position == 6){
                    Intent appInfo = new Intent(spareparts_main.this, sparepart7.class);
                    startActivity(appInfo);
                }
                if (position == 7){
                    Intent appInfo = new Intent(spareparts_main.this, sparepart8.class);
                    startActivity(appInfo);
                }
                if (position == 8){
                    Intent appInfo = new Intent(spareparts_main.this, sparepart9.class);
                    startActivity(appInfo);
                }
                if (position == 9){
                    Intent appInfo = new Intent(spareparts_main.this, sparepart10.class);
                    startActivity(appInfo);
                }
                if (position == 10){
                    Intent appInfo = new Intent(spareparts_main.this, sparepart11.class);
                    startActivity(appInfo);
                }
                if (position == 11){
                    Intent appInfo = new Intent(spareparts_main.this, sparepart12.class);
                    startActivity(appInfo);
                }
                if (position == 12){
                    Intent appInfo = new Intent(spareparts_main.this, sparepart13.class);
                    startActivity(appInfo);
                }
                if (position == 13){
                    Intent appInfo = new Intent(spareparts_main.this, sparepart14.class);
                    startActivity(appInfo);
                }
                if (position == 14){
                    Intent appInfo = new Intent(spareparts_main.this, sparepart15.class);
                    startActivity(appInfo);
                }
                if (position == 15){
                    Intent appInfo = new Intent(spareparts_main.this, sparepart16.class);
                    startActivity(appInfo);
                }
                if (position == 16){
                    Intent appInfo = new Intent(spareparts_main.this, sparepart17.class);
                    startActivity(appInfo);
                }
                if (position == 17){
                    Intent appInfo = new Intent(spareparts_main.this, sparepart18.class);
                    startActivity(appInfo);
                }
                if (position == 18){
                    Intent appInfo = new Intent(spareparts_main.this, sparepart19.class);
                    startActivity(appInfo);
                }
                if (position == 19){
                    Intent appInfo = new Intent(spareparts_main.this, sparepart20.class);
                    startActivity(appInfo);
                }
            }
        });

        //search spare part edit text
        theFilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                (spareparts_main.this).adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}

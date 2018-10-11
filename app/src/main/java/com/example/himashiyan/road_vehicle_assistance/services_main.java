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

public class services_main extends AppCompatActivity {

    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services_main);

        ListView listview = (ListView) findViewById(R.id.services_main_listview);
        EditText theFilter = (EditText) findViewById(R.id.services_main_searchFilter);

        final ArrayList<String> parts = new ArrayList<>();
        parts.add("Accident Towing Service");
        parts.add("Battery Boost Service");
        parts.add("Extrication or Winching Service");
        parts.add("Flat Tyre Service");
        parts.add("Fuel Delivery Service");
        parts.add("Heavy Duty Towing");
        parts.add("Lock Out Service");
        parts.add("Lockout and Locksmith Service");
        parts.add("Mechanical Breakdown Service");
        parts.add("Replacement Battery");
        parts.add("New Vehicle Registration");
        parts.add("Vehicle Re-Registration");

        adapter = new ArrayAdapter(this, R.layout.list_item_layout2, parts);
        listview.setAdapter(adapter);

        //services list view item select
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(services_main.this, "You Clicked on " +parts.get(position), Toast.LENGTH_SHORT).show();

                if (position == 0){
                    Intent appInfo = new Intent(services_main.this, service1.class);
                    startActivity(appInfo);
                }
                if (position == 1){
                    Intent appInfo = new Intent(services_main.this, service2.class);
                    startActivity(appInfo);
                }
                if (position == 2){
                    Intent appInfo = new Intent(services_main.this, service3.class);
                    startActivity(appInfo);
                }
                if (position == 3){
                    Intent appInfo = new Intent(services_main.this, service4.class);
                    startActivity(appInfo);
                }
                if (position == 4){
                    Intent appInfo = new Intent(services_main.this, service5.class);
                    startActivity(appInfo);
                }
                if (position == 5){
                    Intent appInfo = new Intent(services_main.this, service6.class);
                    startActivity(appInfo);
                }
                if (position == 6){
                    Intent appInfo = new Intent(services_main.this, service7.class);
                    startActivity(appInfo);
                }
                if (position == 7){
                    Intent appInfo = new Intent(services_main.this, service8.class);
                    startActivity(appInfo);
                }
                if (position == 8){
                    Intent appInfo = new Intent(services_main.this, service9.class);
                    startActivity(appInfo);
                }
                if (position == 9){
                    Intent appInfo = new Intent(services_main.this, service10.class);
                    startActivity(appInfo);
                }
                if (position == 10){
                    Intent appInfo = new Intent(services_main.this, service11.class);
                    startActivity(appInfo);
                }
                if (position == 11){
                    Intent appInfo = new Intent(services_main.this, service12.class);
                    startActivity(appInfo);
                }
            }
        });

        //search service edit text
        theFilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                (services_main.this).adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}

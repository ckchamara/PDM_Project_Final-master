package com.example.himashiyan.road_vehicle_assistance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class service3 extends AppCompatActivity {

    private DatabaseReference namedatabase;
    private TextView nametextview;
    private DatabaseReference descriptiondatabase;
    private TextView descriptiontextview;
    private DatabaseReference pricedatabase;
    private TextView pricetextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service3);

        //name text view
        namedatabase = FirebaseDatabase.getInstance().getReference().child("Services").child("03").child("name");
        nametextview = (TextView) findViewById(R.id.service3_textview1);
        namedatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String name = dataSnapshot.getValue().toString();
                nametextview.setText(name);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        //description text view
        descriptiondatabase = FirebaseDatabase.getInstance().getReference().child("Services").child("03").child("description");
        descriptiontextview = (TextView) findViewById(R.id.service3_textview2);
        descriptiondatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String name = dataSnapshot.getValue().toString();
                descriptiontextview.setText(name);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        //price text view
        pricedatabase = FirebaseDatabase.getInstance().getReference().child("Services").child("03").child("cost");
        pricetextview = (TextView) findViewById(R.id.service3_textview3);
        pricedatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String name = dataSnapshot.getValue().toString();
                pricetextview.setText(name);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}

package com.example.himashiyan.road_vehicle_assistance;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class sparepart12 extends AppCompatActivity {

    private DatabaseReference namedatabase;
    private TextView nametextview;
    private DatabaseReference descriptiondatabase;
    private TextView descriptiontextview;
    private DatabaseReference pricedatabase;
    private TextView pricetextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sparepart12);

        //name text view
        namedatabase = FirebaseDatabase.getInstance().getReference().child("Parts").child("12").child("name");
        nametextview = (TextView) findViewById(R.id.sparepart12_textview1);
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

        /*//description text view
        descriptiondatabase = FirebaseDatabase.getInstance().getReference().child("Parts").child("12").child("description");
        descriptiontextview = (TextView) findViewById(R.id.sparepart12_textview2);
        descriptiondatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String name = dataSnapshot.getValue().toString();
                descriptiontextview.setText(name);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });*/

        //price text view
        pricedatabase = FirebaseDatabase.getInstance().getReference().child("Parts").child("12").child("price");
        pricetextview = (TextView) findViewById(R.id.sparepart12_textview3);
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

package com.example.himashiyan.road_vehicle_assistance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class wishlist_spareparts extends AppCompatActivity {

    private DatabaseReference pricedatabase;

    Spinner sp1;
    Spinner sp2;

    TextView display_data;

    String names[] = {"Air Filter","Air Bag","Alternator","Ammeter","Anti-Lock Braking System","Antistatic Device","Automotive Battery","Automotive Navigation System","Backup Camera","Ball Joint","Beam Axle","Bearing","Bell Housing","Belt","Bench Seat","Brake Shoe","Bucket Seat","Bumper","Camshaft","Car Controls"};

    ArrayAdapter <String> adapter;

    int record1= 0;
    int record2= 0;
    int i;
    int j;
    String spinner1itemname;
    String spinner2itemname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wishlist_spareparts);

        sp1 = (Spinner) findViewById(R.id.spinner1);
        sp2 = (Spinner) findViewById(R.id.spinner2);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,names);

        display_data = (TextView) findViewById(R.id.display_result);

        sp1.setAdapter(adapter);
        sp2.setAdapter(adapter);

        //get value from spinner1
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, final int position, long id) {
                if (position == 0){
                    pricedatabase = FirebaseDatabase.getInstance().getReference().child("Parts").child("01").child("price");
                    pricedatabase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String name = dataSnapshot.getValue().toString();
                            i = Integer.valueOf(name);
                            spinner1itemname = names[position];
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
                else if(position == 1){
                    pricedatabase = FirebaseDatabase.getInstance().getReference().child("Parts").child("02").child("price");
                    pricedatabase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String name = dataSnapshot.getValue().toString();
                            i = Integer.valueOf(name);
                            spinner1itemname = names[position];
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
                else if (position == 2){
                    pricedatabase = FirebaseDatabase.getInstance().getReference().child("Parts").child("03").child("price");
                    pricedatabase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String name = dataSnapshot.getValue().toString();
                            i = Integer.valueOf(name);
                            spinner1itemname = names[position];
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
                else if (position == 3){
                    pricedatabase = FirebaseDatabase.getInstance().getReference().child("Parts").child("04").child("price");
                    pricedatabase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String name = dataSnapshot.getValue().toString();
                            i = Integer.valueOf(name);
                            spinner1itemname = names[position];
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
                else if (position == 4){
                    pricedatabase = FirebaseDatabase.getInstance().getReference().child("Parts").child("05").child("price");
                    pricedatabase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String name = dataSnapshot.getValue().toString();
                            i = Integer.valueOf(name);
                            spinner1itemname = names[position];
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
                else if (position == 5){
                    pricedatabase = FirebaseDatabase.getInstance().getReference().child("Parts").child("06").child("price");
                    pricedatabase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String name = dataSnapshot.getValue().toString();
                            i = Integer.valueOf(name);
                            spinner1itemname = names[position];
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
                else if (position == 6){
                    pricedatabase = FirebaseDatabase.getInstance().getReference().child("Parts").child("07").child("price");
                    pricedatabase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String name = dataSnapshot.getValue().toString();
                            i = Integer.valueOf(name);
                            spinner1itemname = names[position];
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
                else if (position == 7){
                    pricedatabase = FirebaseDatabase.getInstance().getReference().child("Parts").child("08").child("price");
                    pricedatabase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String name = dataSnapshot.getValue().toString();
                            i = Integer.valueOf(name);
                            spinner1itemname = names[position];
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
                else if (position == 8){
                    pricedatabase = FirebaseDatabase.getInstance().getReference().child("Parts").child("09").child("price");
                    pricedatabase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String name = dataSnapshot.getValue().toString();
                            i = Integer.valueOf(name);
                            spinner1itemname = names[position];
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
                else if (position == 9){
                    pricedatabase = FirebaseDatabase.getInstance().getReference().child("Parts").child("10").child("price");
                    pricedatabase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String name = dataSnapshot.getValue().toString();
                            i = Integer.valueOf(name);
                            spinner1itemname = names[position];
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
                else if (position == 10){
                    pricedatabase = FirebaseDatabase.getInstance().getReference().child("Parts").child("11").child("price");
                    pricedatabase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String name = dataSnapshot.getValue().toString();
                            i = Integer.valueOf(name);
                            spinner1itemname = names[position];
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
                else if (position == 11){
                    pricedatabase = FirebaseDatabase.getInstance().getReference().child("Parts").child("12").child("price");
                    pricedatabase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String name = dataSnapshot.getValue().toString();
                            i = Integer.valueOf(name);
                            spinner1itemname = names[position];
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
                else if (position == 12){
                    pricedatabase = FirebaseDatabase.getInstance().getReference().child("Parts").child("13").child("price");
                    pricedatabase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String name = dataSnapshot.getValue().toString();
                            i = Integer.valueOf(name);
                            spinner1itemname = names[position];
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
                else if (position == 13){
                    pricedatabase = FirebaseDatabase.getInstance().getReference().child("Parts").child("14").child("price");
                    pricedatabase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String name = dataSnapshot.getValue().toString();
                            i = Integer.valueOf(name);
                            spinner1itemname = names[position];
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
                else if (position == 14){
                    pricedatabase = FirebaseDatabase.getInstance().getReference().child("Parts").child("15").child("price");
                    pricedatabase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String name = dataSnapshot.getValue().toString();
                            i = Integer.valueOf(name);
                            spinner1itemname = names[position];
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
                else if (position == 15){
                    pricedatabase = FirebaseDatabase.getInstance().getReference().child("Parts").child("16").child("price");
                    pricedatabase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String name = dataSnapshot.getValue().toString();
                            i = Integer.valueOf(name);
                            spinner1itemname = names[position];
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
                else if (position == 16){
                    pricedatabase = FirebaseDatabase.getInstance().getReference().child("Parts").child("17").child("price");
                    pricedatabase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String name = dataSnapshot.getValue().toString();
                            i = Integer.valueOf(name);
                            spinner1itemname = names[position];
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
                else if (position == 17){
                    pricedatabase = FirebaseDatabase.getInstance().getReference().child("Parts").child("18").child("price");
                    pricedatabase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String name = dataSnapshot.getValue().toString();
                            i = Integer.valueOf(name);
                            spinner1itemname = names[position];
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
                else if (position == 18){
                    pricedatabase = FirebaseDatabase.getInstance().getReference().child("Parts").child("19").child("price");
                    pricedatabase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String name = dataSnapshot.getValue().toString();
                            i = Integer.valueOf(name);
                            spinner1itemname = names[position];
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
                else if (position == 19){
                    pricedatabase = FirebaseDatabase.getInstance().getReference().child("Parts").child("20").child("price");
                    pricedatabase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String name = dataSnapshot.getValue().toString();
                            i = Integer.valueOf(name);
                            spinner1itemname = names[position];
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //get value from spinner2
        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, final int position, long id) {
                if (position == 0){
                    pricedatabase = FirebaseDatabase.getInstance().getReference().child("Parts").child("01").child("price");
                    pricedatabase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String name = dataSnapshot.getValue().toString();
                            j = Integer.valueOf(name);
                            spinner2itemname = names[position];
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
                else if(position == 1){
                    pricedatabase = FirebaseDatabase.getInstance().getReference().child("Parts").child("02").child("price");
                    pricedatabase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String name = dataSnapshot.getValue().toString();
                            j = Integer.valueOf(name);
                            spinner2itemname = names[position];
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
                else if (position == 2){
                    pricedatabase = FirebaseDatabase.getInstance().getReference().child("Parts").child("03").child("price");
                    pricedatabase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String name = dataSnapshot.getValue().toString();
                            j = Integer.valueOf(name);
                            spinner2itemname = names[position];
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
                else if (position == 3){
                    pricedatabase = FirebaseDatabase.getInstance().getReference().child("Parts").child("04").child("price");
                    pricedatabase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String name = dataSnapshot.getValue().toString();
                            j = Integer.valueOf(name);
                            spinner2itemname = names[position];
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
                else if (position == 4){
                    pricedatabase = FirebaseDatabase.getInstance().getReference().child("Parts").child("05").child("price");
                    pricedatabase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String name = dataSnapshot.getValue().toString();
                            j = Integer.valueOf(name);
                            spinner2itemname = names[position];
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
                else if (position == 5){
                    pricedatabase = FirebaseDatabase.getInstance().getReference().child("Parts").child("06").child("price");
                    pricedatabase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String name = dataSnapshot.getValue().toString();
                            j = Integer.valueOf(name);
                            spinner2itemname = names[position];
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
                else if (position == 6){
                    pricedatabase = FirebaseDatabase.getInstance().getReference().child("Parts").child("07").child("price");
                    pricedatabase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String name = dataSnapshot.getValue().toString();
                            j = Integer.valueOf(name);
                            spinner2itemname = names[position];
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
                else if (position == 7){
                    pricedatabase = FirebaseDatabase.getInstance().getReference().child("Parts").child("08").child("price");
                    pricedatabase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String name = dataSnapshot.getValue().toString();
                            j = Integer.valueOf(name);
                            spinner2itemname = names[position];
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
                else if (position == 8){
                    pricedatabase = FirebaseDatabase.getInstance().getReference().child("Parts").child("09").child("price");
                    pricedatabase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String name = dataSnapshot.getValue().toString();
                            j = Integer.valueOf(name);
                            spinner2itemname = names[position];
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
                else if (position == 9){
                    pricedatabase = FirebaseDatabase.getInstance().getReference().child("Parts").child("10").child("price");
                    pricedatabase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String name = dataSnapshot.getValue().toString();
                            j = Integer.valueOf(name);
                            spinner2itemname = names[position];
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
                else if (position == 10){
                    pricedatabase = FirebaseDatabase.getInstance().getReference().child("Parts").child("11").child("price");
                    pricedatabase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String name = dataSnapshot.getValue().toString();
                            j = Integer.valueOf(name);
                            spinner2itemname = names[position];
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
                else if (position == 11){
                    pricedatabase = FirebaseDatabase.getInstance().getReference().child("Parts").child("12").child("price");
                    pricedatabase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String name = dataSnapshot.getValue().toString();
                            j = Integer.valueOf(name);
                            spinner2itemname = names[position];
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
                else if (position == 12){
                    pricedatabase = FirebaseDatabase.getInstance().getReference().child("Parts").child("13").child("price");
                    pricedatabase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String name = dataSnapshot.getValue().toString();
                            j = Integer.valueOf(name);
                            spinner2itemname = names[position];
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
                else if (position == 13){
                    pricedatabase = FirebaseDatabase.getInstance().getReference().child("Parts").child("14").child("price");
                    pricedatabase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String name = dataSnapshot.getValue().toString();
                            j = Integer.valueOf(name);
                            spinner2itemname = names[position];
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
                else if (position == 14){
                    pricedatabase = FirebaseDatabase.getInstance().getReference().child("Parts").child("15").child("price");
                    pricedatabase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String name = dataSnapshot.getValue().toString();
                            j = Integer.valueOf(name);
                            spinner2itemname = names[position];
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
                else if (position == 15){
                    pricedatabase = FirebaseDatabase.getInstance().getReference().child("Parts").child("16").child("price");
                    pricedatabase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String name = dataSnapshot.getValue().toString();
                            j = Integer.valueOf(name);
                            spinner2itemname = names[position];
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
                else if (position == 16){
                    pricedatabase = FirebaseDatabase.getInstance().getReference().child("Parts").child("17").child("price");
                    pricedatabase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String name = dataSnapshot.getValue().toString();
                            j = Integer.valueOf(name);
                            spinner2itemname = names[position];
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
                else if (position == 17){
                    pricedatabase = FirebaseDatabase.getInstance().getReference().child("Parts").child("18").child("price");
                    pricedatabase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String name = dataSnapshot.getValue().toString();
                            j = Integer.valueOf(name);
                            spinner2itemname = names[position];
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
                else if (position == 18){
                    pricedatabase = FirebaseDatabase.getInstance().getReference().child("Parts").child("19").child("price");
                    pricedatabase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String name = dataSnapshot.getValue().toString();
                            j = Integer.valueOf(name);
                            spinner2itemname = names[position];
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
                else if (position == 19){
                    pricedatabase = FirebaseDatabase.getInstance().getReference().child("Parts").child("20").child("price");
                    pricedatabase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String name = dataSnapshot.getValue().toString();
                            j = Integer.valueOf(name);
                            spinner2itemname = names[position];
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    //cost button click event
    public void display_result(View view){
        int sum = i + j;
        display_data.setText("Total cost for " +spinner1itemname +" and " +spinner2itemname +" is $" + String.valueOf(sum));
    }
}

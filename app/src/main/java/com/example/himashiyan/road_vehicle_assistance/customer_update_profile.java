package com.example.himashiyan.road_vehicle_assistance;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.himashiyan.road_vehicle_assistance.models.Customer_info;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class customer_update_profile extends AppCompatActivity {
    // Variable declaration
    private Button saveimage;
    private EditText customerfName;
    private EditText customerlName;
    private EditText customerNic;
    private EditText customerContact;
    private static int PICK_IMAGE=123;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private FloatingActionButton fab;
    private Button Save_info;
    private  DatabaseReference Databasereference;


    ImageView profile_pic;
    private FirebaseStorage firebaseStorage;//Fire base database storage variable
    Uri img_url;
    private StorageReference storageReference,image_ref;  //storage reference variable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_update_profile);

        // Assign variables to ID's
        customerfName = findViewById(R.id.fn);
        customerlName = findViewById(R.id.ln);
        customerNic = findViewById(R.id.nic);
        customerContact = findViewById(R.id.con);

//        fab = findViewById(R.id.floatingActionButton);
        Save_info = findViewById(R.id.save);




        // Setup database connection
        firebaseAuth = FirebaseAuth.getInstance(); //FirebaseAuth Instance
        firebaseDatabase = FirebaseDatabase.getInstance(); //FirebaseDatabase Instance

        // Refer data by user ID
         Databasereference = firebaseDatabase.getReference("Vendors").child(firebaseAuth.getUid());//check here k,hl.;


        Databasereference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //Object creation
                Customer_info obj = dataSnapshot.getValue(Customer_info.class);

                // Fetch and set data to layout
                try {
                    customerfName.setText(obj.getFname());
                    customerlName.setText(obj.getLname());
                    customerNic.setText(obj.getNic());
                    customerContact.setText(obj.getContact());



                } catch (Exception e) {
                    //Toast.makeText(com.example.cryptic.garage_login.Garage_profile.this, "Null point exception", Toast.LENGTH_SHORT).show();

                }
            }

            // Error handling while fetching data
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Toast.makeText(.Garage_profile.this, databaseError.getCode(), Toast.LENGTH_SHORT).show();

            }

        });
        // Save edit info

        Save_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String lName= customerlName.getText().toString();
                String fname=customerfName.getText().toString();
                String nic=customerNic.getText().toString();
                String contact=customerContact.getText().toString();


                Customer_info obj=new Customer_info(fname, lName,nic,contact);
                Databasereference.setValue(obj);
                startActivity(new Intent(customer_update_profile.this, customer_profile.class));


            }
        });




    }}

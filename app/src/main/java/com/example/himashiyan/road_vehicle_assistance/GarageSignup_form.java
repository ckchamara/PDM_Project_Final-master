package com.example.himashiyan.road_vehicle_assistance;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class GarageSignup_form extends AppCompatActivity  {
    // Variable declaration

    private EditText r_Name;
    private EditText location;
    private EditText address;
    private EditText mobile;
    private EditText description;
    private Button signup;
    private DatabaseReference dr;
    private FirebaseAuth firebaseauth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garage_signupform);

        // Variable casting

        r_Name =findViewById(R.id.R_name);
        location =findViewById(R.id.R_location);
        address =findViewById(R.id.R_address);
        mobile =findViewById(R.id.R_contact);
        description=findViewById(R.id.R_description);
        signup =findViewById(R.id.Csf_button);
        dr = FirebaseDatabase.getInstance().getReference("addplace");


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Save_info();


            }
        });
    }

    private void Save_info() {

        String Name = r_Name.getText().toString().trim();
        String contact = mobile.getText().toString().trim();
        String Address = address.getText().toString().trim();
        String city = location.getText().toString().trim();
        String desc=description.getText().toString().trim();


        Garage_info obj = new Garage_info(Name,contact,city,Address,desc);
        firebaseauth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseauth.getCurrentUser();

        dr.child(user.getUid()).setValue(obj);
        Toast.makeText(this, "Account sucessfully created", Toast.LENGTH_SHORT).show();
        Intent k = new Intent(GarageSignup_form.this,com.example.himashiyan.road_vehicle_assistance.Garage_profile.class);
        startActivity(k);


}}




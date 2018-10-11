package com.example.himashiyan.road_vehicle_assistance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.himashiyan.road_vehicle_assistance.models.Customer_info;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Customer_Signup_Form extends AppCompatActivity {

    // Variable declaration

    private EditText f_Name;
    private EditText l_Name;

    private EditText nic;
    private EditText mobile;
    private Button signup;
    private DatabaseReference dr;
    private FirebaseAuth firebaseauth;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_signup_form);

        // Variable casting

        f_Name =findViewById(R.id.C_fname);
        l_Name =findViewById(R.id.C_lastname);
        nic =findViewById(R.id.C_nic);
        mobile =findViewById(R.id.C_contact);
        signup =findViewById(R.id.Csf_button);
        dr = FirebaseDatabase.getInstance().getReference("Vendors");

      /*  if (f_Name.getText().toString().equals("")) {
            f_Name.setError("Enter First Name");
        }
        else if(l_Name.getText().toString().equals("")) {
            l_Name.setError("Enter Second Name");
        }
        else if(nic.getText().toString().equals("")) {
            nic.setError("Enter NIC");
        }
        else if(mobile.getText().toString().equals("")) {
            mobile.setError("Enter Mobile number");
        }
        else if(mobile.getText().toString().length()<10) {
            mobile.setError("Enter a valid Mobile number");
        }
        else if(nic.getText().toString().length()<10) {
            nic.setError("Enter a valid NIC number");
        }
        else {*/


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Save_info();


            }
        });
    }



    private void Save_info() {

        String fName = f_Name.getText().toString().trim();
        String lName = l_Name.getText().toString().trim();
        String contact = mobile.getText().toString().trim();
        String NIC = nic.getText().toString().trim();


        Customer_info obj = new Customer_info(fName,lName,NIC,contact);
        firebaseauth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseauth.getCurrentUser();

        dr.child(user.getUid()).setValue(obj);
        Toast.makeText(this, "Account sucessfully created", Toast.LENGTH_SHORT).show();
        Intent k = new Intent(Customer_Signup_Form.this,com.example.himashiyan.road_vehicle_assistance.customer_profile.class);
        startActivity(k);


    }}


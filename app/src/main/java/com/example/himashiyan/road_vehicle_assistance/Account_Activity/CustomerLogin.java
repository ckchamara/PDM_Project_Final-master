package com.example.himashiyan.road_vehicle_assistance.Account_Activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.himashiyan.road_vehicle_assistance.Garage_Login;
import com.example.himashiyan.road_vehicle_assistance.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class CustomerLogin extends AppCompatActivity implements View.OnClickListener {

    // Variable declaration

    private TextView fps;
    private Button button;
    private EditText userName;
    private EditText phone;
    private TextView newacc;


    ProgressBar pb;
    private FirebaseAuth firebaseauth; //FirebaseAuth Instance



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Assign ID's to variables

        setContentView(R.layout.customer_login);
        newacc=findViewById(R.id.textView_acc);
        fps=findViewById(R.id.fps);
        firebaseauth = FirebaseAuth.getInstance();
        button = findViewById(R.id.C_loginbutton);
        userName=findViewById(R.id.C_username);
        phone = findViewById(R.id.C_password);
        //pb =findViewById(R.id.progressBar);


        button.setOnClickListener(this);
        newacc.setOnClickListener(this);
        fps.setOnClickListener(this);

    }





    // user customer_login function
    private void USER_login() {
        // check for blank space
        String uname = userName.getText().toString().trim();
        String pass = phone.getText().toString().trim();
        if (uname.isEmpty()) {
            userName.setError("Enter Username");
            userName.requestFocus();
            return;
        }
        // Email validation
        if (!Patterns.EMAIL_ADDRESS.matcher(uname).matches()) {
            userName.setError("Please Enter  a valid Username");
            userName.requestFocus();
            return;
        }
        // Password validation
        if (pass.isEmpty()) {
            phone.setError("Enter Password");
            phone.requestFocus();
            return;
        }

        if (pass.length() < 8) {
            phone.setError("Minimum length of password should be 10 characters");
            phone.requestFocus();
            return;
        }
        //pb.setVisibility(View.VISIBLE);

        // Authenticate user
        firebaseauth.signInWithEmailAndPassword(uname, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //pb.setVisibility(View.GONE);
                        if (task.isSuccessful()) {
                            //check_email();
                            // Intent cd=new Intent(Garage_Login.this, com.example.himashiyan.road_vehicle_assistance.Garage_profile.class);
                            //startActivity(cd);
                            startActivity(new Intent(CustomerLogin.this,  com.example.himashiyan.road_vehicle_assistance.MainActivity.class));

                            finish();



                        } else {
                            Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                        }

                    }

                });

    }


    // Email verification
    /*protected void check_email(){
        FirebaseUser firebaseUser=firebaseauth.getInstance().getCurrentUser();
        Boolean Emailflag=firebaseUser.isEmailVerified();
        if(Emailflag){
            startActivity(new Intent(CustomerLogin.this,  com.example.himashiyan.road_vehicle_assistance.Ma.class));
            Toast.makeText(CustomerLogin.this, "CustomerLogin successful", Toast.LENGTH_SHORT).show();
        }else {

            Toast.makeText(CustomerLogin.this, "Please verify your email 1st", Toast.LENGTH_SHORT).show();
            firebaseauth.signOut();
        }


    }*/

    // Onclick event function
    @Override
    public void onClick(View v) {
        if(v==button){
            USER_login();
        }
        if(v==newacc) {
            Intent b = new Intent(CustomerLogin.this,com.example.himashiyan.road_vehicle_assistance.Account_Activity.CustomerSignup.class);
            startActivity(b);
        }

        if(v==fps){
            Intent cd=new Intent(CustomerLogin.this, com.example.himashiyan.road_vehicle_assistance.Garage_Password_reset.class);
            startActivity(cd);

        }


    }
}



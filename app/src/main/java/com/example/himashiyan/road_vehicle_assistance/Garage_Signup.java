package com.example.himashiyan.road_vehicle_assistance;

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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

// class implementation

public class Garage_Signup extends AppCompatActivity implements View.OnClickListener{
    // variable declaration
    private Button r_button;
    private EditText username;
    private  EditText phone;
    private TextView r_txtview;
    private ProgressBar  pb;

    private FirebaseAuth firebaseauth; //FirebaseAuth Instance




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garagesignup);

        firebaseauth=FirebaseAuth.getInstance();

        // Assign Id's to variables
        r_button=findViewById(R.id.R_loginbutton);
        r_txtview=findViewById(R.id.textView55);
        username=findViewById(R.id.R_username);
        phone=findViewById(R.id.R_password);
        pb=findViewById(R.id.progressBar);

        r_button.setOnClickListener(this);
        r_txtview.setOnClickListener(this);


            }


    private  void reg_USER()
    {
        //Check for blank space

        String uname=username.getText().toString().trim();
        String pass=phone.getText().toString().trim();
        //check for Empty fields
        if(uname.isEmpty()){
            username.setError("Enter Username");
            username.requestFocus();
            return;
        }
        // Email validation
        if(!Patterns.EMAIL_ADDRESS.matcher(uname).matches()) {
            username.setError("Please Enter  a valid Username");
            username.requestFocus();
            return;
        }
        //check for Empty fields
        if(pass.isEmpty()){
            phone.setError("Enter Paaword");
            phone.requestFocus();
            return;
        }
        // Validate password length
        if(pass.length()<8){
            phone.setError("Minimum length of password should be 8 characters");
            phone.requestFocus();
            return;
        }
        // Progress bar animation
        pb.setVisibility(View.VISIBLE);

        // Crate login with email and password
        firebaseauth.createUserWithEmailAndPassword(uname,pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        pb.setVisibility(View.GONE);
                        if(task.isSuccessful())
                        {
                            Toast.makeText(Garage_Signup.this,"Account created",Toast.LENGTH_SHORT).show();
                            finish();
                            // redirection
                            Intent i = new Intent(Garage_Signup.this, GarageSignup_form.class);
                            startActivity(i);



                        }else{
                            // Check for users
                            if(task.getException()instanceof FirebaseAuthUserCollisionException){
                                Toast.makeText(getApplicationContext(),"Already a registered user",Toast.LENGTH_SHORT).show();
                            }
                            // Error handling
                            else{
                                Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_SHORT).show();

                            }

                        }
                    }
                });

    }

// Onclick event function
    @Override
    public void onClick(View v) {
        if(v==r_button){
            reg_USER();
        }
        if(v==r_txtview){
            Intent b = new Intent(Garage_Signup.this, Garage_Login.class);
            startActivity(b);
        }
    }
}

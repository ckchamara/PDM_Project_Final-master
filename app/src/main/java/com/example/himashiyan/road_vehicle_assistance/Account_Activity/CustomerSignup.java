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

import com.example.himashiyan.road_vehicle_assistance.Customer_Signup_Form;
import com.example.himashiyan.road_vehicle_assistance.GarageSignup_form;
import com.example.himashiyan.road_vehicle_assistance.Garage_Login;
import com.example.himashiyan.road_vehicle_assistance.Garage_Signup;
import com.example.himashiyan.road_vehicle_assistance.MainActivity;
import com.example.himashiyan.road_vehicle_assistance.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;


public class CustomerSignup extends AppCompatActivity implements View.OnClickListener{

    private Button C_button;
    private EditText username;
    private  EditText phone;
    private TextView C_txtview;
    private ProgressBar pb;

    private FirebaseAuth firebaseauth; //FirebaseAuth Instance






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_signup);

        firebaseauth=FirebaseAuth.getInstance();

        // Assign Id's to variables
        username=findViewById(R.id.C_username);
        phone=findViewById(R.id.C_password);
        C_button=findViewById(R.id.C_Signup);
        C_txtview=findViewById(R.id.C_login);

       // pb=findViewById(R.id.progressBar);

        C_button.setOnClickListener(this);
        C_txtview.setOnClickListener(this);


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
       // pb.setVisibility(View.VISIBLE);

        // Crate login with email and password
        firebaseauth.createUserWithEmailAndPassword(uname,pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //pb.setVisibility(View.GONE);
                        if(task.isSuccessful())
                        {
                            Toast.makeText(CustomerSignup.this,"Account created",Toast.LENGTH_SHORT).show();
                            finish();
                            // redirection
                            Intent i = new Intent(CustomerSignup.this, Customer_Signup_Form.class);
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
        if(v==C_button){
            reg_USER();
        }
        if(v==C_txtview){
            Intent b = new Intent(CustomerSignup.this, CustomerLogin.class);
            startActivity(b);
        }


    }
}


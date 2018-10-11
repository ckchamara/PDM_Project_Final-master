package com.example.himashiyan.road_vehicle_assistance;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;


public class Garage_Password_reset extends AppCompatActivity implements View.OnClickListener {
    // Variable declaration

    private EditText curruntEmail;
    private Button resetPassword;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_reset);
        resetPassword=findViewById(R.id.button3);
        curruntEmail=findViewById(R.id.editText13);
        firebaseAuth=FirebaseAuth.getInstance();

        resetPassword.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        //check for blank space
       String userEmail=curruntEmail.getText().toString().trim();
       // check user email filed
       if(userEmail.equals("")){

           Toast.makeText(this,"Please enter your registered email ID",Toast.LENGTH_SHORT).show();
       }else {
           firebaseAuth.sendPasswordResetEmail(userEmail).addOnCompleteListener(new OnCompleteListener<Void>() {
               @Override
               public void onComplete(@NonNull Task<Void> task) {
                   if(task.isSuccessful()){
                       Toast.makeText(Garage_Password_reset.this,"  Reset password has been sent to your Email",Toast.LENGTH_SHORT).show();
                       finish();
                       Intent c=new Intent(Garage_Password_reset.this,Garage_Login.class);
                       startActivity(c);

                   }else {
                       Toast.makeText(Garage_Password_reset.this,"Error while sending the password reset email",Toast.LENGTH_SHORT).show();
                   }
               }
           });

       }

    }
}

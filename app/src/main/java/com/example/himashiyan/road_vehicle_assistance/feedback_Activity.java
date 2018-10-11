package com.example.himashiyan.road_vehicle_assistance;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import com.example.himashiyan.road_vehicle_assistance.models.feedback;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;


public class feedback_Activity extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference reference;

    private EditText editTextDescription;
    private RatingBar mRatingBar;
    private  EditText titlepanel;




    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_);


        //initializing database reference
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("ParkingPlaces");



//        final RatingBar ratingRatingBar  = (RatingBar) findViewById(R.id.ratingBar);
        Button submitButton              = (Button) findViewById(R.id.submit_button);
        final TextView displyText1       = (TextView) findViewById(R.id.textratingup);
        editTextDescription              = (EditText) findViewById(R.id.TextDescription);
        mRatingBar                       = (RatingBar) findViewById(R.id.ratingBar);
        titlepanel                       =   (EditText) findViewById(R.id.editTitle);


                submitButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        displyText1.setText("Your Rating is:" + mRatingBar.getRating());



                        feedback();
                    }
                });
        //////////////////////////List View button////////////////////////////////////////////////////////

        final  TextView feedbackView =(TextView) findViewById(R.id.textView3);

        feedbackView.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(feedback_Activity.this, feedback_view.class);
               startActivity(intent);

            }
        }));



        final TextView feedbackAdd = (TextView) findViewById(R.id.textView4);

        feedbackAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(feedback_Activity.this, Additional_Feedback.class);
                startActivity(intent);

            }
        });
    }

    private void feedback() {

        String Description  = editTextDescription.getText().toString().trim();
        Float   rating      = mRatingBar.getRating();
        String  Title       = titlepanel.getText().toString().trim();


        if (!TextUtils.isEmpty(Description)) {

            String id = reference.push().getKey();


            feedback feedback = new feedback(id,rating,Title,Description);

            reference.child(id).setValue(feedback);



            Toast.makeText(this, "Description and Your rating Added", Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(this, "You Should Enter the Description", Toast.LENGTH_LONG).show();
        }
    }


}



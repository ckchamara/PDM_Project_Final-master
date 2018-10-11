package com.example.himashiyan.road_vehicle_assistance;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.himashiyan.road_vehicle_assistance.Account_Activity.CustomerLogin;
import com.example.himashiyan.road_vehicle_assistance.models.Customer_info;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class customer_profile extends AppCompatActivity {

    // Variable declaration
    private Button saveimage;
    private TextView customerfName;
    private TextView customerlName;
    private TextView customerNic;
    private TextView customerContact;
    private static int PICK_IMAGE=123;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private FloatingActionButton fab;
    private Button Edit_info;
    private Button signout;
    private Button Home;

    ImageView profile_pic;
    private FirebaseStorage firebaseStorage;//Fire base database storage variable
    Uri img_url;
    private StorageReference storageReference,image_ref;  //storage reference variable

    //menue window
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.logout_menue:{
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(customer_profile.this, CustomerLogin.class));

            }

            break;



            case R.id.home_menue:{

                startActivity(new Intent(customer_profile.this, MainActivity.class));

            }



        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_profile);

        // Assign variables to ID's
        customerfName = findViewById(R.id.fn);
        customerlName = findViewById(R.id.ln);
        customerNic = findViewById(R.id.nic);
        customerContact = findViewById(R.id.con);


        Edit_info = findViewById(R.id.edit);
        signout=findViewById(R.id.button7);
        Home=findViewById(R.id.button6);




        // Setup database connection
        firebaseAuth = FirebaseAuth.getInstance(); //FirebaseAuth Instance
        firebaseDatabase = FirebaseDatabase.getInstance(); //FirebaseDatabase Instance

        // Refer data by user ID
        DatabaseReference Databasereference = firebaseDatabase.getReference("Vendors").child(firebaseAuth.getUid());//check here k,hl.;


        Databasereference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //Object creation
                 Customer_info obj = dataSnapshot.getValue(Customer_info.class);

                // Fetch and set data to layout
                try {
                    customerfName.setText("First Name: "+obj.getFname());
                    customerlName.setText("Last Name: "+obj.getLname());
                    customerNic.setText("NIC: "+obj.getNic());
                    customerContact.setText("Contact: "+obj.getContact());



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


        //Editinfo

        Edit_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(customer_profile.this, customer_update_profile.class);
                startActivity(b);
            }
        });

        // home
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(customer_profile.this, MainActivity.class);
                startActivity(b);
            }
        });

        //sigmout
        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(customer_profile.this, CustomerLogin.class));

            }
        });

    }
}

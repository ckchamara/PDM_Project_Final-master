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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class Garage_update_profile extends AppCompatActivity {
    // Variable declaration
    private  Button saveimage;
    private EditText garageName;
    private EditText garageCity;
    private EditText garageAddress;
    private EditText garageContact;
    private EditText garageDescription;
    private static int PICK_IMAGE=123;
    private  FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private FloatingActionButton fab;
    private Button Save;
    private DatabaseReference Databasereference;
    ImageView profile_pic;
    private FirebaseStorage firebaseStorage;//Fire base database storage variable
    Uri img_url;
    private StorageReference storageReference,image_ref;  //storage reference variable


    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==PICK_IMAGE && resultCode==RESULT_OK && data.getData()!=null){
            img_url=data.getData();
            try {
                Bitmap bitmap= MediaStore.Images.Media.getBitmap(getContentResolver(),img_url);
                profile_pic.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }*/

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
                startActivity(new Intent(Garage_update_profile.this, Garage_Login.class));

            }
            break;

            case R.id.home_menue:{

                startActivity(new Intent(Garage_update_profile.this, Garage_Login.class));

            }
            break;




        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garage_update_profile);


        /*storageReference = firebaseStorage.getReference();// Storage reference instance
        firebaseStorage = FirebaseStorage.getInstance();// Firebase storage Instance

        //image chooser
        profile_pic.setOnClickListener(customer_signup_form View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =customer_signup_form Intent();
                intent.setType("image/*");
                intent.setAction(intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,"Select an image"),PICK_IMAGE);

            }
        });

       /* saveimage.setOnClickListener(customer_signup_form View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //----------------------------------------------------------------------------

                //------------------------------------------------------------------------------
                image_ref = storageReference.child(firebaseAuth.getUid()).child("images").child("profilepic");
                UploadTask uploadTask = image_ref.putFile(img_url);
                uploadTask.addOnFailureListener(customer_signup_form OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Garage_profile.this, "Failed to upload", Toast.LENGTH_SHORT).show();

                    }
                }).addOnSuccessListener(customer_signup_form OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        Toast.makeText(Garage_profile.this, "upload ok", Toast.LENGTH_SHORT).show();

                    }

                });

*/
        // Assign variables to ID's
        garageName = findViewById(R.id.fn);
        garageAddress = findViewById(R.id.con);
        garageCity = findViewById(R.id.ln);
        garageContact = findViewById(R.id.nic);
        garageDescription = findViewById(R.id.editText2);

        Save = findViewById(R.id.save);
        saveimage = findViewById(R.id.button2);


        // Setup database connection
        firebaseAuth = FirebaseAuth.getInstance(); //FirebaseAuth Instance
        firebaseDatabase = FirebaseDatabase.getInstance(); //FirebaseDatabase Instance

        // Refer data by user ID
         Databasereference = firebaseDatabase.getReference("addplace").child(firebaseAuth.getUid());


        Databasereference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //Object creation
                Garage_info obj = dataSnapshot.getValue(Garage_info.class);

                // Fetch and set data to layout
                try {
                    garageName.setText(obj.getGaragename());
                    garageCity.setText(obj.getCity());
                    garageContact.setText(obj.getContact());
                    garageAddress.setText(obj.getCurruntcity());
                    garageDescription.setText(obj.getDescription());


                } catch (Exception e) {
                    Toast.makeText(Garage_update_profile.this, "Null point exception", Toast.LENGTH_SHORT).show();

                }
            }

            // Error handling while fetching data
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Garage_update_profile.this, databaseError.getCode(), Toast.LENGTH_SHORT).show();

            }

        });

        // Save edit info

        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String gName=garageName.getText().toString();
                String gCity=garageCity.getText().toString();
                String gContact=garageContact.getText().toString();
                String gAddress=garageAddress.getText().toString();
                String gDescription=garageDescription.getText().toString();

                Garage_info obj=new Garage_info( gName,gContact,gCity,gAddress,gDescription);
                Databasereference.setValue(obj);
                startActivity(new Intent(Garage_update_profile.this, Garage_profile.class));


            }
        });




    }}
//});






//}}


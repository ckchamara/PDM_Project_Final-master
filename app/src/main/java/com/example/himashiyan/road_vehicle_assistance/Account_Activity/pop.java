package com.example.himashiyan.road_vehicle_assistance.Account_Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.himashiyan.road_vehicle_assistance.Location.Garages;
import com.example.himashiyan.road_vehicle_assistance.R;
import com.example.himashiyan.road_vehicle_assistance.marker1;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;



//Java class for popup window
public class pop extends AppCompatActivity   {


    private TextView GarageNameTextView;
    private TextView GarageAddrTextView;
    private TextView GarageContactTextView;

    private Button call1;
    private Button whatsapp1;
    private Button viber1;

    private String addr;
    private String name;
    private String formatedPhone;



    DatabaseReference dbGarages;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.garagepopup_1);


        GarageNameTextView = (TextView) findViewById(R.id.nameView);
        GarageAddrTextView = (TextView) findViewById(R.id.addresView);
        GarageContactTextView = (TextView) findViewById(R.id.phoneView);

        call1 = (Button) findViewById(R.id.callbtn);
        whatsapp1 = (Button) findViewById(R.id.whatsappbtn);
        viber1 = (Button) findViewById(R.id.viberbtn);



        call1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+formatedPhone));
                startActivity(intent);

            }
        });

        whatsapp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://api.whatsapp.com/send?phone="+formatedPhone;
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        viber1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent smsIntent = new Intent(Intent.ACTION_SENDTO);
                smsIntent.addCategory(Intent.CATEGORY_DEFAULT);
                smsIntent.setPackage("com.viber.voip");
                smsIntent.setData(Uri.parse("sms:+1001002003"));
                smsIntent.putExtra("address", "+1001002003");
                smsIntent.putExtra("sms_body", "body  text");
                startActivity(smsIntent);
            }
        });

        dbGarages= FirebaseDatabase.getInstance().getReference("Garages");

        marker1 marker1 = new marker1();
        marker1.setMarkerLat(marker1.getMarkerLat());
        String lat=String.valueOf(marker1.getMarkerLat());

        Toast.makeText(pop.this,lat, Toast.LENGTH_SHORT).show();

        Query query1=FirebaseDatabase.getInstance().getReference("Garages")
                .orderByChild("latitude")
                .equalTo(lat);
        query1.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ShowGarages( dataSnapshot);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });





    }




    private void ShowGarages(DataSnapshot dataSnapshot) {

        if (dataSnapshot.exists()) {

            for (DataSnapshot ds : dataSnapshot.getChildren()) {

                Garages garages = new Garages();
                garages.setLatitude(ds.getValue(Garages.class).getLatitude());//DB Automatically get .point value as double
                garages.setLongitude(ds.getValue(Garages.class).getLongitude());
                garages.setGarageName(ds.getValue(Garages.class).getGarageName());
                garages.setAddress(ds.getValue(Garages.class).getAddress());
                garages.setContact(ds.getValue(Garages.class).getContact());


                Double Lat = Double.parseDouble(garages.getLatitude());
                Double Lng = Double.parseDouble(garages.getLongitude());
                 addr = garages.getAddress();
                 name = garages.getGarageName();
                String phone = garages.getContact();


                GarageNameTextView.setText(name);
                GarageAddrTextView.setText(addr);

                //Phone Number Vaidation
                if(phone.charAt(0)=='0')
                {
                    StringBuilder sb = new StringBuilder(phone);
                    sb.deleteCharAt(0);
                    formatedPhone=sb.toString();
                    formatedPhone = "+94"+formatedPhone;

                }
                else
                {
                     formatedPhone = "+94"+phone;
                }

                GarageContactTextView.setText(formatedPhone);




            }
        }
    }







}

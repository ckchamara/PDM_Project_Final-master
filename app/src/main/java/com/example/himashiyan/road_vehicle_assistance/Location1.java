package com.example.himashiyan.road_vehicle_assistance;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;

import com.example.himashiyan.road_vehicle_assistance.Account_Activity.pop;
import com.example.himashiyan.road_vehicle_assistance.Location.Garages;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Location1 extends AppCompatActivity implements OnMapReadyCallback {

    //do changes inside loaded map
    @Override
    public void onMapReady(GoogleMap googleMap) {
        Toast.makeText(Location1.this, "Map Is Ready", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onMapReady: map is ready");
        mMap = googleMap;

        if (permission_Granted) {

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            mMap.setMyLocationEnabled(true);
            mMap.getUiSettings().setMyLocationButtonEnabled(false);
            // mMap.getUiSettings().setCompassEnabled(true);
            //mMap.setTrafficEnabled(true);
            //mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);


            init();


            dbUsers = FirebaseDatabase.getInstance().getReference().child("users").getRef();
            dbGarages = FirebaseDatabase.getInstance().getReference().child("Garages").getRef();
            dbGarages.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    ShowGarages(dataSnapshot);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

            // GEt details when click on map pin snippet
            mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                @Override
                public void onInfoWindowClick(Marker marker) {


                    marker1 marker1 = new marker1();
                    marker1.setMarkerLat(marker.getPosition().latitude);

                    Toast.makeText(Location1.this, String.valueOf(marker.getPosition().latitude), Toast.LENGTH_SHORT).show();

                    startActivity(new Intent(Location1.this, pop.class));
                    //double i=marker.getPosition().longitude;
                }
            });
            // GEt details when click on map pin
            mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                @Override
                public boolean onMarkerClick(Marker marker) {
                    LatLng positionOfMArker = marker.getPosition();
                    String longitude = String.valueOf(positionOfMArker.longitude);//Get longitude of clicked marker
                    String LAtitude = String.valueOf(positionOfMArker.latitude);//Get latitude of clicked marker
                    Toast.makeText(Location1.this, LAtitude + "," + longitude, Toast.LENGTH_SHORT).show();

                    long start = SystemClock.uptimeMillis();
                    String time = String.valueOf(start);

                    Toast.makeText(Location1.this, time, Toast.LENGTH_SHORT).show();
                    return false;
                }
            });

        }
    }


    private static final String TAG = "Location1";

    //Permission vars
    private static final String FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
    private static final String COURSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1234;
    private static final float DEFAULT_ZOOM = 15f;

    //JUNK
    private static double v = 6.850372;
    private static double v1 = 80.082704;

    private double myLocationLat;
    private double myLocationLng;


    //pop class


    //VARS
    private boolean permission_Granted = false;
    private GoogleMap mMap;
    private FusedLocationProviderClient mFusedLocationProviderClient;

    //widgets
    private EditText mSearchText;
    private Button geolocationFunc_InvokeBTN;
    private Button GpsButton;
    private Button TrafficButton;
    private Button ShareButton;


    //FireBase
    private DatabaseReference dbUsers;
    DatabaseReference dbGarages;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location);//refers Location.xml file

        mSearchText = (EditText) findViewById(R.id.input_search);
        getLocationPermission();


        //myButton geolocationFunc_InvokeBTN
        geolocationFunc_InvokeBTN = findViewById(R.id.SEarch_button2);
        geolocationFunc_InvokeBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                geoLocate();
            }
        });

        //GPS Invoke Button
        GpsButton = findViewById(R.id.GPS_button2);
        GpsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDeviceLocation();
            }
        });

        //TrafficButton Iinvoke
        TrafficButton = findViewById(R.id.traffic_button);
        TrafficButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mMap.isTrafficEnabled()) {
                    mMap.setTrafficEnabled(false);
                    Toast.makeText(Location1.this, "Traffic Disabled", Toast.LENGTH_SHORT).show();
                } else {
                    mMap.setTrafficEnabled(true);
                    Toast.makeText(Location1.this, "Traffic Enabled", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ShareButton = findViewById(R.id.share_button);
        ShareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ShareIt("https://www.google.com/maps/?q="+String.valueOf(myLocationLat)+","+String.valueOf(myLocationLng),"My Vehicle Location");
            }
        });


    }

    private void init()
    {
        Log.d(TAG, "init: initializing");

        mSearchText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if(actionId == EditorInfo.IME_ACTION_SEARCH
                        || actionId == EditorInfo.IME_ACTION_DONE
                        || keyEvent.getAction() == KeyEvent.ACTION_DOWN
                        || keyEvent.getAction() == KeyEvent.KEYCODE_ENTER){

                    //execute our method for searching
                    geoLocate();
                }

                return false;
            }
        });
    }

    private void geoLocate(){
        Log.d(TAG, "geoLocate: geolocating");

        String searchString = mSearchText.getText().toString();

        Geocoder geocoder = new Geocoder(Location1.this);
        List<Address> list = new ArrayList<>();
        try{
            list = geocoder.getFromLocationName(searchString, 1);
        }catch (IOException e){
            Log.e(TAG, "geoLocate: IOException: " + e.getMessage() );
        }

        if(list.size() > 0){
            Address address = list.get(0);

            Log.d(TAG, "geoLocate: found a location: " + address.toString());

            //moveCamera(new LatLng(address.getLatitude(), address.getLongitude()), DEFAULT_ZOOM,
                    //address.getAddressLine(0));

            LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
            CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng, DEFAULT_ZOOM);
            mMap.animateCamera(cameraUpdate);


        }
    }




    private void initMap()
    {
        Log.d(TAG,"initMap: initializing map");
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);

        mapFragment.getMapAsync(Location1.this);
    }


    //Get Device location permission
    private  void getLocationPermission()
    {
        Log.d(TAG,"GetLocationPermisson: get Location Permisson");
        String [] permissions = {Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.ACCESS_FINE_LOCATION};

        if (ContextCompat.checkSelfPermission(this.getApplicationContext(),FINE_LOCATION )== PackageManager.PERMISSION_GRANTED)
        {
            if (ContextCompat.checkSelfPermission(this.getApplicationContext(),COURSE_LOCATION )== PackageManager.PERMISSION_GRANTED)
            {
                permission_Granted=true;
                initMap();
            }
            else
            {
                ActivityCompat.requestPermissions(this,permissions,LOCATION_PERMISSION_REQUEST_CODE);
            }
        }
        else
        {
            ActivityCompat.requestPermissions(this,permissions,LOCATION_PERMISSION_REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        Log.d(TAG,"onRequstPermissionResult: Called");
        permission_Granted = false;

        switch (requestCode)
        {
            case LOCATION_PERMISSION_REQUEST_CODE:
            {
                if(grantResults.length > 0)
                {
                    for (int i=0;i<grantResults.length;i++)
                    {
                        if(grantResults[i] != PackageManager.PERMISSION_GRANTED)
                        {
                            permission_Granted=false;
                            Log.d(TAG,"onRequstPermissionResult: Permission Failed");
                            return;
                        }
                    }

                    Log.d(TAG,"onRequstPermissionResult: Permission Granted");
                    permission_Granted=true;
                    //initialize Our Map
                    initMap();
                }
            }
        }
    }



    //--------------------------------GET DEVICE GPS LOCATION-------------------------------------
    private void getDeviceLocation(){
        Log.d(TAG, "getDeviceLocation: getting the devices current location");

        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        try{
            if(permission_Granted){

                final Task location = mFusedLocationProviderClient.getLastLocation();
                location.addOnCompleteListener(new OnCompleteListener() {
                    @Override
                    public void onComplete(@NonNull Task task) {
                        if(task.isSuccessful()){
                            Log.d(TAG, "onComplete: found location!");
                            Location currentLocation = (Location) task.getResult();

                           // moveCamera(new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude()),
                                   // DEFAULT_ZOOM, "Vehicle Breakdown Location");
                            myLocationLat=currentLocation.getLatitude();
                            myLocationLng=currentLocation.getLongitude();
                            LatLng latLng = new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude());
                            CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng, DEFAULT_ZOOM);
                            mMap.animateCamera(cameraUpdate);



                        }else{
                            Log.d(TAG, "onComplete: current location is null");
                            Toast.makeText(Location1.this, "unable to get current location", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }catch (SecurityException e){
            Log.e(TAG, "getDeviceLocation: SecurityException: " + e.getMessage() );
        }
    }

    private void moveCamera(LatLng latLng, float zoom, String title){
        Log.d(TAG, "moveCamera: moving the camera to: lat: " + latLng.latitude + ", lng: " + latLng.longitude );
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoom));

        MarkerOptions options = new MarkerOptions()
                .position(latLng)
                .title(title);
        mMap.addMarker(options);
    }


    //FIREBASE
    private void ShowGarages(DataSnapshot dataSnapshot) {

        try
        {
            if (dataSnapshot.exists()) {

                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                     Garages garages = new Garages();
                    garages.setLatitude(ds.getValue(Garages.class).getLatitude());//DB Automatically get .point value as double
                    garages.setLongitude(ds.getValue(Garages.class).getLongitude());
                    garages.setGarageName(ds.getValue(Garages.class).getGarageName());
                    garages.setAddress(ds.getValue(Garages.class).getAddress());


                    Double Lat = Double.parseDouble(garages.getLatitude());
                    Double Lng = Double.parseDouble(garages.getLongitude());
                    String addr = garages.getAddress();
                    String name = garages.getGarageName();


                    mMap.addMarker(new MarkerOptions()
                            .position(new LatLng(Lat, Lng))
                            .title(name)
                            .snippet(addr)
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker1)));
                }

            }
        }
        catch (Exception e)
        {
            Toast.makeText(this,e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    private void ShareIt(String shareBody, String subject)
    {
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }


}

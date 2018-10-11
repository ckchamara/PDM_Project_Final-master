package com.example.himashiyan.road_vehicle_assistance;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.RatingBar;

import com.example.himashiyan.road_vehicle_assistance.models.feedback;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Quick_Gudie_new extends AppCompatActivity{


    //firebase Var
    private DatabaseReference database;

    //Android Layout
    private EditText step;
    private EditText Topic;
    private GridView  gridView;

    //Array List
    private ArrayList<String> arrayList = new ArrayList<>();
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qick__gudie_new);




        database = FirebaseDatabase.getInstance().getReference("user");


        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);

        gridView = (GridView)   findViewById(R.id.feedbackview);

        gridView.setAdapter(adapter);

//        waiting.show();
        /*database.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                     String string = dataSnapshot.getValue(String.class);

                feedback feedback = dataSnapshot.getValue(feedback.class);


                String ratingshow = "Rating Points: \t"+String.valueOf(feedback.rating)+"\n"+"Title: \t\t"+feedback.title+"\n"+"Description: \t"+feedback.desc+"\n";
                arrayList.add(ratingshow);

//                            String tit = "Title: \t"+feedback.title;
//                            arrayList.add(tit);
//
//                            String Des = "Description: \t"+feedback.desc;
//                            arrayList.add(Des);

                adapter.notifyDataSetChanged();

//                waiting.hide();
            }
    });*/
}


}

package com.example.himashiyan.road_vehicle_assistance;

import android.app.ProgressDialog;
import android.content.Intent;
import android.media.Rating;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.himashiyan.road_vehicle_assistance.models.feedback;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.EventListener;

public class feedback_view extends AppCompatActivity {

    //firebase Var
    private DatabaseReference database;

    //Android Layout
    private  EditText Dtext;
    private RatingBar  Rate;
    ProgressDialog waiting;
//  private  ListView listView;
    private GridView gridView;
    DatabaseReference mpostrefernce;


    //Array List
    private ArrayList<String> arrayList = new ArrayList<>();
    private ArrayAdapter<String> adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_view);

        database = FirebaseDatabase.getInstance().getReference("ParkingPlaces");


        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);

        Dtext = (EditText) findViewById(R.id.TextDescription);
        Rate = (RatingBar) findViewById(R.id.ratingBar);
//        listView = (ListView) findViewById(R.id.feedbackview);
        gridView = (GridView)   findViewById(R.id.feedbackview);

        waiting = new ProgressDialog(this);
        waiting.setMessage("Retreving feedback Data...");


        gridView.setAdapter(adapter);

                waiting.show();
                    database.addChildEventListener(new ChildEventListener() {
                        @Override
                        public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

//                        String string = dataSnapshot.getValue(String.class);

                            feedback feedback = dataSnapshot.getValue(feedback.class);


                            String ratingshow = "Rating Points: \t"+String.valueOf(feedback.rating)+"\n"+"Title: \t\t"+feedback.title+"\n"+"Description: \t"+feedback.desc+"\n";
                            arrayList.add(ratingshow);

//                            String tit = "Title: \t"+feedback.title;
//                            arrayList.add(tit);
//
//                            String Des = "Description: \t"+feedback.desc;
//                            arrayList.add(Des);

                            adapter.notifyDataSetChanged();

                            waiting.hide();
                        }

                        @Override
                        public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                        }

                        @Override
                        public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                        }

                        @Override
                        public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

//                    finish();
//                    super.run();
//                }catch (InterruptedException e){
//
//                    e.printStackTrace();
//                }
//            }
//        };
//
//        timer.start();


//
//                EventListener postListener = new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                        feedback feedback = dataSnapshot.getValue(feedback.class);
//
//                        String Des = feedback.desc;
//                        arrayList.add(Des);
//
//                        adapter.notifyDataSetChanged();
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                    }
//                }
////                database.addChildEventListener(postListener);
//
//
//            }
//        });

            }

//        });
//
//    }
}






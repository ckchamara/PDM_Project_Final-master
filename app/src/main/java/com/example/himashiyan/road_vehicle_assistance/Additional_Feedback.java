package com.example.himashiyan.road_vehicle_assistance;


import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class Additional_Feedback extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.additional__feedback);
    }

    public void Send_click(View v)
    {

        EditText name = (EditText) findViewById(R.id.Name);
        EditText email = (EditText) findViewById(R.id.Email);
        EditText subject = (EditText) findViewById(R.id.Subject);
        EditText message = (EditText) findViewById(R.id.Message);

        if (name.getText().toString().equals(""))
        name.setError("Madatory feild");
            else if(email.getText().toString().equals(""))
            email.setError("Madatory feild");
        else if(subject.getText().toString().equals(""))
            subject.setError("Madatory feild");
        else if(message.getText().toString().equals(""))
            message.setError("Madatory feild");
        else {
            Intent i = new Intent(Intent.ACTION_SENDTO);
            i.setData(Uri.parse("mailto:"));
            i.putExtra(Intent.EXTRA_EMAIL, new String[]{"himaziyan.pro@gmail.com"});
            i.putExtra(Intent.EXTRA_SUBJECT, subject.getText().toString());
            i.putExtra(Intent.EXTRA_TEXT, "dear andromoles, \n"
                    + message.getText().toString() + "\n Regards,"
                    + email.getText().toString());

            try {
                startActivity(Intent.createChooser(i, "send mail"));
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(this, "no mail app found", Toast.LENGTH_SHORT).show();
            } catch (Exception ex) {
                Toast.makeText(this, "Unexpected Error" + ex.toString(), Toast.LENGTH_SHORT).show();
            }

        }
    }
}

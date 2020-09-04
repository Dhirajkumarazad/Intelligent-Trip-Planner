package com.example.intelligenttripplanner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Confirmation extends AppCompatActivity {

    Button b;
    CalendarView cv;
    CheckBox ch;
    String val,name,usn;
    int dd,mm,yy;
    DatabaseReference d= FirebaseDatabase.getInstance().getReference("Users");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        b=findViewById(R.id.btn);
        cv=findViewById(R.id.cal);
        ch=findViewById(R.id.chbox);
        name=getIntent().getStringExtra("name");
        cv.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                dd=dayOfMonth;
                mm=month+1;
                yy=year;
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ch.isChecked())
                {
                    val="share";
                }
                else
                {
                    val="notshare";
                }

                SharedPreferences sharedPreferences=getSharedPreferences("sharedprefs",MODE_PRIVATE);
                usn=sharedPreferences.getString("key","");
                d.child(usn).child("Place").setValue(name);
                d.child(usn).child("Day").setValue(""+dd);
                d.child(usn).child("Month").setValue(""+mm);
                d.child(usn).child("Year").setValue(""+yy);
                d.child(usn).child("Status").setValue(val);
                SharedPreferences sharedPreferences1=getSharedPreferences("sharedpref",MODE_PRIVATE);
                SharedPreferences.Editor editor1=sharedPreferences1.edit();
                editor1.putString("day",""+dd);
                editor1.putString("month",""+mm);
                editor1.putString("share",""+val);
                editor1.putString("place",""+name);
                editor1.apply();



                Toast.makeText(Confirmation.this, "Trip Confirmed!!", Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(Confirmation.this,HomeStudent.class);
                startActivity(intent);
            }
        });


    }
}

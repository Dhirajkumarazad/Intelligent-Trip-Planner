package com.example.intelligenttripplanner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainCard extends AppCompatActivity {
    DatabaseReference db= FirebaseDatabase.getInstance().getReference();
    CardView c1,c2,c3,c4,c5,c6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_card);

        c1=findViewById(R.id.card1);
        c2=findViewById(R.id.card2);
        c3=findViewById(R.id.card3);
        c4=findViewById(R.id.card4);
        c5=findViewById(R.id.card5);
        c6=findViewById(R.id.card6);

        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  Toast.makeText(MainActivity.this, "Adventure", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainCard.this,PlacesList.class);
                intent.putExtra("name","Adventure");
                db.child("Clicked").setValue("Adventure");
                startActivity(intent);

            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainCard.this,PlacesList.class);
                intent.putExtra("name","Beach");
                db.child("Clicked").setValue("Beach");
                startActivity(intent);            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(MainActivity.this, "Hills", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainCard.this,PlacesList.class);
                intent.putExtra("name","Hills");
                db.child("Clicked").setValue("Hills");
                startActivity(intent);
            }
        });
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "Historical", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainCard.this,PlacesList.class);
                intent.putExtra("name","Historical");
                db.child("Clicked").setValue("Historical");
                startActivity(intent);
            }
        });
        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(MainActivity.this, "Spiritual", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainCard.this,PlacesList.class);
                intent.putExtra("name","Spiritual");
                db.child("Clicked").setValue("Spiritual");
                startActivity(intent);
            }
        });
        c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(MainActivity.this, "Wildlife", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainCard.this,PlacesList.class);
                intent.putExtra("name","Wildlife");
                db.child("Clicked").setValue("Wildlife");
                startActivity(intent);
            }
        });
    }
}


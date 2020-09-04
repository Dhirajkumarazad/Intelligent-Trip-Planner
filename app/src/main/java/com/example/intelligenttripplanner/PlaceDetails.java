package com.example.intelligenttripplanner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class PlaceDetails extends AppCompatActivity {

    TextView rating,desc;
    ImageView img;
    String position,type;
    String a;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_details);
        rating=findViewById(R.id.star);
        desc=findViewById(R.id.details);
        img=findViewById(R.id.img);
        b=findViewById(R.id.btn);
        DatabaseReference db1= FirebaseDatabase.getInstance().getReference().child("Clicked");
        position=getIntent().getStringExtra("position");
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(PlaceDetails.this, "Maps Activity", Toast.LENGTH_SHORT).show();
                Intent i2=new Intent(PlaceDetails.this,MapsActivity.class);

                i2.putExtra("name",a);
                startActivity(i2);
            }
        });
        db1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                type=dataSnapshot.getValue().toString();
                DatabaseReference db= FirebaseDatabase.getInstance().getReference("Places").child(type);

                db.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String rat=dataSnapshot.child(position).child("Rating").getValue().toString();
                        rating.setText(rat);
                        String det=dataSnapshot.child(position).child("Description").getValue().toString();
                        desc.setText(det);
                        String link=dataSnapshot.child(position).child("Image").getValue().toString();
                        Picasso.get().load(link).into(img);
                        a=dataSnapshot.child(position).child("Name").getValue().toString();


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}

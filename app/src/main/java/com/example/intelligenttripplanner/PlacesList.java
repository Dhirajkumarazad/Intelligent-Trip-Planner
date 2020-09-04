package com.example.intelligenttripplanner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class PlacesList extends AppCompatActivity {
    ArrayList<FireModelH> list;
    RecyclerView recyclerView;

    //  int i=0;

    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places_list);


        Intent intent=getIntent();
        String name=intent.getExtras().getString("name","Adventure");



        recyclerView=findViewById(R.id.recycleh);

        // Intent intent=getIntent();
        //String phno=intent.getExtras().getString("phno","8777022293");

        //   Toast.makeText(this, ""+phno, Toast.LENGTH_SHORT).show();
        DatabaseReference db= FirebaseDatabase.getInstance().getReference("Places").child(name);
        //  progressBar=findViewById(R.id.pbar);


        recyclerView.clearOnScrollListeners();
        recyclerView.clearOnChildAttachStateChangeListeners();
        // list.clear();
        list=new ArrayList<FireModelH>();

        db.addValueEventListener(new ValueEventListener() {
            // FireModelH fireModel=new FireModelH();

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                FireModelH value;
                list.clear();
                // Toast.makeText(history.this, "Hello", Toast.LENGTH_SHORT).show();
                for(DataSnapshot x:dataSnapshot.getChildren())
                {
                    // Toast.makeText(PlacesList.this, "Item: "+x.getValue(), Toast.LENGTH_SHORT).show();

                    value=x.getValue(FireModelH.class);
                    list.add(value);
                    // Toast.makeText(PlacesList.this, "item: "+list.get(i).title, Toast.LENGTH_LONG).show();


                }
                recyclerView.clearOnScrollListeners();
                recyclerView.clearOnChildAttachStateChangeListeners();


                Adapterhistory adapterhistory= new Adapterhistory(list);
                RecyclerView.LayoutManager recyce=new GridLayoutManager(recyclerView.getContext(),1);
                recyclerView.setLayoutManager(recyce);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(adapterhistory);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}

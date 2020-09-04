package com.example.intelligenttripplanner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class HomeStudent extends AppCompatActivity {
    CardView cdhistory,cddonate;

    ImageView bgapp, clover;
    LinearLayout textsplash, texthome, menus;
    Animation frombottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_student);
        frombottom = AnimationUtils.loadAnimation(this, R.anim.frombottom);



        bgapp = (ImageView) findViewById(R.id.bgapp);
        clover = (ImageView) findViewById(R.id.clover);
        textsplash = (LinearLayout) findViewById(R.id.textsplash);
        texthome = (LinearLayout) findViewById(R.id.texthome);
        menus = (LinearLayout) findViewById(R.id.menus);

        bgapp.animate().translationY(-1900).setDuration(800).setStartDelay(300);
        clover.animate().alpha(0).setDuration(100).setStartDelay(800);
        textsplash.animate().translationY(540).alpha(0).setDuration(900).setStartDelay(500);

        texthome.startAnimation(frombottom);
        menus.startAnimation(frombottom);
        cdhistory=findViewById(R.id.cdhistory);

        cddonate=findViewById(R.id.cddonate);

        cddonate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i=new Intent(Home.this,MainActivity.class);
//                Intent intent=getIntent();
//                String phno=intent.getExtras().getString("phno","8777022293");
//                i.putExtra("phno",phno);
//                startActivity(i);
                /// Toast.makeText(HomeStudent.this, "Opening drive ..", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(HomeStudent.this,MainCard.class);
                //i.setData(Uri.parse("https://drive.google.com/open?id=1_jQVO8vKZikqOMq81hjvXMhZlCV83wd-"));
                startActivity(i);
            }
        });
        cdhistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Intent i=new Intent(HomeStudent.this,MainActivity.class);
//                Intent intent=getIntent();
//                String phno=intent.getExtras().getString("phno","8777022293");
//                i.putExtra("phno",phno);
                 startActivity(i);
                //Toast.makeText(HomeStudent.this, "View People", Toast.LENGTH_SHORT).show();

            }
        });

    }
}

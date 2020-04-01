package com.example.digsec.multiplayergame;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity<Protected> extends AppCompatActivity {

   FirebaseDatabase db = FirebaseDatabase.getInstance();
   DatabaseReference rootref = db.getReference();
   DatabaseReference gref = rootref.child("game");


    Button btn1,btn2,btn3;
    TextView textView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=(Button)findViewById(R.id.button);
        btn2=(Button)findViewById(R.id.button2);
        btn3=(Button)findViewById(R.id.button3);
        textView=(TextView) findViewById(R.id.tv);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                gref.setValue("TOM");

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                gref.setValue("DICK");

            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                gref.setValue("HARRY");

            }
        });


    }


    @Override
    protected void onStart() {
        super.onStart();

        gref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String text = dataSnapshot.getValue().toString();
                textView.setText(text);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Log.i("tag","missing");

            }
        });
    }
}

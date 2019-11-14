package com.example.testapi24;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;
import java.util.Queue;

public class insert_user extends AppCompatActivity {


    public DatabaseReference myRef ;
    public TextView iduser;

    public TextView idpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_user);
        iduser = (TextView)findViewById(R.id.iduser);
        idpassword = (TextView)findViewById(R.id.idpassword);


    }

    public void insert (View v){

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference();

        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Map map=(Map)dataSnapshot.getValue();
                Map map1 = (Map) dataSnapshot.child("testuser").getValue();
                String user = String.valueOf(map1.get("username"));
                String  password= String.valueOf(map1.get("password"));
                iduser.setText(user);
                idpassword.setText(password);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }


}

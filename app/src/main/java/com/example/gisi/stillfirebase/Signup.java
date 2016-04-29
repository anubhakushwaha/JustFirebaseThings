package com.example.gisi.stillfirebase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class Signup extends AppCompatActivity {

    EditText name,mail,password;
    String Ename,Email,Epassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        name= (EditText) findViewById(R.id.editText3);
        mail=(EditText) findViewById(R.id.editText4);
        password=(EditText) findViewById(R.id.editText5);
        Firebase.setAndroidContext(this);
    }
    public void done(View v)
    {

        final int[] currentusers = new int[1];

        // Get a reference to our posts
        Firebase ref = new Firebase("https://testinganu.firebaseio.com/no of users");
        
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                currentusers[0] = (int) snapshot.child("no of users").getValue();
                for (DataSnapshot postSnapshot : snapshot.getChildren()) {


                }

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
            }
        });
        Toast.makeText(getApplicationContext(),currentusers[0]+"",Toast.LENGTH_LONG).show();
    }
}

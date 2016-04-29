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

public class Login extends AppCompatActivity {

    String Eusername;
    String Epassword;
    EditText username;
    EditText password;
    int flag=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
          username= (EditText) findViewById(R.id.editText);
          password= (EditText) findViewById(R.id.editText2);

        Firebase.setAndroidContext(this);
    }

    public void login(View v)
    {
        // Get a reference to our posts
        Firebase ref = new Firebase("https://testinganu.firebaseio.com/");
        // Attach an listener to read the data at our posts reference
        Eusername=username.getText().toString();
        Epassword=password.getText().toString();
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                    String databaseuser=postSnapshot.child("name").getValue().toString();
                    String databasepassword=postSnapshot.child("password").getValue().toString();
                    if(Eusername.trim().equals(databaseuser)&&Epassword.trim().equals(databasepassword))
                    {
                        Toast.makeText(getApplicationContext(),"Viola correct password",Toast.LENGTH_LONG).show();
                        flag=1;
                        break;
                    }
                }
                if(flag==0)
                    Toast.makeText(getApplicationContext(),"Wrong password",Toast.LENGTH_LONG).show();
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
            }
        });
    }
}

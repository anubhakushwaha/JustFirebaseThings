package com.example.gisi.stillfirebase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public void login(View v)
    {
        startActivity(new Intent(this, Login.class));
    }
    public void signup(View v){startActivity(new Intent(this,Signup.class));}
}

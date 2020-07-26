package com.example.tenantmanagementsystem;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(MainActivity.this,"Firebase connection success",Toast.LENGTH_LONG).show();
    }

    public void comp(View view) {
        Intent intent =new Intent(this,complaint.class);
        startActivity(intent);
    }

}
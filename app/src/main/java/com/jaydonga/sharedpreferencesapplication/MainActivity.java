package com.jaydonga.sharedpreferencesapplication;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class MainActivity extends AppCompatActivity{

    EditText txtname ,txtpassword;
    Button btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txtname = findViewById(R.id.edtname);
        txtpassword = findViewById(R.id.edtpassword);
        btn = findViewById(R.id.btn);

        FloatingActionButton fab = findViewById(R.id.fab);

        final SharedPreferences sharedPreferences = getSharedPreferences("user details",MODE_PRIVATE);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = txtname.getText().toString();
                String password = txtpassword.getText().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("name",name);
                editor.putString("password",password);
                editor.apply();

                Toast.makeText(getApplicationContext()," save data",Toast.LENGTH_LONG).show();

            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SecondActivity.class);
                startActivity(intent);
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.item,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.order:
                Toast.makeText(getApplicationContext(),"item order",Toast.LENGTH_LONG).show();
                return true;
            case R.id.status:
                Toast.makeText(getApplicationContext(),"item status",Toast.LENGTH_LONG).show();
                return true;
            case R.id.favorite:
                Toast.makeText(getApplicationContext(),"item favorite",Toast.LENGTH_LONG).show();
                return true;
            case R.id.contact:
                Toast.makeText(getApplicationContext(),"item contact",Toast.LENGTH_LONG).show();
                return true;

        }
        return super.onOptionsItemSelected(item);

    }


}
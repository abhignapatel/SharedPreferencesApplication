package com.jaydonga.sharedpreferencesapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView txtname = findViewById(R.id.txtname);
        TextView txtpassword = findViewById(R.id.txtpassword);
        Button button = findViewById(R.id.alertDialog);

        SharedPreferences sharedPreferences = getSharedPreferences("user details",MODE_PRIVATE);

        String name = sharedPreferences.getString("name", "");
        txtname.setText(name);
        String password = sharedPreferences.getString("password", "");
        txtpassword.setText(password);

        registerForContextMenu(txtname);

       button.setOnClickListener(new View.OnClickListener() {

           @Override
           public void onClick(View v) {

               AlertDialog.Builder alertdialog = new AlertDialog.Builder(SecondActivity.this);
               alertdialog.setTitle(R.string.alert_title);
               alertdialog.setMessage(R.string.alert_message);

               //add the dialog button
               alertdialog.setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {

                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       Toast.makeText(getApplicationContext(),"click ok",Toast.LENGTH_LONG).show();

                   }
               });


               alertdialog.setNegativeButton(R.string.Cancel, new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       Toast.makeText(getApplicationContext(),"click cancel",Toast.LENGTH_LONG).show();
                   }
               });
               alertdialog.show();
           }

       });

    }

}
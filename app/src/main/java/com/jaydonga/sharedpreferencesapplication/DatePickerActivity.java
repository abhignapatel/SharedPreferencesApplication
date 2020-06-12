package com.jaydonga.sharedpreferencesapplication;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class DatePickerActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker);

    }

    public void showProcessDialog(View view) {

        DialogFragment dialogFragment = new DatePickerFragment();
        dialogFragment.show(getSupportFragmentManager(), getString(R.string.datepicker));
    }
    public void processDatePickerResult(int year ,int day,int month){
        String year_string = Integer.toString(year);
        String day_string = Integer.toString(day);
        String month_string = Integer.toString(month);
        String date_message = (month_string + "/" + day_string + "/" + year_string);
        Toast.makeText(getApplicationContext(),"Date: "+date_message,Toast.LENGTH_LONG).show();

    }
}

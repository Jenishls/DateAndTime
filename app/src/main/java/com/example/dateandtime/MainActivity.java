package com.example.dateandtime;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private EditText etDate;
    private TextView etTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etDate = findViewById(R.id.etDate);
        etDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadDatePicker();
            }
        });

        etTime = findViewById(R.id.etTime);
        etDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadTime();
            }
        });

    }

    private void loadTime(){
            final Calendar c = Calendar.getInstance();
            final int hour = c.get(Calendar.HOUR);
            int minute = c.get(Calendar.MINUTE);
            int second = c.get(Calendar.SECOND);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                etTime.setText("Time is :"+hourOfDay+":"+minute);
            }
        },hour,minute,false);
        timePickerDialog.show();
    }

    private void loadDatePicker(){
        final Calendar c= Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month= c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,this,year,month,day);
        datePickerDialog.show();
    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String monthArray[] = {"","January","February","March","April","May","June","July","August","September","October","November","December"};
        String Date = "Year/Month/Day : "+ year + "/" + monthArray[month] + "/" + dayOfMonth;
        etDate.setText(Date);
    }
}

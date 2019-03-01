package com.maleficcircles.attendance;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class Rolecall extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rolecall);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        boolean stud1 = false;

        CheckBox checkbox_student1 = findViewById(R.id.checkbox_student1);
        checkbox_student1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Record Updated", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        CheckBox checkbox_student2 = findViewById(R.id.checkbox_student2);
        checkbox_student2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Record Updated", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        CheckBox checkbox_student3 = findViewById(R.id.checkbox_student3);
        checkbox_student3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Record Updated", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        CheckBox checkbox_student4 = findViewById(R.id.checkbox_student4);
        checkbox_student4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Record Updated", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        CheckBox checkbox_student5 = findViewById(R.id.checkbox_student5);
        checkbox_student5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Record Updated", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        CheckBox checkbox_student6 = findViewById(R.id.checkbox_student6);
        checkbox_student6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Record Updated", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        CheckBox checkbox_student7 = findViewById(R.id.checkbox_student7);
        checkbox_student7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Record Updated", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        CheckBox checkbox_student8 = findViewById(R.id.checkbox_student8);
        checkbox_student8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Record Updated", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        CheckBox checkbox_student9 = findViewById(R.id.checkbox_student9);
        checkbox_student9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Record Updated", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void submit(View view){
        Snackbar.make(view, "Attendance Submitted", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

}

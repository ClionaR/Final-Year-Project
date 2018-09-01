package com.example.cliona.backend;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Profile extends AppCompatActivity {

    Button button, adoption, foster, notice, apply, donate ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        button = (Button)findViewById(R.id.button) ;
        adoption = (Button) findViewById(R.id.adoption);
        foster = (Button) findViewById(R.id.foster);
        notice = (Button) findViewById(R.id.notice);
        apply = (Button) findViewById(R.id.apply);
        donate = (Button) findViewById(R.id.donate);


        Intent intent = getIntent();



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();

                Intent intent = new Intent(Profile.this, LoginActivity.class);

                startActivity(intent);

                Toast.makeText(Profile.this, "Log Out Successfully", Toast.LENGTH_LONG).show();

            }
        });

        adoption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Profile.this, AdoptionActivity.class);

                startActivity(intent);
            }
        });

        foster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Profile.this, FosterActivity.class);

                startActivity(intent);
            }
        });

        notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Profile.this, NoticeActivity.class);

                startActivity(intent);

            }
        });

        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Profile.this, MatchForm.class);

                startActivity(intent);

            }
        });

        donate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Profile.this, Donate.class);

                startActivity(intent);

            }
        });

    }

    @Override
    public void onBackPressed() {

        Toast.makeText(Profile.this, "Please Click on Log Out button .", Toast.LENGTH_LONG).show();

        return;
    }
}
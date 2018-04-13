package com.example.cliona.backend;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;



public class MatchForm extends AppCompatActivity{
    Spinner age, size, gender, energy, suitability, living_situ;
    Button submit;
    String dog_age, dog_size, dog_gender, energy_level, suit, living;
    String FetchURL = "http://192.168.0.206:80/.php" ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matchform);

        addItemsOnAge(age);
        addItemsOnSize(size);
        addItemsOnSuitability(energy);
        addItemsOnLiving(living_situ);


    }

    // add items into spinner dynamically
    public void addItemsOnAge(Spinner age) {

        age = (Spinner) findViewById(R.id.age);
        List<String> list = new ArrayList<String>();
        list.add("Puppy");
        list.add("Adult");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        age.setAdapter(dataAdapter);
    }

    public void addItemsOnSize(Spinner size) {

        size = (Spinner) findViewById(R.id.dogsize);
        List<String> list = new ArrayList<String>();
        list.add("Small");
        list.add("Medium");
        list.add("Large");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        size.setAdapter(dataAdapter);
    }

    public void addItemsOnSuitability(Spinner suitability) {

        suitability = (Spinner) findViewById(R.id.dogsuitability);
        List<String> list = new ArrayList<String>();
        list.add("Children Under Ten");
        list.add("Children Over Ten");
        list.add("Adults Only");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        suitability.setAdapter(dataAdapter);
    }

    public void addItemsOnLiving(Spinner living_situ) {

        living_situ = (Spinner) findViewById(R.id.living_situ);
        List<String> list = new ArrayList<String>();
        list.add("Apartment");
        list.add("House With Garden");
        list.add("House Without Garden");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        living_situ.setAdapter(dataAdapter);
    }

    public void addListenerOnButton() {

        age = (Spinner) findViewById(R.id.age);
        size = (Spinner) findViewById(R.id.dogsize);
        suitability = (Spinner) findViewById(R.id.dogsuitability);
        living_situ = (Spinner) findViewById(R.id.living_situ);

        dog_age = String.valueOf(age.getSelectedItem());
        dog_size = String.valueOf(size.getSelectedItem());
        dog_gender = String.valueOf(gender.getSelectedItem());
        energy_level = String.valueOf(suitability.getSelectedItem());
        suit = String.valueOf(energy.getSelectedItem());
        living = String.valueOf(living_situ.getSelectedItem());

        submit = (Button) findViewById(R.id.submit);

        submit.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {


            }
        });
    }


}

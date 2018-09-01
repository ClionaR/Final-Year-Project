package com.example.cliona.backend;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MatchForm extends AppCompatActivity{

    Button submit;
    ProgressDialog progressDialog;
    EditText name, email, address, animalType, animalName, otherPeople, otherPets;
    String NameHolder, AddressHolder, EmailHolder, AnimalTypeHolder, AnimalNameHolder, OtherPeopleHolder, OtherPetsHolder;
    boolean CheckEditText ;
    String ServerLoginURL = "http://192.168.0.207:80/application.php";
    String finalResult ;
    HashMap<String,String> hashMap = new HashMap<>();
    URL url;
    String FinalHttpData = "";
    BufferedWriter bufferedWriter ;
    MatchForm.ApplicantParseClass loginParseClass = new MatchForm.ApplicantParseClass();
    BufferedReader bufferedReader ;
    OutputStream outputStream ;
    StringBuilder stringBuilder = new StringBuilder();
    String Result ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matchform);

        submit = (Button)findViewById(R.id.submit);

        name = (EditText) findViewById(R.id.name);

        address = (EditText)findViewById(R.id.address);

        email = (EditText)findViewById(R.id.email);

        animalType = (EditText)findViewById(R.id.animalType);

        animalName = (EditText)findViewById(R.id.animalName);

        otherPeople = (EditText)findViewById(R.id.otherPeople);

        otherPets = (EditText)findViewById(R.id.otherPets);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                GetCheckEditTextIsEmptyOrNot();

                if(CheckEditText){

                    ApplicantFunction(NameHolder,AddressHolder,EmailHolder,AnimalTypeHolder,AnimalNameHolder,OtherPeopleHolder,OtherPetsHolder);

                }
                else {

                    Toast.makeText(MatchForm.this, "Please fill all form fields.", Toast.LENGTH_LONG).show();

                }



            }
        });
    }

    public void GetCheckEditTextIsEmptyOrNot(){

        NameHolder = name.getText().toString();
        AddressHolder = address.getText().toString();
        EmailHolder = email.getText().toString();
        AnimalTypeHolder = animalType.getText().toString();
        AnimalNameHolder = animalName.getText().toString();
        OtherPeopleHolder = otherPeople.getText().toString();
        OtherPetsHolder = otherPets.getText().toString();


        if(TextUtils.isEmpty(NameHolder) || TextUtils.isEmpty(AddressHolder) || TextUtils.isEmpty(EmailHolder) || TextUtils.isEmpty(AnimalTypeHolder) || TextUtils.isEmpty(AnimalNameHolder) || TextUtils.isEmpty(OtherPeopleHolder) || TextUtils.isEmpty(OtherPetsHolder))
        {

            CheckEditText = false;

        }
        else {

            CheckEditText = true ;
        }

    }

    public void ApplicantFunction(final String name, final String address, final String email, final String animalType, final String animalName, final String otherPeople, final String otherPets){
        Log.d("Clionaloginfunction", "ApplicantFunction");

        class ApplicantFunctionClass extends AsyncTask<String,Void,String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();

                progressDialog = ProgressDialog.show(MatchForm.this,"Loading Data",null,true,true);
            }

            @Override
            protected void onPostExecute(String httpResponseMsg) {

                super.onPostExecute(httpResponseMsg);

                progressDialog.dismiss();

                if(httpResponseMsg.equalsIgnoreCase("Data Matched")){

                    finish();

                    Intent intent = new Intent(MatchForm.this, AdoptionActivity.class);

                    startActivity(intent);
                }else{

                    Toast.makeText(MatchForm.this,httpResponseMsg,Toast.LENGTH_LONG).show();
                }
            }

            @Override
            protected String doInBackground(String... params) {

                hashMap.put("name",params[0]);

                hashMap.put("address",params[1]);

                hashMap.put("email",params[2]);

                hashMap.put("animalType",params[3]);

                hashMap.put("animalName",params[4]);

                hashMap.put("otherPeople",params[5]);

                hashMap.put("otherPets",params[6]);



                finalResult = loginParseClass.postRequest(hashMap);

                return finalResult;
            }
        }

        ApplicantFunctionClass applicantFunctionClass = new ApplicantFunctionClass();
        applicantFunctionClass.execute(name,address,email,animalType,animalName,otherPeople,otherPets);
    }

    public class ApplicantParseClass
    {

        public String postRequest(HashMap<String, String> Data)
        {
            Log.d("ClionalogLoginParse", "data is: " + Data);

            try {
                url = new URL(ServerLoginURL);
                Log.d("ClionalogLoginParse", "ConnectionTest finished");
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

                httpURLConnection.setReadTimeout(12000);
                httpURLConnection.setConnectTimeout(12000);

                Log.d("ClionalogLoginParse", "ConnectionTimeout");
                Log.d("ClionalogLoginParse", "username is " + hashMap.get("username"));
                Log.d("ClionalogLoginParse", "password is " + hashMap.get("password"));

                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty("username", hashMap.get("username"));
                httpURLConnection.setRequestProperty("password", hashMap.get("password"));

                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);

                httpURLConnection.connect();
                InputStream inputStream = httpURLConnection.getInputStream();
                Log.d("ClionalogConnectiontest", "Retrieved Input Stream");

                StringBuffer buffer = new StringBuffer();
                if (inputStream == null) {
                    Log.d("ClionalogLoginParse", "no input found");
                }

                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                while ((line = reader.readLine()) != null) {
                    buffer.append(line + "\n");

                    if(line.contains("Data Matched"))
                    {
                        Intent intent = new Intent(MatchForm.this, Profile.class);
                        startActivity(intent);

                        Log.d("ClionalogLoginParse", "login yes");
                    }
                    else if(line.contains("Invalid"))
                    {
                        Log.d("ClionalogLoginParse", "login no");
                    }


                }
                String str = buffer.toString();
                Log.d("ClionalogLoginParse", "return is " + str);
            } catch (Exception e) {
                Log.d("ClionalogLoginParse", "Exception:" + e.toString());
            }

            return FinalHttpData;
        }

        public String FinalDataParse(HashMap<String, String> hashMap2) throws UnsupportedEncodingException {

            for(Map.Entry<String, String> map_entry : hashMap2.entrySet()){

                stringBuilder.append("&");

                stringBuilder.append(URLEncoder.encode(map_entry.getKey(), "UTF-8"));

                stringBuilder.append("=");

                stringBuilder.append(URLEncoder.encode(map_entry.getValue(), "UTF-8"));

            }

            Result = stringBuilder.toString();

            return Result ;
        }
    }


}

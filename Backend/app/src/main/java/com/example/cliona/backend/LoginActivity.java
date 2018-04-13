package com.example.cliona.backend;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

public class LoginActivity extends AppCompatActivity {

    Button login ;
    ProgressDialog progressDialog;
    EditText username, password ;
    String NameHolder, PasswordHolder ;
    boolean CheckEditText ;
    String ServerLoginURL = "http://192.168.0.206:80/hw.php";
    String finalResult ;
    HashMap<String,String> hashMap = new HashMap<>();
    URL url;
    String FinalHttpData = "";
    BufferedWriter bufferedWriter ;
    LoginParseClass loginParseClass = new LoginParseClass();
    BufferedReader bufferedReader ;
    OutputStream outputStream ;
    StringBuilder stringBuilder = new StringBuilder();
    String Result ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = (Button)findViewById(R.id.button);

        username = (EditText) findViewById(R.id.username);

        password = (EditText)findViewById(R.id.password);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                GetCheckEditTextIsEmptyOrNot();

                if(CheckEditText){

                    LoginFunction(NameHolder,PasswordHolder);

                }
                else {

                    Toast.makeText(LoginActivity.this, "Please fill all form fields.", Toast.LENGTH_LONG).show();

                }



            }
        });
    }

    public void GetCheckEditTextIsEmptyOrNot(){

        NameHolder = username.getText().toString();
        PasswordHolder = password.getText().toString();

        if(TextUtils.isEmpty(NameHolder) || TextUtils.isEmpty(PasswordHolder))
        {

            CheckEditText = false;

        }
        else {

            CheckEditText = true ;
        }

    }

    public void LoginFunction(final String email, final String password){

        Toast.makeText(LoginActivity.this,"Button Clicked",Toast.LENGTH_SHORT).show();

        class LoginFunctionClass extends AsyncTask<String,Void,String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();

                progressDialog = ProgressDialog.show(LoginActivity.this,"Loading Data",null,true,true);
            }

            @Override
            protected void onPostExecute(String httpResponseMsg) {

                super.onPostExecute(httpResponseMsg);

                progressDialog.dismiss();

                if(httpResponseMsg.equalsIgnoreCase("Data Matched")){

                    finish();

                    Intent intent = new Intent(LoginActivity.this, Profile.class);

                    startActivity(intent);
                }else{

                    Toast.makeText(LoginActivity.this,httpResponseMsg,Toast.LENGTH_LONG).show();
                }
            }

            @Override
            protected String doInBackground(String... params) {

                hashMap.put("username",params[0]);

                hashMap.put("password",params[1]);

                finalResult = loginParseClass.postRequest(hashMap);

                return finalResult;
            }
        }

        LoginFunctionClass loginFunctionClass = new LoginFunctionClass();
        loginFunctionClass.execute(email,password);
    }

    public void ConnectionTest() {
        Log.d("Clionalog", "connection test");

        try {
            URL url = new URL(ServerLoginURL);
            Log.d("Clionalog", "preparing to Connect to " + ServerLoginURL);

            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");
            Log.d("Clionalog", "calling Connect to " + ServerLoginURL);

            urlConnection.connect();
            Log.d("Clionalog", "Connected to " + ServerLoginURL);

            InputStream inputStream = urlConnection.getInputStream();
            Log.d("Clionalog", "Retrieved Input Stream");

            StringBuffer buffer = new StringBuffer();
            if (inputStream == null) {
                Log.d("Clionalog", "no input found");
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line + "\n");
            }
            String str = buffer.toString();
            Log.d("Clionalog", "return is " + str);

        } catch (Exception e) {
            Log.d("clionalog", e.toString());
            e.printStackTrace();
        }
    }
    public class LoginParseClass
    {

        public String postRequest(HashMap<String, String> Data)
        {
            Log.d("Cliona", "data is: " + Data);
            ConnectionTest();


            try {
                url = new URL(ServerLoginURL);
                Log.d("Cliona LOgs", "ConnectionTest finished");
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

                httpURLConnection.setReadTimeout(12000);

                httpURLConnection.setConnectTimeout(12000);
                Log.d("Cliona LOgs", "ConnectionTimeout");

                httpURLConnection.setRequestMethod("POST");


                httpURLConnection.setDoInput(true);

                httpURLConnection.setDoOutput(true);

                outputStream = httpURLConnection.getOutputStream();
                Log.d("Cliona LOgs", "OutputStream");

                bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                bufferedWriter.write(FinalDataParse(Data));
                Log.d("Cliona LOgs", "FinalDataParse");

                bufferedWriter.flush();
                Log.d("Cliona LOgs", "flush");

                bufferedWriter.close();
                Log.d("Cliona LOgs", "bufferedWriter.close");

                outputStream.close();
                Log.d("Cliona LOgs", "outputStream.close");

                if (httpURLConnection.getResponseCode() == HttpsURLConnection.HTTP_OK) {
                    Log.d("Cliona LOgs", "getresponsecode");

                    bufferedReader = new BufferedReader(
                            new InputStreamReader(
                                    httpURLConnection.getInputStream()
                            )
                    );

                    Log.d("Cliona LOgs", "new bufferedreader");

                    FinalHttpData = bufferedReader.readLine();
                }
                else {
                    FinalHttpData = "Something Went Wrong";
                }
            } catch (Exception e) {
                e.printStackTrace();
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
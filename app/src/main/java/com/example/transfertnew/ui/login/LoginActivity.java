package com.example.transfertnew.ui.login;

import android.app.Activity;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.transfertnew.MainActivity;
import com.example.transfertnew.R;
import com.example.transfertnew.model.JwtRequest;
import com.example.transfertnew.service.ApiUtils;
import com.example.transfertnew.service.UserService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText loginEdt, passwordEdt;
    private Button submit;
    private UserService userService;
    private TextView msgTv;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginEdt = (EditText)findViewById(R.id.username);
        passwordEdt = (EditText)findViewById(R.id.password);
        msgTv = (TextView)findViewById(R.id.msgTv);

        userService = ApiUtils.getAPIUserService();

        submit = (Button) findViewById(R.id.login);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JwtRequest data = new JwtRequest(loginEdt.getText().toString(), passwordEdt.getText().toString());
                try {
                    sendPost(data);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            public void sendPost(final JwtRequest obj) throws Exception{
                userService.login(obj).enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        Toast.makeText(getApplicationContext(), "null", Toast.LENGTH_LONG).show();
                        if(response.isSuccessful()) {
                            if(response.body() == null){
                                Log.i("e", "null");
                                msgTv.setText("null");
                                //Toast.makeText(getApplicationContext(), "null", Toast.LENGTH_LONG).show();
                            }
                            else{
                                try {
                                    ApiUtils.init(response.body());
                                    Log.i("e", response.body());
                                    if(response.body().toString().equals("badcredentials")){
                                        //Toast.makeText(getApplicationContext(), "Login ou password incorrect !", Toast.LENGTH_SHORT).show();
                                        msgTv.setText("Login ou password incorrect !");
                                    }
                                    else {
                                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                        startActivity(intent);
                                    }
                                    //Toast.makeText(getApplicationContext(), response.body().toString().substring(0,19), Toast.LENGTH_SHORT).show();
                                }
                                catch(Exception e){
                                    e.printStackTrace();
                                }
                            }

                        }
                        else{
                            Log.i("e", "erreur");
                            msgTv.setText("code : "+response.code());
                           // Toast.makeText(getApplicationContext(), " code : "+response.code(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        msgTv.setText("Unable to submit post to API."+t.getMessage());
                        Log.e("e", "Unable to submit post to API."+t.getMessage());
                    }
                });
            }
        });




    }
}
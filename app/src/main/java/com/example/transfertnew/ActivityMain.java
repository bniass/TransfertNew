package com.example.transfertnew;

import android.content.Intent;
import android.os.Bundle;

import com.example.transfertnew.model.Client;
import com.example.transfertnew.model.JwtRequest;
import com.example.transfertnew.model.Operation;
import com.example.transfertnew.model.Rating;
import com.example.transfertnew.model.User;
import com.example.transfertnew.service.ApiUtils;
import com.example.transfertnew.service.OperationService;
import com.example.transfertnew.ui.login.LoginActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityMain extends AppCompatActivity {

    private EditText numpieceExp, nomExp, prenomExp, telExp, numpieceDest, nomDest, prenomDest, telDest;

    private Button saveBtn;
    private int commission;

    private EditText montantEdt;
    private TextView fraisTv;
    private OperationService operationService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        numpieceExp = (EditText)findViewById(R.id.numpieceExp);
        nomExp = (EditText)findViewById(R.id.nomExp);
        prenomExp = (EditText)findViewById(R.id.prenomExp);
        telExp = (EditText)findViewById(R.id.telExp);

        telExp.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!telExp.getText().toString().trim().isEmpty()){
                    findExpediteur(telExp.getText().toString().trim());
                }
            }

            private void findExpediteur(String tel) {
                operationService.findClientByTel("Bearer "+ApiUtils.response().getData(), tel).enqueue(new Callback<Client>() {
                    @Override
                    public void onResponse(Call<Client> call, Response<Client> response) {
                        if(response.body() == null){
                            Log.i("e", "null");
                            //Toast.makeText(getApplicationContext(), "null", Toast.LENGTH_LONG).show();
                        }
                        else{
                            try {
                                if(response.body() != null){
                                    prenomExp.setText(response.body().getPrenom());
                                    nomExp.setText(response.body().getNom());
                                    numpieceExp.setText(response.body().getNumpiece());
                                }
                                else {
                                   Log.e("err", "Erreur");
                                }
                                //Toast.makeText(getApplicationContext(), response.body().toString().substring(0,19), Toast.LENGTH_SHORT).show();
                            }
                            catch(Exception e){
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<Client> call, Throwable t) {
                        Log.e("err", t.getMessage());
                    }
                });
            }
        });

        numpieceDest = (EditText)findViewById(R.id.numpieceDest);
        nomDest = (EditText)findViewById(R.id.nomDest);
        prenomDest = (EditText)findViewById(R.id.prenomDest);
        telDest = (EditText)findViewById(R.id.telDest);


        telDest.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!telDest.getText().toString().trim().isEmpty()){
                    findDestinataire(telDest.getText().toString().trim());
                }
            }

            private void findDestinataire(String tel) {
                operationService.findClientByTel("Bearer "+ApiUtils.response().getData(), tel).enqueue(new Callback<Client>() {
                    @Override
                    public void onResponse(Call<Client> call, Response<Client> response) {
                        if(response.body() == null){
                            Log.i("e", "null");
                            //Toast.makeText(getApplicationContext(), "null", Toast.LENGTH_LONG).show();
                        }
                        else{
                            try {
                                if(response.body() != null){
                                    prenomDest.setText(response.body().getPrenom());
                                    nomDest.setText(response.body().getNom());
                                    numpieceDest.setText(response.body().getNumpiece());
                                }
                                else {
                                    Log.e("err", "Erreur");
                                }
                                //Toast.makeText(getApplicationContext(), response.body().toString().substring(0,19), Toast.LENGTH_SHORT).show();
                            }
                            catch(Exception e){
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<Client> call, Throwable t) {
                        Log.e("err", t.getMessage());
                    }
                });
            }
        });

        saveBtn = (Button) findViewById(R.id.saveBtn);

        montantEdt = (EditText)findViewById(R.id.montant);
        fraisTv = (TextView)findViewById(R.id.frais);
        operationService = ApiUtils.getAPOperationService();
        Log.e("er",ApiUtils.response().getData());

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Operation op = new Operation();
                SimpleDateFormat sf = new SimpleDateFormat("ddMMyyyyHHmmssSSS");
                String code = sf.format(new Date());
                op.setCode(code);
                op.setMontant(Integer.parseInt((montantEdt.getText()+"")));
                op.setCommission(commission);
                op.setCommissionDepot((int)(commission * Rating.DEPOSIT.getTaux()));
                op.setCommissionEtat((int)(commission * Rating.ETAT.getTaux()));
                op.setCommissionRetrait((int)(commission * Rating.RETRAIT.getTaux()));
                op.setCommissionSysteme((int)(commission * Rating.SYS.getTaux()));


                //le destinataire*
                Client dest = new Client();
                dest.setNom(nomDest.getText().toString());
                dest.setPrenom(prenomDest.getText().toString());
                dest.setNumpiece(numpieceDest.getText().toString());
                dest.setTel(telDest.getText().toString());
                op.setEnvoyeur(dest);

                // l'envoyeur
                Client env = new Client();
                env.setNom(nomExp.getText().toString());
                env.setPrenom(prenomExp.getText().toString());
                env.setNumpiece(numpieceExp.getText().toString());
                env.setTel(telExp.getText().toString());
                op.setDestinataire(env);

                // user qui fait l'envoi
                User user = ApiUtils.response().getUser();
                op.setUserEnvoyeur(user);

                try {
                    sendPost(op);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            public void sendPost(final Operation obj) throws Exception{

                operationService.add("Bearer "+ApiUtils.response().getData(), obj).enqueue(new Callback<Operation>() {

                    @Override
                    public void onResponse(Call<Operation> call, Response<Operation> response) {
                        Log.i("e", "ID OP : "+response.body().getId()+"");
                        try {
                            Intent intent = new Intent(ActivityMain.this, RecapEnvoiActivity.class);
                            intent.putExtra("operation", response.body());
                            startActivity(intent);
                        }catch(Exception e){
                            Log.e("errrrrrrrrrrrrrrrrrrrrr",e.getMessage());
                        }

                    }

                    @Override
                    public void onFailure(Call<Operation> call, Throwable t) {
                        Log.e("e", "Erreur : "+t.getMessage());
                    }
                });
            };
        });

        montantEdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
               int mont = Integer.parseInt(s.toString());
               if(mont < 10){
                   fraisTv.setText("0");
               }
               else {
                   Rating r = Rating.TAUXCOMMISSION;
                   commission = (int)(r.getTaux() * mont);
                   fraisTv.setText(commission+"");
               }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }
}
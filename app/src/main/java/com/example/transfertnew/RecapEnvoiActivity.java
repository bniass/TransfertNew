package com.example.transfertnew;

import android.content.Intent;
import android.os.Bundle;

import com.example.transfertnew.model.Operation;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RecapEnvoiActivity extends AppCompatActivity {

    private TextView numpieceExp, nomExp, prenomExp, telExp, numpieceDest, nomDest, prenomDest, telDest;

    private Button retourBtn;
    private int commission;

    private TextView montantEdt;
    private TextView codeTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recap_envoi);

        if(getIntent().getSerializableExtra("operation") != null) {

            numpieceExp = (TextView) findViewById(R.id.numpieceExpTv);
            nomExp = (TextView) findViewById(R.id.nomExpTv);
            prenomExp = (TextView) findViewById(R.id.prenomExpTv);
            telExp = (TextView) findViewById(R.id.telExpTv);

            numpieceDest = (TextView) findViewById(R.id.numpieceDestTv);
            nomDest = (TextView) findViewById(R.id.nomDestTv);
            prenomDest = (TextView) findViewById(R.id.prenomDestTv);
            telDest = (TextView) findViewById(R.id.telDestTv);

            retourBtn = (Button) findViewById(R.id.retourBtn);

            montantEdt = (TextView) findViewById(R.id.montantTv);
            codeTv = (TextView) findViewById(R.id.codeTv);

            Operation op = (Operation) getIntent().getSerializableExtra("operation");

            numpieceExp.setText("Numéro d'identification Exp : "+op.getEnvoyeur().getNumpiece());
            nomExp.setText("Nom expéditeur : "+op.getEnvoyeur().getNom());
            prenomExp.setText("Prénom expéditeur : "+op.getEnvoyeur().getPrenom());
            telExp.setText("Téléphone expéditeur : "+op.getEnvoyeur().getTel());

            numpieceDest.setText("Numéro d'identification Dest : "+op.getDestinataire().getNumpiece());
            nomDest.setText("Nom Destinataire : "+op.getDestinataire().getNom());
            prenomDest.setText("Prénom destinataire : "+op.getDestinataire().getPrenom());
            telDest.setText("Téléphone destinataire : "+op.getDestinataire().getTel());

            String msg = "Montant : "+op.getMontant()+"\n";
            msg +="Frais : "+op.getCommission()+"\n";
            msg +="Votre commission : "+op.getCommissionDepot()+"\n";
            montantEdt.setText(msg);

            codeTv.setText(op.getCode());

            retourBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(RecapEnvoiActivity.this, ActivityMain.class);
                    startActivity(intent);
                }
            });


        }
        else{
            Intent intent = new Intent(RecapEnvoiActivity.this, ActivityMain.class);
            startActivity(intent);
        }



    }
}
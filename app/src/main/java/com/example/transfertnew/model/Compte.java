package com.example.transfertnew.model;


import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

public class Compte {
    @SerializedName("id")
    private int id;
    @SerializedName("numero")
    private String numero;
    @SerializedName("datecreation")
    private Date datecreation;
    @SerializedName("solde")
    private  int solde;

    @SerializedName("partenaire")
    private Partenaire partenaire;

    @SerializedName("users")
    private List<User> users;



    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getDatecreation() {
        return datecreation;
    }

    public void setDatecreation(Date datecreation) {
        this.datecreation = datecreation;
    }

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }

    public Partenaire getPartenaire() {
        return partenaire;
    }

    public void setPartenaire(Partenaire partenaire) {
        this.partenaire = partenaire;
    }
}

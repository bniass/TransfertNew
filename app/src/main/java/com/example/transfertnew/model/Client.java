package com.example.transfertnew.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Client {
    @SerializedName("id")
    private int id;
    @SerializedName("numpiece")
    private String numpiece;
    @SerializedName("nom")
    private String nom;
    @SerializedName("prenom")
    private String prenom;
    @SerializedName("tel")
    private String tel;

    @SerializedName("envois")
    private List<Operation> envois;

    @SerializedName("retraits")
    private List<Operation> retraits;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumpiece() {
        return numpiece;
    }

    public void setNumpiece(String numpiece) {
        this.numpiece = numpiece;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public List<Operation> getEnvois() {
        return envois;
    }

    public void setEnvois(List<Operation> envois) {
        this.envois = envois;
    }

    public List<Operation> getRetraits() {
        return retraits;
    }

    public void setRetraits(List<Operation> retraits) {
        this.retraits = retraits;
    }



}

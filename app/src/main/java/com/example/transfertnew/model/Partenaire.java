package com.example.transfertnew.model;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Partenaire {
    @SerializedName("id")
    private int id;
    @SerializedName("raisonSocial")
    private String raisonSocial;
    @SerializedName("adresse")
    private String adresse;
    @SerializedName("email")
    private String email;
    @SerializedName("tel")
    private String tel;
    @SerializedName("users")
    private List<User> users;

    @SerializedName("comptes")
    private List<Compte> comptes;

    public List<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(List<Compte> comptes) {
        this.comptes = comptes;
    }

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

    public String getRaisonSocial() {
        return raisonSocial;
    }

    public void setRaisonSocial(String raisonSocial) {
        this.raisonSocial = raisonSocial;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}

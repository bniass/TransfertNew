package com.example.transfertnew.model;


import com.google.gson.annotations.SerializedName;

import java.util.Date;


public class Operation {
    @SerializedName("id")
    private int id;
    @SerializedName("dateEnvoi")
    private Date dateEnvoi;
    @SerializedName("dateRecuperation")
    private Date dateRecuperation;
    @SerializedName("code")
    private String code;
    @SerializedName("montant")
    private int montant;
    @SerializedName("commission")
    private int commission;
    @SerializedName("commissionDepot")
    private int commissionDepot;
    @SerializedName("commissionRetrait")
    private int commissionRetrait;
    @SerializedName("commissionEtat")
    private int commissionEtat;
    @SerializedName("commissionSysteme")
    private int commissionSysteme;

    @SerializedName("envoyeur")
    private Client envoyeur;

    @SerializedName("destinataire")
    private Client destinataire;

    @SerializedName("userEnvoyeur")
    private User userEnvoyeur;

    @SerializedName("userRemetteur")
    private User userRemetteur;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateEnvoi() {
        return dateEnvoi;
    }

    public void setDateEnvoi(Date dateEnvoi) {
        this.dateEnvoi = dateEnvoi;
    }

    public Date getDateRecuperation() {
        return dateRecuperation;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDateRecuperation(Date dateRecuperation) {
        this.dateRecuperation = dateRecuperation;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public int getCommission() {
        return commission;
    }

    public void setCommission(int commission) {
        this.commission = commission;
    }

    public int getCommissionDepot() {
        return commissionDepot;
    }

    public void setCommissionDepot(int commissionDepot) {
        this.commissionDepot = commissionDepot;
    }

    public int getCommissionRetrait() {
        return commissionRetrait;
    }

    public void setCommissionRetrait(int commissionRetrait) {
        this.commissionRetrait = commissionRetrait;
    }

    public int getCommissionEtat() {
        return commissionEtat;
    }

    public void setCommissionEtat(int commissionEtat) {
        this.commissionEtat = commissionEtat;
    }

    public int getCommissionSysteme() {
        return commissionSysteme;
    }

    public void setCommissionSysteme(int commissionSysteme) {
        this.commissionSysteme = commissionSysteme;
    }

    public Client getEnvoyeur() {
        return envoyeur;
    }

    public void setEnvoyeur(Client envoyeur) {
        this.envoyeur = envoyeur;
    }

    public Client getDestinataire() {
        return destinataire;
    }

    public void setDestinataire(Client destinataire) {
        this.destinataire = destinataire;
    }

    public User getUserEnvoyeur() {
        return userEnvoyeur;
    }

    public void setUserEnvoyeur(User userEnvoyeur) {
        this.userEnvoyeur = userEnvoyeur;
    }

    public User getUserRemetteur() {
        return userRemetteur;
    }

    public void setUserRemetteur(User userRemetteur) {
        this.userRemetteur = userRemetteur;
    }





}

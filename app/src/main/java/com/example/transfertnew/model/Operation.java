package com.example.transfertnew.model;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;


public class Operation implements Parcelable {
    @SerializedName("id")
    private int id;
    @SerializedName("dateEnvoi")
    private String dateEnvoi;
    @SerializedName("dateRecuperation")
    private String dateRecuperation;
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

    public Operation(Parcel in) {
        id = in.readInt();
        dateEnvoi = in.readString();
        dateRecuperation = in.readString();
        code = in.readString();
        montant = in.readInt();
        commission= in.readInt();
        commissionDepot= in.readInt();
        commissionRetrait= in.readInt();
        commissionEtat= in.readInt();
        commissionSysteme= in.readInt();
        envoyeur = (Client) in.readParcelable(Client.class.getClassLoader());
        destinataire = (Client) in.readParcelable(Client.class.getClassLoader());
        userEnvoyeur = (User) in.readParcelable(User.class.getClassLoader());
        userRemetteur = (User) in.readParcelable(User.class.getClassLoader());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateEnvoi() {
        return dateEnvoi;
    }

    public void setDateEnvoi(String dateEnvoi) {
        this.dateEnvoi = dateEnvoi;
    }

    public String getDateRecuperation() {
        return dateRecuperation;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDateRecuperation(String dateRecuperation) {
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


    @Override
    public int describeContents() {
        return 0;
    }

    // this is used to regenerate your object. All Parcelables must have a CREATOR that implements these two methods
    public static final Parcelable.Creator<Operation> CREATOR = new Parcelable.Creator<Operation>() {
        public Operation createFromParcel(Parcel in) {
            return new Operation(in);
        }

        @Override
        public Operation[] newArray(int size) {
            return new Operation[0];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(dateEnvoi);
        dest.writeString(dateRecuperation);
        dest.writeString(code);
        dest.writeInt(montant);
        dest.writeInt(commission);
        dest.writeInt(commissionDepot);
        dest.writeInt(commissionRetrait);
        dest.writeInt(commissionEtat);
        dest.writeInt(commissionSysteme);

        dest.writeParcelable(envoyeur, flags);
        dest.writeParcelable(destinataire, flags);
        dest.writeParcelable(userEnvoyeur, flags);
        dest.writeParcelable(userRemetteur, flags);
    }
}

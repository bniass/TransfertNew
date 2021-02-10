package com.example.transfertnew.service;


import com.example.transfertnew.model.Client;
import com.example.transfertnew.model.JwtRequest;
import com.example.transfertnew.model.Operation;
import com.example.transfertnew.model.Response;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface OperationService {

    @POST("/api/operation/envoi")
    Call<Operation> add(@Header("Authorization") String token, @Body Operation op);

    @GET("/api/operation/expediteur/{tel}")
    Call<Client> findClientByTel(@Header("Authorization") String token, @Path("tel") String tel);

}

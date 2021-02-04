package com.example.transfertnew.service;


import com.example.transfertnew.model.JwtRequest;
import com.example.transfertnew.model.JwtResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface UserService {

    @POST("/authenticate")
    Call<JwtResponse> connexion(@Body JwtRequest obj);

    @POST("/login")
    Call<String> login(@Body JwtRequest obj);
}

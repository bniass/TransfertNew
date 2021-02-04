package com.example.transfertnew.service;

public class ApiUtils {

    private ApiUtils() {}

    public static final String BASE_URL = "http://10.0.2.2:8080/"; // 10.0.2.2
    private static String token;


    public static UserService getAPIUserService() {
        return RetrofitClient.getClient(BASE_URL).create(UserService.class);
    }


    public static String init(String token) {
        return com.example.transfertnew.service.ApiUtils.token = token;
    }

    public static String getToken() {
        return token;
    }
}

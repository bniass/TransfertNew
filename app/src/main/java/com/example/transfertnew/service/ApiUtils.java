package com.example.transfertnew.service;

import com.example.transfertnew.model.Response;

public class ApiUtils {

    private ApiUtils() {}

    public static final String BASE_URL = "http://10.0.2.2:8080/"; // 10.0.2.2
    private static Response response;


    public static UserService getAPIUserService() {
        return RetrofitClient.getClient(BASE_URL).create(UserService.class);
    }

    public static OperationService getAPOperationService() {
        return RetrofitClient.getClient(BASE_URL).create(OperationService.class);
    }


    public static void init(Response response) {
        ApiUtils.response = response;
    }

    public static Response response() {
        return response;
    }

}

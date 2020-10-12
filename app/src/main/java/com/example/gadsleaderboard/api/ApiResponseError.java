package com.example.gadsleaderboard.api;

import retrofit2.Response;

public class ApiResponseError extends Throwable {
    private Response mResponse;

    public ApiResponseError (Response response){
        this.mResponse = response;
    }

    public Response getResponse() {
        return mResponse;
    }
}


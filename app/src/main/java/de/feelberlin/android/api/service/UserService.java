package de.feelberlin.android.api.service;


import java.util.Map;

import de.feelberlin.android.api.ApiService;
import de.feelberlin.android.api.ResultHandler;
import de.feelberlin.android.api.ServiceFactory;
import de.feelberlin.android.api.response.LoginResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserService {

    public void register(String deviceId, Map<String, Object> options, final ResultHandler handler) {

        ApiService apiService = ServiceFactory.createApiService();
        Call<LoginResponse> call = apiService.register(deviceId, options);
        call.enqueue(new Callback<LoginResponse>() {

            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    handler.onSuccess(response.body());
                } else {
                    handler.onError(response.message());
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                handler.onError(t.getMessage());
                t.printStackTrace();
            }
        });
    }

    public void login(String deviceId, Map<String, Object> options, final ResultHandler handler) {

        ApiService apiService = ServiceFactory.createApiService();
        Call<LoginResponse> call = apiService.login(deviceId, options);
        call.enqueue(new Callback<LoginResponse>() {

            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    handler.onSuccess(response.body());
                } else {
                    handler.onError(response.message());
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                handler.onError(t.getMessage());
                t.printStackTrace();
            }
        });
    }

}
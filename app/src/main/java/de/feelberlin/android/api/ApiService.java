package de.feelberlin.android.api;

import java.util.Map;

import de.feelberlin.android.api.response.LoginResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {

    @POST("auth/{DEVICE_UID}")
    Call<LoginResponse> login(@Path("DEVICE_UID") String uid, @Body Map<String, Object> options);

    @POST("auth/singup/{DEVICE_UID}")
    Call<LoginResponse> register(@Path("DEVICE_UID") String uid, @Body Map<String, Object> options);

}
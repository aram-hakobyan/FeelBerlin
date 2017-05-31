package de.feelberlin.android.api.response;

import com.google.gson.annotations.SerializedName;

import de.feelberlin.android.api.response.errors.LoginErrors;
import de.feelberlin.android.model.User;

/**
 * Created by Aram_Hakobyan on 5/31/2017.
 */

public class LoginResponse {

    @SerializedName("success_message")
    public String message;

    @SerializedName("result")
    public User user;

    @SerializedName("errors")
    public LoginErrors errors;
}

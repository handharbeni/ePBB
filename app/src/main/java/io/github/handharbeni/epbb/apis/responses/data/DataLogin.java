package io.github.handharbeni.epbb.apis.responses.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataLogin {
    @SerializedName("token")
    @Expose
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "DataLogin{" +
                "token='" + token + '\'' +
                '}';
    }
}

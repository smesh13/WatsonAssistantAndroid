package com.example.def.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MessageResponse {
    public MessageText[] getGeneric() {
        return generic;
    }

    public void setGeneric(MessageText[] generic) {
        this.generic = generic;
    }

    @SerializedName("generic")
    @Expose
    MessageText[] generic;

    @SerializedName("intents")
    @Expose
    Intent[] intents;

    @SerializedName("entities")
    @Expose
    String[] entities;
}

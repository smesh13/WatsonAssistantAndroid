package com.example.def.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Intent {


    @SerializedName("intent")
    @Expose
    private String intent;


    @SerializedName("confidence")
    @Expose
    private double confidence;

    public String getIntent() {
        return intent;
    }

    public void setIntent(String intent) {
        this.intent = intent;
    }

    public double getConfidence() {
        return confidence;
    }

    public void setConfidence(double confidence) {
        this.confidence = confidence;
    }


}
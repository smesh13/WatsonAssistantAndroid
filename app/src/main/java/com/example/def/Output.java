package com.example.def;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Output {

    @SerializedName("generic")
    @Expose
    private List<Generic> generic = null;
    @SerializedName("intents")
    @Expose
    private List<Object> intents = null;
    @SerializedName("entities")
    @Expose
    private List<Object> entities = null;

    public List<Generic> getGeneric() {
        return generic;
    }

    public void setGeneric(List<Generic> generic) {
        this.generic = generic;
    }

    public List<Object> getIntents() {
        return intents;
    }

    public void setIntents(List<Object> intents) {
        this.intents = intents;
    }

    public List<Object> getEntities() {
        return entities;
    }

    public void setEntities(List<Object> entities) {
        this.entities = entities;
    }

}
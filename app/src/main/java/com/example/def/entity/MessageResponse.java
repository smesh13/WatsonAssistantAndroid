package com.example.def.entity;

import com.example.def.retrofit.Intent;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MessageResponse {
    MessageOutput output;

    public MessageOutput getOutput() {
        return output;
    }

    public void setOutput(MessageOutput output) {
        this.output = output;
    }

    public MessageContext getContext() {
        return context;
    }

    public void setContext(MessageContext context) {
        this.context = context;
    }

    MessageContext context;
}

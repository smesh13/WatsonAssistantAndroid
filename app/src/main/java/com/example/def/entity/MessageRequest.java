package com.example.def.entity;

public class MessageRequest {

    MessageContext context;

    MessageInput input;

    public MessageInput getInput() {
        return input;
    }

    public void setInput(MessageInput input) {
        this.input = input;
    }

    public MessageContext getContext() {
        return context;
    }

    public void setContext(MessageContext context) {
        this.context = context;
    }
}

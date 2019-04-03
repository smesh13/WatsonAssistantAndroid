package com.example.def.entity;

public class MessageInput {
    String message_type;
    String text;
    MessageInputOptions options;
    RuntimeIntent[] intents;
    RuntimeEntity[] entities;

    public RuntimeEntity[] getEntities() {
        return entities;
    }

    public void setEntities(RuntimeEntity[] entities) {
        this.entities = entities;
    }

    public String getSuggestion_id() {
        return suggestion_id;
    }

    public void setSuggestion_id(String suggestion_id) {
        this.suggestion_id = suggestion_id;
    }

    String suggestion_id;

    public RuntimeIntent[] getIntents() {
        return intents;
    }

    public void setIntents(RuntimeIntent[] intents) {
        this.intents = intents;
    }

    public String getMessage_type() {
        return message_type;
    }

    public void setMessage_type(String message_type) {
        this.message_type = message_type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public MessageInputOptions getOptions() {
        return options;
    }

    public void setOptions(MessageInputOptions options) {
        this.options = options;
    }
}

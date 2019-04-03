package com.example.def.entity;

public class MessageOutput {
    DialogRuntimeResponseGeneric[] generic;
    RuntimeIntent[] intents;
    RuntimeEntity[] entities;
    DialogNodeAction[] actions;

    public DialogRuntimeResponseGeneric[] getGeneric() {
        return generic;
    }

    public void setGeneric(DialogRuntimeResponseGeneric[] generic) {
        this.generic = generic;
    }

    public RuntimeIntent[] getIntents() {
        return intents;
    }

    public void setIntents(RuntimeIntent[] intents) {
        this.intents = intents;
    }

    public RuntimeEntity[] getEntities() {
        return entities;
    }

    public void setEntities(RuntimeEntity[] entities) {
        this.entities = entities;
    }

    public DialogNodeAction[] getActions() {
        return actions;
    }

    public void setActions(DialogNodeAction[] actions) {
        this.actions = actions;
    }

    public MessageOutputDebug getDebug() {
        return debug;
    }

    public void setDebug(MessageOutputDebug debug) {
        this.debug = debug;
    }

    public Object getUser_defined() {
        return user_defined;
    }

    public void setUser_defined(Object user_defined) {
        this.user_defined = user_defined;
    }

    MessageOutputDebug debug;
    Object user_defined;
}

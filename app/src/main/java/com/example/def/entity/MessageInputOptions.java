package com.example.def.entity;

public class MessageInputOptions {
    boolean debug;
    boolean restart;
    boolean alternate_intents;
    boolean return_context;

    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public boolean isRestart() {
        return restart;
    }

    public void setRestart(boolean restart) {
        this.restart = restart;
    }

    public boolean isAlternate_intents() {
        return alternate_intents;
    }

    public void setAlternate_intents(boolean alternate_intents) {
        this.alternate_intents = alternate_intents;
    }

    public boolean isReturn_context() {
        return return_context;
    }

    public void setReturn_context(boolean return_context) {
        this.return_context = return_context;
    }
}

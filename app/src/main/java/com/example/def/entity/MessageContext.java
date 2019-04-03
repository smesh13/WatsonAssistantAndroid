package com.example.def.entity;

public class MessageContext {

    public MessageContextGlobal getGlobal() {
        return global;
    }

    public void setGlobal(MessageContextGlobal global) {
        this.global = global;
    }

    MessageContextGlobal global;

    public Skill getSkills() {
        return skills;
    }

    public void setSkills(Skill skills) {
        this.skills = skills;
    }

    Skill skills;
}

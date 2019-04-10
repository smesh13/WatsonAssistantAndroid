package com.example.def.entity;

public class MessageContextGlobalSystem {
    String timezone;

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getTurn_count() {
        return turn_count;
    }

    public void setTurn_count(String turn_count) {
        this.turn_count = turn_count;
    }

    String user_id;
    String turn_count;
}

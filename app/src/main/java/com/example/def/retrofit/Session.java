package com.example.def.retrofit;

public abstract class Session {

    public abstract boolean isLoggedIn();

    public abstract void invalidate();

    static String token = "123";

    static String userId = "apikey";

    static String password = "syRUmO5OizoHJM-Ur99kW923Zoz8iK6bE6I7qFyNHt2v";

    public void saveToken(String token) {
        Session.token = token;
    }

    public String getToken() {
        // return the token that was saved earlier
        return Session.token;
    }

    public void saveUserId(String userId) {
        Session.userId = userId;
    }

    public void saveUserId() {
        // save user's userId
    }

    public String getUserId() {
        return Session.userId;
    }

    public void savePassword(String password) {
        Session.password = password;
    }

    public void savePassword() {
        // encrypt and save
    }

    public String getPassword() {
        // decrypt and return
        return Session.password;
    }

}
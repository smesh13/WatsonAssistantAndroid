package com.example.def.entity;

public class DialogNodeAction {
    String name;
    String result_variable;
    String type;
    Object parameters;
    String credentials;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResult_variable() {
        return result_variable;
    }

    public void setResult_variable(String result_variable) {
        this.result_variable = result_variable;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getParameters() {
        return parameters;
    }

    public void setParameters(Object parameters) {
        this.parameters = parameters;
    }

    public String getCredentials() {
        return credentials;
    }

    public void setCredentials(String credentials) {
        this.credentials = credentials;
    }
}

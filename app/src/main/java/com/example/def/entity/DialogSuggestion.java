package com.example.def.entity;

public class DialogSuggestion {
    String label;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public DialogSuggestionValue getValue() {
        return value;
    }

    public void setValue(DialogSuggestionValue value) {
        this.value = value;
    }

    public Object getOutput() {
        return output;
    }

    public void setOutput(Object output) {
        this.output = output;
    }

    DialogSuggestionValue value;
    Object output;
}

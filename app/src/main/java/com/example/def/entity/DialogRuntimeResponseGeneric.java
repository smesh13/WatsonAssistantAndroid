package com.example.def.entity;

public class DialogRuntimeResponseGeneric {
    String response_type;
    String text;
    Integer time;
    boolean typing;
    String source;
    String title;
    String description;
    String preference;
    DialogNodeOutputOptionsElement[] options;
    String message_to_human_agent;
    String topic;

    public String getResponse_type() {
        return response_type;
    }

    public void setResponse_type(String response_type) {
        this.response_type = response_type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public boolean isTyping() {
        return typing;
    }

    public void setTyping(boolean typing) {
        this.typing = typing;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }

    public DialogNodeOutputOptionsElement[] getOptions() {
        return options;
    }

    public void setOptions(DialogNodeOutputOptionsElement[] options) {
        this.options = options;
    }

    public String getMessage_to_human_agent() {
        return message_to_human_agent;
    }

    public void setMessage_to_human_agent(String message_to_human_agent) {
        this.message_to_human_agent = message_to_human_agent;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public DialogSuggestion[] getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(DialogSuggestion[] suggestions) {
        this.suggestions = suggestions;
    }

    DialogSuggestion[] suggestions;
}

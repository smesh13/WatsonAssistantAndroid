package com.example.def;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Generic {

        @SerializedName("response_type")
        @Expose
        private String responseType;
        @SerializedName("text")
        @Expose
        private String text;

        public String getResponseType() {
            return responseType;
        }

        public void setResponseType(String responseType) {
            this.responseType = responseType;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

    }


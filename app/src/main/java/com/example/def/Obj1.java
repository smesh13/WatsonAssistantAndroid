package com.example.def;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Obj1 {

        @SerializedName("output")
        @Expose
        private Output output;

        public Output getOutput() {
            return output;
        }

        public void setOutput(Output output) {
            this.output = output;
        }


}

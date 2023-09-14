package com.slavbx.checkerbrackets.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

@Component
public class Response {

    private boolean isCorrect;

    public Response() {
    }

    public Response(boolean correct) {
        this.isCorrect = correct;
    }
    @JsonProperty("isCorrect")
    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        this.isCorrect = correct;
    }
}

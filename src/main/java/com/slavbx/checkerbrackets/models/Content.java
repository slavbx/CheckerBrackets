package com.slavbx.checkerbrackets.models;

import org.springframework.stereotype.Component;

@Component
public class Content {
    String text;

    public Content() {
    }

    public Content(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

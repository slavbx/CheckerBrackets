package com.slavbx.checkerbrackets.services;

import com.slavbx.checkerbrackets.models.Content;
import com.slavbx.checkerbrackets.models.Response;
import org.springframework.stereotype.Service;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ContentService {

    public ContentService() {
    }

    public Response check(Content content) {
        if (content.getText().contains("()")) {
            return new Response(false);
        } else {
            Deque<String> stack = new ArrayDeque<>();
            Pattern pattern = Pattern.compile("[()]");
            Matcher matcher = pattern.matcher(content.getText());
            while (matcher.find()) {
                if (matcher.group().equals("(")) {
                    stack.addFirst("(");
                } else if (matcher.group().equals(")")) {
                    if (stack.isEmpty()) {
                        return new Response(false);
                    } else {
                        stack.pop();
                    }
                }
            }
            return new Response(stack.isEmpty());
        }
    }
}

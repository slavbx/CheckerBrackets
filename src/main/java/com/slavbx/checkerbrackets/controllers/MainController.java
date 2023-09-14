package com.slavbx.checkerbrackets.controllers;

import com.slavbx.checkerbrackets.models.Content;
import com.slavbx.checkerbrackets.services.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MainController {
    ContentService contentService;

    @Autowired
    public MainController(ContentService contentService) {
        this.contentService = contentService;
    }

    @PostMapping("/checkBrackets")
    public ResponseEntity<?> checkBrackets(@RequestBody Content content) {
        if(content.getText() == null || content.getText().equals("")) {
            return new ResponseEntity<>(new Content("Empty text was received!"), HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(contentService.check(content), HttpStatus.OK);
        }
    }

}

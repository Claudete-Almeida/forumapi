package com.forum.forum.controllers.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @GetMapping("/health-check")
    public ResponseEntity<String> checkHealthCheck () {
        return new ResponseEntity<String>("API running successfully", HttpStatus.OK);
    }
}

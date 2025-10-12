package com.artemrogov.secure_login_gateway.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(value = "/api/profiles")
@RequiredArgsConstructor
@Slf4j
public class ProfilesController {

    @GetMapping
    public ResponseEntity<String> getTestEndPointAuth(){
        return ResponseEntity.ok("Test endpoint");
    }

    @GetMapping(value = "/no-auth")
    public ResponseEntity<String> getTestEndPointAuthNoAuth(){
        return ResponseEntity.ok("Я доступен всегда");
    }
}

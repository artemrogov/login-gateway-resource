package com.artemrogov.secure_login_gateway.controller;


import com.artemrogov.secure_login_gateway.utility.OAuthProfileData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController()
@RequestMapping(value = "/api/profiles")
@RequiredArgsConstructor
@Slf4j
public class ProfilesController {

    private final OAuthProfileData currentProfileFullData;

    @GetMapping
    public ResponseEntity<Map<String, Object>> getCurrentAuthProfile(){
        return ResponseEntity.ok(currentProfileFullData.getAuthProfileFullData());
    }

    @GetMapping(value = "/no-auth")
    public ResponseEntity<String> getTestEndPointAuthNoAuth(){
        return ResponseEntity.ok("Я доступен всегда");
    }
}

package com.artemrogov.secure_login_gateway.utility;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Slf4j
@RequiredArgsConstructor
public class OAuthProfileData {

    /**
     * Retrieves full profile data for the currently authenticated user.
     *
     * @return A map containing attribute names and their corresponding values.
     */
    public Map<String, Object> getAuthProfileFullData() {
        Authentication authToken = SecurityContextHolder.getContext().getAuthentication();
        return ((JwtAuthenticationToken) authToken).getTokenAttributes();
    }
}

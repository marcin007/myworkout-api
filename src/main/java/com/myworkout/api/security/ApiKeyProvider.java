package com.myworkout.api.security;

import com.myworkout.api.entity.ApiKey;
import com.myworkout.api.repository.ApiKeysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class ApiKeyProvider {

    private ApiKeysRepository apiKeysRepository;
    private UserDetailsService userDetailsService;
    @Autowired
    public ApiKeyProvider(ApiKeysRepository apiKeysRepository, UserDetailsService userDetailsService) {
        this.apiKeysRepository = apiKeysRepository;
        this.userDetailsService = userDetailsService;
    }

    public Authentication getAuthentication(String apiKeyValue) { //znajdywanie uzytkownika
        ApiKey apiKey = apiKeysRepository.findByValue(apiKeyValue).orElseThrow();// TODO: 06.05.2020 custom exception
        String username = apiKey.getUser().getUsername();

        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        if(userDetails.isEnabled() && userDetails.isAccountNonLocked()){
            return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
        }

        return null;
    }

    public String getApiKey(HttpServletRequest request) {
        String apiKey = request.getHeader("APIKey");
        if (apiKey.length() == 4) {
            return apiKey;
        }

        return null;
    }

}

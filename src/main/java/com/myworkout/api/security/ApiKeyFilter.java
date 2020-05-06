package com.myworkout.api.security;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class ApiKeyFilter extends GenericFilterBean {

    Logger logger = LoggerFactory.getLogger(ApiKeyFilter.class);

    private ApiKeyProvider apiKeyProvider;

    public ApiKeyFilter(ApiKeyProvider apiKeyProvider) {
        this.apiKeyProvider = apiKeyProvider;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain) throws IOException, ServletException {
        logger.debug("filtruje request");

        String apiKey = apiKeyProvider.getApiKey((HttpServletRequest) req);
        Authentication authentication = apiKeyProvider.getAuthentication(apiKey);
        if(authentication != null){
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(req, res);
    }

}

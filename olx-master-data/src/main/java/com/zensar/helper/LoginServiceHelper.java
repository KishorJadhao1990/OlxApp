package com.zensar.helper;

import com.zensar.constants.EndpointConstants;
import com.zensar.model.User;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.WebRequest;

@Slf4j
@Component
public class LoginServiceHelper {

    @Autowired
    private RestTemplate restTemplate;

    @CircuitBreaker(name = "authenticate-user", fallbackMethod = "fallbackForAuthenticateUser")
    public User authenticateUser(WebRequest webRequest) {
        String token = webRequest.getHeader("Authorization");
        HttpEntity<String> entity = new HttpEntity<>(setAuthorizationHeader(token));
        ResponseEntity<User> response = restTemplate
                .exchange(EndpointConstants.LOGIN_VALIDATE.value(), HttpMethod.GET, entity, User.class);
        return response.getBody();
    }

    public User fallbackForAuthenticateUser (WebRequest webRequest, Throwable throwable) throws Throwable {
        log.error("fallbackForAuthenticateUser message :{}", throwable.getMessage());
        throw throwable;
    }

    private HttpHeaders setAuthorizationHeader(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}

package com.zensar.helper;

import com.zensar.constants.EndpointConstants;
import com.zensar.exception.BadRequestException;
import com.zensar.model.User;
import com.zensar.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.WebRequest;

@Slf4j
@Service
public class LoginServiceHelper {

    @Autowired
    private RestTemplate restTemplate;

    public User authenticateUser(WebRequest webRequest) {
        String token = webRequest.getHeader("Authorization");
        return authenticateUser(token);
    }

    public User authenticateUser(String token) {
        HttpEntity<String> entity = new HttpEntity<>(setAuthorizationHeader(token));
        ResponseEntity<User> response = restTemplate
                .exchange(EndpointConstants.LOGIN_VALIDATE.value(), HttpMethod.GET, entity, User.class);
        if (!response.getStatusCode().equals(HttpStatus.OK) || response.getBody() == null) {
            throw new BadRequestException("invalid.authenticationToken");
        }
        return response.getBody();
    }

    private HttpHeaders setAuthorizationHeader (String token){
        token = !StringUtil.isEmpty(token) && token.startsWith("Bearer ") ? token.substring(7) : token;
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

}

package com.zensar.helper;

import com.zensar.model.User;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

@Component
public interface LoginServiceHelper {

    User authenticateUser(String token);
    User authenticateUser(WebRequest webRequest);

}

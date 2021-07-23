package com.zensar.helper;

import com.zensar.constants.EndpointConstants;
import com.zensar.model.Category;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class CategoryServiceHelperImpl implements CategoryServiceHelper {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    @CircuitBreaker(name = "fetch-category", fallbackMethod = "fallbackForFetchCategory")
    public Category fetchCategory(Long categoryId, String token) {
        HttpEntity<String> entity = new HttpEntity<>(setAuthorizationHeader(token));
        ResponseEntity<Category> response = restTemplate
                .exchange(EndpointConstants.FETCH_CATEGORY.value(), HttpMethod.GET, entity, Category.class, categoryId);
        return response.getBody();
    }

    private Category fallbackForFetchCategory (Long categoryId, String token, Throwable throwable) throws Throwable {
        log.error("fallbackForFetchCategory message: {}", throwable.getMessage());
        throw throwable;
    }

    private HttpHeaders setAuthorizationHeader(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}

package com.zensar.helper;

import com.zensar.constants.EndpointConstants;
import com.zensar.exception.BadRequestException;
import com.zensar.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CategoryServiceHelper {

    @Autowired
    private RestTemplate restTemplate;

    public Category fetchCategory(Long categoryId) {
        ResponseEntity<Category> response = restTemplate.getForEntity
                (EndpointConstants.FETCH_CATEGORY.value(), Category.class, categoryId);
        if (!response.getStatusCode().equals(HttpStatus.OK)) {
            throw new BadRequestException("error.failedToFetchCategory");
        }
        return response.getBody();
    }
}

package com.zensar.controller;

import com.zensar.exception.BadRequestException;
import com.zensar.helper.LoginServiceHelper;
import com.zensar.model.Category;
import com.zensar.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    @Qualifier("categoryMongoService")
    private CategoryService categoryService;
    @Autowired
    private LoginServiceHelper loginServiceHelper;

    @GetMapping("/")
    public List<Category> fetchAllAdvertiseCategory(WebRequest webRequest) {
        loginServiceHelper.authenticateUser(webRequest);
        return categoryService.fetchAllAdvertiseCategory();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> fetchAdvertiseCategory(@PathVariable Long id, WebRequest webRequest) {
        loginServiceHelper.authenticateUser(webRequest);
        Optional<Category> categoryOpt = categoryService.fetchAdvertiseCategory(id);
        categoryOpt.orElseThrow(() -> new BadRequestException("error.categoryNotFound"));
        return new ResponseEntity<>(categoryOpt.get(), HttpStatus.OK);
    }

    @GetMapping("/status")
    public ResponseEntity<Map> findAdvertiseCategoryStatuses(WebRequest webRequest) {
        loginServiceHelper.authenticateUser(webRequest);
        Map<Long, String> resultMap = (Map<Long, String>) categoryService.findAdvertiseCategoryStatuses();
        return new ResponseEntity<>(resultMap, HttpStatus.OK);
    }
}

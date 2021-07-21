package com.zensar.service;

import com.zensar.model.Category;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public interface CategoryService {

    List<Category> fetchAllAdvertiseCategory();
    Optional<Category> fetchAdvertiseCategory(Long id);
    Map<Long, String> findAdvertiseCategoryStatuses();

}

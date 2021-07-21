package com.zensar.service;

import com.zensar.model.Category;
import com.zensar.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Primary
@Service("categoryRdbmsService")
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> fetchAllAdvertiseCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> fetchAdvertiseCategory(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Map<Long, String> findAdvertiseCategoryStatuses() {
        return categoryRepository.findAll()
                .stream().collect(Collectors.toMap(Category::getId,Category::getStatus));
    }

}

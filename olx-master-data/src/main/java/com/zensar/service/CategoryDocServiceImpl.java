package com.zensar.service;

import com.zensar.model.Category;
import com.zensar.model.CategoryDocument;
import com.zensar.repository.CategoryDocRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service("categoryMongoService")
public class CategoryDocServiceImpl implements CategoryService {

    @Autowired
    private CategoryDocRepository categoryDocRepository;

    @Override
    public List<Category> fetchAllAdvertiseCategory() {
        List<Category> categories = new ArrayList<>();
        List<CategoryDocument> documents = categoryDocRepository.findAll();
        log.debug("fetchAllAdvertiseCategory: {}",documents);
        if (documents.isEmpty()) {
            return categories;
        }
        documents.forEach(document -> categories.add(document.buildCategoryModel()));
        return categories;
    }

    @Override
    public Optional<Category> fetchAdvertiseCategory(Long id) {
        Optional<CategoryDocument> documentOpt = categoryDocRepository.findById(id);
        if (documentOpt.isPresent()) {
            Category category = documentOpt.get().buildCategoryModel();
            return Optional.ofNullable(category);
        }
        return Optional.empty();
    }

    @Override
    public Map<Long, String> findAdvertiseCategoryStatuses() {
        return categoryDocRepository
                .findAll().stream()
                .collect(Collectors.toMap(CategoryDocument::getId, CategoryDocument::getStatus));
    }
}

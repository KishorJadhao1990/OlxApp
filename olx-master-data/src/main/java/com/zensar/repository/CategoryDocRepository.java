package com.zensar.repository;

import com.zensar.model.CategoryDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDocRepository extends MongoRepository<CategoryDocument, Long> {
}

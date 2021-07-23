package com.zensar.helper;

import com.zensar.model.Category;
import org.springframework.stereotype.Component;

@Component
public interface CategoryServiceHelper {

    Category fetchCategory(Long categoryId, String authToken);

}

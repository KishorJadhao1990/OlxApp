package com.zensar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "category")
public class CategoryDocument extends BaseModel {
    @Id
    private Long id;
    private String category;
    private String description;
    private String status;

    public Category buildCategoryModel() {
        Category category = new Category();
        category.setId(this.getId());
        category.setStatus(this.getStatus());
        category.setCategory(this.getCategory());
        category.setDescription(this.getDescription());
        category.setCreatedAt(this.getCreatedAt());
        category.setCreatedBy(this.getCreatedBy());
        category.setUpdatedAt(this.getUpdatedAt());
        category.setUpdatedBy(this.getUpdatedBy());
        return category;
    }
}

package com.zensar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category extends BaseModel {

    private Long id;
    private String category;
    private String description;
    private String status;
}

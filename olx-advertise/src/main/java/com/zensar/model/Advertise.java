package com.zensar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Advertise extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "advSeq")
    @SequenceGenerator(name = "advSeq", initialValue = 2000000000, allocationSize = 1)
    private Long id;
    private String title;
    private String price;
    private Long categoryId;
    private String description;
}

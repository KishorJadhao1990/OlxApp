package com.zensar.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roles")
public class Role extends BaseModel {

    @Id
    private Long Id;
    private String roleName;
    private String roleCode;
    private String description;
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    private List<User> users;

}


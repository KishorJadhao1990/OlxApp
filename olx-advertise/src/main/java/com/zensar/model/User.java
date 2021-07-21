package com.zensar.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User extends BaseModel {
    private Long id;
    private String firstname;
    private String lastname;
    private String username;
    @JsonIgnore
    private String password;
    private String email;
    private Long mobileNo;
    private List<Object> roles;
}

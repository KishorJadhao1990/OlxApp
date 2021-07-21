package com.zensar.dto;

import com.zensar.model.Role;
import com.zensar.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDto {
    @NotEmpty(message = "{required.firstname}")
    private String firstname;
    @NotEmpty(message = "{required.lastname}")
    private String lastname;
    @NotEmpty(message = "{required.username}")
    private String username;
    private String password;
    @Email(regexp = "[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$",
            message = "{invalid.email}")
    private String email;
    private Long mobileNo;
    private List<RoleDto> roleDtos;

    public User buildUserModel() {
        List<Role> roles = new ArrayList<>();
        roleDtos.stream().forEach(dto -> roles.add(new Role(null, null, dto.getRoleCode(), null, null)));
        return new User(0L, this.firstname, this.lastname, this.username, this.password, this.email, this.mobileNo, roles);
    }
}

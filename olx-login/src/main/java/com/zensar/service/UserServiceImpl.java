package com.zensar.service;

import com.zensar.exception.BadRequestException;
import com.zensar.model.Role;
import com.zensar.model.User;
import com.zensar.repository.RoleRepository;
import com.zensar.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired()
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    @Transactional(rollbackOn = Exception.class)
    public Optional<User> registerUser(User user) {
        if (isUserAlreadyExists(user)) {
            throw new BadRequestException("error.userAlreadyExists");
        }
        List<String> roleCodes = user.getRoles().stream()
                .map(Role::getRoleCode).collect(Collectors.toList());
        List<Role> dbRoles = roleRepository.findAllByRoleCodes(roleCodes);
        user.setRoles(dbRoles);
        user.setCCUU();
        return Optional.of(userRepository.save(user));
    }

    @Override
    public Optional<User> fetchUser(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> fetchAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> fetchUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Optional<User> fetchUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Optional<User> fetchUserByMobileNo(String mobileNo) {
        return userRepository.findByMobileNo(mobileNo);
    }

    private boolean isUserAlreadyExists(User user) {
        boolean isEmailExists = userRepository.existsByEmail(user.getEmail());
        boolean isUsernameExists = userRepository.existsByUsername(user.getUsername());
        boolean isMobileNoExists = userRepository.existsByMobileNo(user.getMobileNo());
        if (isUsernameExists){
            throw new BadRequestException("error.usernameAlreadyExists");
        }
        if (isEmailExists){
            throw new BadRequestException("error.emailAlreadyExists");
        }
        if (isMobileNoExists){
            throw new BadRequestException("error.mobileNoAlreadyExists");
        }
        return false;
    }
}

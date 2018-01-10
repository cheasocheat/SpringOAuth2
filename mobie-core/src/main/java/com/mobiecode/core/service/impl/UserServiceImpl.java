package com.mobiecode.core.service.impl;

import com.mobiecode.core.repository.RoleRepository;
import com.mobiecode.core.repository.UserRepository;
import com.mobiecode.core.service.UserService;
import com.mobiecode.core.util.BaseUtil;
import com.mobiecode.domain.entity.Role;
import com.mobiecode.domain.entity.User;
import com.mobiecode.domain.util.RecordStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder encoder;


    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        user.setStatus(RecordStatus.PUB);
        user.setCreatedUser("Anomymous");
        user.setUpdatedUser("Anomymous");
        userRepository.save(user);
    }
}

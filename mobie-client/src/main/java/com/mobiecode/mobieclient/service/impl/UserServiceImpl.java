package com.mobiecode.mobieclient.service.impl;

import com.mobiecode.domain.entity.Role;
import com.mobiecode.domain.entity.User;
import com.mobiecode.domain.util.RecordStatus;
import com.mobiecode.mobieclient.repository.RoleRepository;
import com.mobiecode.mobieclient.repository.UserRepository;
import com.mobiecode.mobieclient.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUser(User user) {
        user.setUserPassword(bCryptPasswordEncoder.encode(user.getUserPassword()));
        user.setStatus(RecordStatus.PUB);
        user.setCreatedUser("Anomymous");
        user.setUpdatedUser("Anomymous");
        Role role = roleRepository.findByRoleDesc("ADMIN");
        user.setRoles(new HashSet<>(Arrays.asList(role)));
        userRepository.save(user);
    }
}

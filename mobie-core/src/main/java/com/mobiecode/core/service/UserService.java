package com.mobiecode.core.service;

import com.mobiecode.domain.entity.User;

public interface UserService {
    User findByUsername(String username);
    User findUserByEmail(String email);
    void saveUser(User user);
}

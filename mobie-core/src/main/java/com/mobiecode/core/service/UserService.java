package com.mobiecode.core.service;

import com.mobiecode.domain.entity.User;

public interface UserService {
    User findUserByEmail(String email);
    void saveUser(User user);
}

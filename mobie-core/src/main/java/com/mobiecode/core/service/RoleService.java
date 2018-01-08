package com.mobiecode.core.service;

import com.mobiecode.domain.entity.Role;

import java.util.List;

public interface RoleService {
    void saveRole(Role role);
    List<Role> getListRoles();
}

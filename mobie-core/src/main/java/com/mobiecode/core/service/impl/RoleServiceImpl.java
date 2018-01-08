package com.mobiecode.core.service.impl;

import com.mobiecode.domain.entity.Role;
import com.mobiecode.domain.util.RecordStatus;
import com.mobiecode.core.repository.RoleRepository;
import com.mobiecode.core.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository repository;

    @Override
    public void saveRole(Role role) {
        role.setStatus(RecordStatus.PUB);
        role.setCreatedUser("Anomymous");
        role.setUpdatedUser("Anomymous");
        repository.save(role);
    }

    @Override
    public List<Role> getListRoles() {
        return repository.findAll();
    }
}

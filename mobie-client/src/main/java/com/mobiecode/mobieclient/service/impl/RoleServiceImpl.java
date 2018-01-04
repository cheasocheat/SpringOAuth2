package com.mobiecode.mobieclient.service.impl;

import com.mobiecode.domain.entity.Role;
import com.mobiecode.domain.util.RecordStatus;
import com.mobiecode.mobieclient.repository.RoleRepository;
import com.mobiecode.mobieclient.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}

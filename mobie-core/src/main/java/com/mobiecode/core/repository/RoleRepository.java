package com.mobiecode.core.repository;

import com.mobiecode.domain.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
    Role findByRoleDesc(String roleDesc);
}

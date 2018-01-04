package com.mobiecode.core.repository;

import com.mobiecode.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * findByEmail
     * @param email
     * @return
     */
    User findByEmail(String email);

    /**
     * findByUsername
     * @param username
     * @return
     */
    User findByUsername(String username);
}

package com.cse682.nursingresourceledgerprototype.repository;

import com.cse682.nursingresourceledgerprototype.entity.Role;
import com.cse682.nursingresourceledgerprototype.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * RoleRepository class. JpaRepository implements the CRUD repository APIs.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByRoleName(Roles role);
}

package com.cse682.nursingresourceledgerprototype.repository;

import com.cse682.nursingresourceledgerprototype.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * This interface is a subtype of JpaRepository which defines common persistence operations (including CRUD)
 * and the implementation will be generated at runtime by Spring Data JPA.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    public User findByEmail(String email);
}

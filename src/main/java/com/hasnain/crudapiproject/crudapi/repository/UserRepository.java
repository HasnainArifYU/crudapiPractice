package com.hasnain.crudapiproject.crudapi.repository;

import com.hasnain.crudapiproject.crudapi.model.User;

// Import Spring Data JPA tools
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * By extending JpaRepository<User, Long>, we get the following methods for free:
     *
     * - save(User user)        → Insert or update a user
     * - findAll()              → Get a list of all users
     * - findById(Long id)      → Get a user by ID
     * - deleteById(Long id)    → Delete a user by ID
     *
     * You can also define custom queries later if needed, like:
     * - User findByEmail(String email);
     */
}

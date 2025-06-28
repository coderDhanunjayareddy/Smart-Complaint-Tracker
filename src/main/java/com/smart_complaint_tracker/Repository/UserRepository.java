package com.smart_complaint_tracker.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.smart_complaint_tracker.Entity.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}


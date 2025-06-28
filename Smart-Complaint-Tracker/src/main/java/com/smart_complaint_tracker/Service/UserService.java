package com.smart_complaint_tracker.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.smart_complaint_tracker.Entity.User;
import com.smart_complaint_tracker.Repository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}


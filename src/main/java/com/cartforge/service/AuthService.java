package com.cartforge.service;
import com.cartforge.dto.LoginRequest;
import com.cartforge.util.JwtUtil;
import com.cartforge.dto.RegisterRequest;
import com.cartforge.model.User;
import com.cartforge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public String register(RegisterRequest request) {

        if (request.getName() == null || request.getName().isBlank()) {
            throw new RuntimeException("Name required");
        }

        if (request.getEmail() == null || request.getEmail().isBlank()) {
            throw new RuntimeException("Email required");
        }

        if (request.getPassword() == null || request.getPassword().length() < 6) {
            throw new RuntimeException("Password too short");
        }

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        // ROLE HANDLING
        if (request.getRole() != null && request.getRole().equalsIgnoreCase("ADMIN")) {
            user.setRole("ADMIN");
        } else {
            user.setRole("USER");
        }

        userRepository.save(user);

        return "User registered successfully";
    }


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    public String login(LoginRequest request) {

        if (request.getEmail() == null || request.getEmail().isBlank()) {
            throw new RuntimeException("Email required");
        }

        if (request.getPassword() == null || request.getPassword().isBlank()) {
            throw new RuntimeException("Password required");
        }

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return jwtUtil.generateToken(user.getEmail(), user.getRole());
    }
}
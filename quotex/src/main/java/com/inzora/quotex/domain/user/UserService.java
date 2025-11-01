package com.inzora.quotex.domain.user;

import com.inzora.quotex.application.dtos.requests.RegisterRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean emailExist(String email){
        return userRepository.existsByEmail(email);
    }

    public boolean usernameExist(String username){
        return userRepository.existsByUsername(username);
    }

    public User registerUser(RegisterRequestDTO data){
        if (emailExist(data.email().trim()) || usernameExist(data.email().trim())){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email or username already exist");
        }
        String hash = passwordEncoder.encode(data.password().trim());

        User user = new User(data, hash);

        return userRepository.save(user);
    }
}

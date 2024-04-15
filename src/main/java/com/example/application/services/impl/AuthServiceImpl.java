package com.example.application.services.impl;

import com.example.application.data.Role;
import com.example.application.data.User;
import com.example.application.data.UserRepository;
import com.example.application.services.AuthService;
import com.vaadin.flow.component.textfield.TextField;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class AuthServiceImpl implements AuthService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public AuthServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public void register(TextField textField, TextField textField2, TextField textField3) {
        User user = new User();
        user.setRoles(Collections.singleton(Role.USER));
        user.setUsername(textField.getValue());
        user.setName(textField.getValue());
        user.setHashedPassword(passwordEncoder.encode(textField2.getValue()));
        userRepository.save(user);
    }
}

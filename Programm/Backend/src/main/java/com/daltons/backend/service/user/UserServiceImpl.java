/*
 * Copyright (C) Schweizerische Bundesbahn SBB, 2020
 * Header: ProjektServiceImpl ist zuständig um Daten dem Repository weiterzuleiten.
 * Bis jetzt haben wir die Standart Methoden im Service so wie Save, findall, deleteById, findById, und delete.
 * @Author E517589 Lian Josko Vinkovic & E517403 Livio Alexander Liechti
 */
package com.daltons.backend.service.user;

import com.daltons.backend.model.User;
import com.daltons.backend.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User save(User object) {
        object.setPassword(this.passwordEncoder.encode(object.getPassword()));
        return userRepository.save(object);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void delete(User object) {
        userRepository.delete(object);
    }
}

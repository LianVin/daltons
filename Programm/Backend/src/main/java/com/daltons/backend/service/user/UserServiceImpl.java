/*
 * Copyright (C) Schweizerische Bundesbahn SBB, 2020
 * Header: ProjektServiceImpl ist zuständig um Daten dem Repository weiterzuleiten.
 * Bis jetzt haben wir die Standart Methoden im Service so wie Save, findall, deleteById, findById, und delete.
 * @Author E517589 Lian Josko Vinkovic & E517403 Livio Alexander Liechti
 */
package com.daltons.backend.service.user;

import com.daltons.backend.model.User;
import com.daltons.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User object) {
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
    public void delete(User object) {
        userRepository.delete(object);
    }
}

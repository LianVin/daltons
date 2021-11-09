package com.daltons.backend.service.user;

import com.daltons.backend.model.User;
import com.daltons.backend.service.CrudService;

import java.util.List;

public interface UserService extends CrudService<User, Integer> {
    User save(User object);
    List<User> findAll();
    void deleteById(Integer id);
    User findById(Integer id);
    void delete(User object);
}

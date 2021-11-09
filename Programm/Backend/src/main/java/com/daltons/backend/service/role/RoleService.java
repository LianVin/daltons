package com.daltons.backend.service.role;

import com.daltons.backend.model.Role;
import com.daltons.backend.model.User;
import com.daltons.backend.service.CrudService;

import java.util.List;

public interface RoleService extends CrudService<Role, Integer> {
    Role save(Role object);
    List<Role> findAll();
    void deleteById(Integer id);
    Role findById(Integer id);
    void delete(Role object);
}

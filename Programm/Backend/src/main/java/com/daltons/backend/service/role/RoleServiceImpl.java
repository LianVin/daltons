/*
 * Copyright (C) Schweizerische Bundesbahn SBB, 2020
 * Header: ProjektServiceImpl ist zuständig um Daten dem Repository weiterzuleiten.
 * Bis jetzt haben wir die Standart Methoden im Service so wie Save, findall, deleteById, findById, und delete.
 * @Author E517589 Lian Josko Vinkovic & E517403 Livio Alexander Liechti
 */
package com.daltons.backend.service.role;

import com.daltons.backend.model.Role;
import com.daltons.backend.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role save(Role object) {
        return roleRepository.save(object);
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        roleRepository.deleteById(id);
    }

    @Override
    public Role findById(Integer id) {
        return roleRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Role object) {
        roleRepository.delete(object);
    }
}

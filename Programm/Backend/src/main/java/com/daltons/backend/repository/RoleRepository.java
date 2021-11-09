package com.daltons.backend.repository;

import com.daltons.backend.model.Role;
import com.daltons.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}

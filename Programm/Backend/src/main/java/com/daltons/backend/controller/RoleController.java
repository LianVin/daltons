package com.daltons.backend.controller;

import com.daltons.backend.model.Role;
import com.daltons.backend.service.role.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping(value = "/role")
public class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public ResponseEntity<Role> createRole(@Validated @RequestBody Role role) {
        if(roleService.findById(role.getRoleId()) != null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }else {
            Role newRole = roleService.save(role);
            if (newRole == null){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(newRole, HttpStatus.CREATED);
        }
    }

    @GetMapping
    public ResponseEntity<List<Role>> getAllRole() {
        List<Role> roleList = roleService.findAll();
        return new ResponseEntity<>(roleList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable Integer id) {
        Role role = roleService.findById(id);
        if (role == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(role, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRole(@PathVariable Integer id) {
        Role role = roleService.findById(id);

        if (role == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        roleService.delete(role);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Role> updateRole(@RequestBody Role role, @PathVariable Integer id) {
        Role updatedRole = roleService.findById(id);
            if (role.getRole() != null) {
                updatedRole.setRole(role.getRole());
            }
            return new ResponseEntity<>(roleService.save(updatedRole), HttpStatus.OK);
    }
}

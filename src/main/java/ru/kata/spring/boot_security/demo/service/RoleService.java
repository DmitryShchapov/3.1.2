package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.entity.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {
    List<Role> getAllRoles ();
    void saveRole(Role role);
    Role getRole(long id);
    Set<Role> getRoles(List<Long>roles);
}

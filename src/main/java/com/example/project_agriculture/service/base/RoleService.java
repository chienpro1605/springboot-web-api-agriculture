package com.example.project_agriculture.service.base;

import com.example.project_agriculture.constant.RoleName;
import com.example.project_agriculture.entity.Role;

import java.util.Optional;

public interface RoleService {
    Optional<Role> findByName(RoleName name);
}

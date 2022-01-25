package com.example.project_agriculture.service.impl;

import com.example.project_agriculture.constant.RoleName;
import com.example.project_agriculture.entity.Role;
import com.example.project_agriculture.repository.RoleRepository;
import com.example.project_agriculture.service.base.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;
    @Override
    public Optional<Role> findByName(RoleName name) {
        return roleRepository.findByName(name);
    }
}

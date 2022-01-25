package com.example.project_agriculture.repository;

import com.example.project_agriculture.constant.RoleName;
import com.example.project_agriculture.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
    Optional<Role> findByName(RoleName name);
}

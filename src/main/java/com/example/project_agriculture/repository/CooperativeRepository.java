package com.example.project_agriculture.repository;

import com.example.project_agriculture.entity.Cooperative;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CooperativeRepository extends JpaRepository<Cooperative, String> {
    Page<Cooperative> findAll(Pageable pageable);
}

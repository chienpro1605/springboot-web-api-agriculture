package com.example.project_agriculture.repository;

import com.example.project_agriculture.entity.Pesticide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PesticideRepository extends JpaRepository<Pesticide, String> {
}

package com.example.project_agriculture.repository;

import com.example.project_agriculture.entity.TreeType;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreeTypeRepository extends JpaRepository<TreeType, String> {
}

package com.example.project_agriculture.repository;

import com.example.project_agriculture.entity.Crop;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CropRepository extends JpaRepository<Crop, String> {

    @Query(value = "select * from crop c left join tree_type tt on tt.tree_typeid = c.tree_typeid where c.name like :name and c.cultivar_name like :cultivarName and tt.name like :treeType", nativeQuery = true)
    Iterable<Crop> searchCrop(String name, String treeType, String cultivarName);

    Page<Crop> findAll(Pageable pageable);
}

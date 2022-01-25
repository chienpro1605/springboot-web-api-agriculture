package com.example.project_agriculture.service.base;

import com.example.project_agriculture.dto.crop.CropDTO;
import com.example.project_agriculture.entity.Crop;
import com.example.project_agriculture.service.CommonService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CropService extends CommonService<Crop> {
    Crop addCrop(CropDTO cropDTO);
    Iterable<Crop> searchCrop(String name, String treeType, String cultivarName);
    Page<Crop> findAll(Pageable pageable);
}

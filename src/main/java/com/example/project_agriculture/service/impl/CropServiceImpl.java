package com.example.project_agriculture.service.impl;

import com.example.project_agriculture.dto.crop.CropDTO;
import com.example.project_agriculture.entity.Cooperative;
import com.example.project_agriculture.entity.Crop;
import com.example.project_agriculture.entity.Users;
import com.example.project_agriculture.exception.ApplicationException;
import com.example.project_agriculture.repository.CooperativeRepository;
import com.example.project_agriculture.repository.CropRepository;
import com.example.project_agriculture.service.CommonService;
import com.example.project_agriculture.service.CommonServiceImpl;
import com.example.project_agriculture.service.base.CooperativeService;
import com.example.project_agriculture.service.base.CropService;
import com.example.project_agriculture.service.base.TreeTypeService;
import com.example.project_agriculture.service.base.UserService;
import com.example.project_agriculture.util.ModelMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CropServiceImpl extends CommonServiceImpl<Crop, CropRepository> implements CropService {

    @Autowired
    private CropService cropService;

    @Autowired
    private TreeTypeService treeTypeService;

    @Autowired
    private CooperativeService cooperativeService;

    @Autowired
    private UserService userService;

    @Override
    @Transactional(rollbackFor = ApplicationException.class)
    public Crop addCrop(CropDTO cropDTO) {
        Crop crop = ModelMapperUtils.mapperDTOToEntity(cropDTO, Crop.class);
        crop.setTreeType(treeTypeService.findEntityById(cropDTO.getTreeTypeId()));
        crop.setCooperative(cooperativeService.findEntityById(cropDTO.getCooperativeId()));
        Crop cropInserted = cropService.addEntity(crop);

//        Users users = ModelMapperUtils.mapperDTOToEntity(cropDTO, Users.class);
//        users.setCrop(cropInserted);
//        Users userInserted = userService.addEntity(users);
//
//        List<Users> userSet = new ArrayList<>();
//        userSet.add(userInserted);
//        crop.setUsers(userSet);
        return crop;
    }

    @Override
    public Iterable<Crop> searchCrop(String name, String treeType, String cultivarName) {
        return repository.searchCrop(name, treeType, cultivarName);
    }

    @Override
    public Page<Crop> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
}

package com.example.project_agriculture.service.impl;

import com.example.project_agriculture.dto.pesticide.PesticideDTO;
import com.example.project_agriculture.entity.Activity;
import com.example.project_agriculture.entity.Pesticide;
import com.example.project_agriculture.exception.ApplicationException;
import com.example.project_agriculture.repository.ActivityRepository;
import com.example.project_agriculture.repository.PesticideRepository;
import com.example.project_agriculture.service.CommonServiceImpl;
import com.example.project_agriculture.service.base.ActivityService;
import com.example.project_agriculture.service.base.PesticideService;
import com.example.project_agriculture.util.ModelMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PesticideServiceImpl extends CommonServiceImpl<Pesticide, PesticideRepository> implements PesticideService {

    @Autowired
    private PesticideService pesticideService;

    @Autowired
    private ActivityService activityService;

    @Override
    @Transactional(rollbackFor = ApplicationException.class)
    public Pesticide addPesticide(PesticideDTO pesticideDTO) {
        Pesticide pesticide = ModelMapperUtils.mapperDTOToEntity(pesticideDTO, Pesticide.class);
        pesticide.setActivity(activityService.findEntityById(pesticideDTO.getActivityId()));
        Pesticide pesticideInserted = pesticideService.addEntity(pesticide);
        return pesticide;
    }
}

package com.example.project_agriculture.service.base;

import com.example.project_agriculture.dto.pesticide.PesticideDTO;
import com.example.project_agriculture.entity.Pesticide;
import com.example.project_agriculture.service.CommonService;

public interface PesticideService extends CommonService<Pesticide> {
    Pesticide addPesticide(PesticideDTO pesticideDTO);
}

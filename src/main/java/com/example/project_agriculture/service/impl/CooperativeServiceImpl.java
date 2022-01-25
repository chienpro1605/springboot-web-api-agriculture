package com.example.project_agriculture.service.impl;

import com.example.project_agriculture.entity.Cooperative;
import com.example.project_agriculture.repository.CooperativeRepository;
import com.example.project_agriculture.service.CommonServiceImpl;
import com.example.project_agriculture.service.base.CooperativeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CooperativeServiceImpl extends CommonServiceImpl<Cooperative, CooperativeRepository> implements CooperativeService {
    @Override
    public Page<Cooperative> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
}

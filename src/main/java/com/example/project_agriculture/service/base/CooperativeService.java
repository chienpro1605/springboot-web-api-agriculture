package com.example.project_agriculture.service.base;

import com.example.project_agriculture.entity.Cooperative;
import com.example.project_agriculture.service.CommonService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CooperativeService extends CommonService<Cooperative> {
    Page<Cooperative> findAll(Pageable pageable);
}

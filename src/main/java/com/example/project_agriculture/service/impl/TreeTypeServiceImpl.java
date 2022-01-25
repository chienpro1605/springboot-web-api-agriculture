package com.example.project_agriculture.service.impl;

import com.example.project_agriculture.entity.Activity;
import com.example.project_agriculture.entity.TreeType;
import com.example.project_agriculture.repository.ActivityRepository;
import com.example.project_agriculture.repository.TreeTypeRepository;
import com.example.project_agriculture.service.CommonServiceImpl;
import com.example.project_agriculture.service.base.ActivityService;
import com.example.project_agriculture.service.base.TreeTypeService;
import org.springframework.stereotype.Service;

@Service
public class TreeTypeServiceImpl extends CommonServiceImpl<TreeType, TreeTypeRepository> implements TreeTypeService {
}

package com.example.project_agriculture.service.impl;

import com.example.project_agriculture.constant.ErrorCode;
import com.example.project_agriculture.dto.activity.ActivityDTO;
import com.example.project_agriculture.entity.Activity;
import com.example.project_agriculture.entity.Cooperative;
import com.example.project_agriculture.exception.ApplicationException;
import com.example.project_agriculture.repository.*;
import com.example.project_agriculture.service.CommonService;
import com.example.project_agriculture.service.CommonServiceImpl;
import com.example.project_agriculture.service.base.*;
import com.example.project_agriculture.util.ModelMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Service
public class ActivityServiceImpl extends CommonServiceImpl<Activity, ActivityRepository> implements ActivityService {

    @Autowired
    private ActivityService activityService;

    @Autowired
    private CropService cropService;

    @Autowired
    private UserService userService;

    @Autowired
    private PesticideService pesticideService;



    @Override
    public Iterable<Activity> viewActivitiesOfCrop(String cropId) {
        return repository.viewActivitiesOfCrop(cropId);
    }

    @Override
    public Activity addActivity(ActivityDTO activityDTO) {
        Activity activity = ModelMapperUtils.mapperDTOToEntity(activityDTO, Activity.class);
        activity.setCrop(cropService.findEntityById(activityDTO.getCropId()));
        activity.setUsers(userService.findEntityById(activityDTO.getUserId()));
        activity.setPesticide(pesticideService.findEntityById(activityDTO.getPesticideId()));
        Activity activityInserted = activityService.addEntity(activity);
        return activity;
    }

    @Override
    public Activity updateWorkingDayOfActivity(String id, Date workingDay) throws ParseException {
        Activity activity = activityService.findEntityById(id);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date startDate = simpleDateFormat.parse(String.valueOf(activity.getWorking_day()));
        Date endDate = simpleDateFormat.parse(String.valueOf(workingDay));
        long startValue = startDate.getTime();
        long endValue = endDate.getTime();
        long tmp =  Math.abs(endValue - startValue);
        long result = tmp/(24*60*60*1000);
        if (result <= 3) {
            activity.setWorking_day(workingDay);
        } else {
            throw new ApplicationException(ErrorCode.WRONG_FORMAT_INPUT.getValue());
        }
        return activityService.updateEntity(activity);
    }
}

package com.example.project_agriculture.service.base;

import com.example.project_agriculture.dto.activity.ActivityDTO;
import com.example.project_agriculture.entity.Activity;
import com.example.project_agriculture.service.CommonService;

import java.text.ParseException;
import java.util.Date;
import java.util.Optional;

public interface ActivityService extends CommonService<Activity> {
    Iterable<Activity> viewActivitiesOfCrop(String cropId);
    Activity addActivity(ActivityDTO activityDTO);
    Activity updateWorkingDayOfActivity(String id, Date workingDay) throws ParseException;
}

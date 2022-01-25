package com.example.project_agriculture.api.activity;

import com.example.project_agriculture.entity.Activity;
import com.example.project_agriculture.service.base.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/activity")
@RestController
@CrossOrigin(origins = "*")
public class ActivitiesOfCrop {

    @Autowired
    private ActivityService activityService;

    @GetMapping("/{cropId}")
    public ResponseEntity<Iterable<Activity>> getAllActiviesOfCrop(@PathVariable String cropId) {
        Iterable<Activity> activities = activityService.viewActivitiesOfCrop(cropId);
        return new ResponseEntity<>(activities, HttpStatus.OK);
    }
}

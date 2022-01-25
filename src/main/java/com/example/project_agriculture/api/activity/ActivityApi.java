package com.example.project_agriculture.api.activity;

import com.example.project_agriculture.entity.Activity;
import com.example.project_agriculture.entity.Cooperative;
import com.example.project_agriculture.service.base.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/activities")
@RestController
@CrossOrigin(origins = "*")
public class ActivityApi {

    @Autowired
    ActivityService activityService;

    @GetMapping()
    public ResponseEntity<Iterable<Activity>> getAllActivity() {
        return new ResponseEntity<>(activityService.getEntities(), HttpStatus.OK);
    }
}

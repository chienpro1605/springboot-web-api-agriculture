package com.example.project_agriculture.api.activity;

import com.example.project_agriculture.entity.Activity;
import com.example.project_agriculture.service.base.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/api/activities")
@RestController
@CrossOrigin(origins = "*")
public class GetActivityIdApi {

    @Autowired
    private ActivityService activityService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Activity>> getActivityById (@PathVariable String id) {
        Optional<Activity> activityOptional = Optional.ofNullable(activityService.findEntityById(id));
        return new ResponseEntity<>(activityOptional, HttpStatus.OK);
    }
}

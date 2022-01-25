package com.example.project_agriculture.api.activity;


import com.example.project_agriculture.api.AbstractApi;
import com.example.project_agriculture.constant.ErrorCode;
import com.example.project_agriculture.dto.activity.ActivityDTO;
import com.example.project_agriculture.entity.Activity;
import com.example.project_agriculture.exception.ApplicationException;
import com.example.project_agriculture.request.activity.AddActivityRequest;
import com.example.project_agriculture.request.crop.AddCropRequest;
import com.example.project_agriculture.response.ResponseData;
import com.example.project_agriculture.response.activity.AddActivityResponse;
import com.example.project_agriculture.service.base.ActivityService;
import com.example.project_agriculture.util.ModelMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@RestController
public class AddActivityApi extends AbstractApi<AddActivityRequest, AddActivityResponse> {

    @Autowired
    private ActivityService activityService;

    @Override
    protected void validateRequest(AddActivityRequest request) {
        if (!request.validateRequest()) {
            throw new ApplicationException(ErrorCode.WRONG_FORMAT_INPUT.getValue());
        }
    }

    @PostMapping("/api/addActivity")
    public ResponseData addActivity(@RequestBody AddActivityRequest request) {
        return handle(request);
    }

    @Override
    protected AddActivityResponse execute(AddActivityRequest request) {
        request.setCreated_time(Timestamp.valueOf(LocalDateTime.now()));
        ActivityDTO activityDTO = ModelMapperUtils.mapperRequestToDTO(request, ActivityDTO.class);
        Activity activity = activityService.addActivity(activityDTO);
        AddActivityResponse response = ModelMapperUtils.mapperEntityToResponse(activity, AddActivityResponse.class);
        return response;
    }
}

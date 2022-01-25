package com.example.project_agriculture.api.activity;

import com.example.project_agriculture.api.AbstractApi;
import com.example.project_agriculture.constant.ErrorCode;
import com.example.project_agriculture.entity.Activity;
import com.example.project_agriculture.exception.ApplicationException;
import com.example.project_agriculture.request.activity.UpdateWorkingDayRequest;
import com.example.project_agriculture.request.pesticide.UpdatePesticideRequest;
import com.example.project_agriculture.response.ResponseData;
import com.example.project_agriculture.response.activity.AddActivityResponse;
import com.example.project_agriculture.service.base.ActivityService;
import com.example.project_agriculture.util.DateTimeUtils;
import com.example.project_agriculture.util.ModelMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.security.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.AbstractQueue;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@RestController
public class UpdateWorkingDayOfActivity extends AbstractApi<UpdateWorkingDayRequest, AddActivityResponse> {

    @Autowired
    private ActivityService activityService;

    @Override
    protected void validateRequest(UpdateWorkingDayRequest request) {
        if (!request.validateRequest()) {
            throw new ApplicationException(ErrorCode.WRONG_FORMAT_INPUT.getValue());
        }
    }

    @PutMapping("/api/updateWorkingDay")
    public ResponseData updateWorkingDayActivity(@RequestBody UpdateWorkingDayRequest request) {
        return handle(request);
    }

    @Override
    protected AddActivityResponse execute(UpdateWorkingDayRequest request) {
        AddActivityResponse response = new AddActivityResponse();
        try {
            Activity activity = ModelMapperUtils.mapperRequestToEntity(request, Activity.class);
            Activity activityId = activityService.findEntityById(request.getActivityId());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy");
            Date startDate = simpleDateFormat.parse(activityId.getWorking_day().toString());
            Date endDate = simpleDateFormat1.parse(request.getWorking_day().toString());
            long startValue = startDate.getTime ();
            long endValue = endDate.getTime();

            long tmp =  Math.abs(endValue - startValue);
            long result = tmp/(24*60*60*1000);
            if (result <= 3) {
                activityId.setWorking_day(request.getWorking_day());
            } else {
                throw new ApplicationException(ErrorCode.WRONG_FORMAT_INPUT.getValue());
            }
            Activity activityRequest = activityService.updateEntity(activityId);
            response = ModelMapperUtils.mapperEntityToResponse(activityRequest, AddActivityResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

//    @PutMapping("/activity")
//    public ResponseEntity<Activity> updateActivityWorkingDay(@RequestParam String id, @RequestParam Date working_day) throws ParseException {
//        Activity activity1 = activityService.updateWorkingDayOfActivity(id, working_day);
//        return new ResponseEntity<>(activity1, HttpStatus.OK);
//    }
}

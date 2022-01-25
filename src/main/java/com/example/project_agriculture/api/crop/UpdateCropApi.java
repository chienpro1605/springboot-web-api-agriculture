package com.example.project_agriculture.api.crop;

import com.example.project_agriculture.api.AbstractApi;
import com.example.project_agriculture.constant.ErrorCode;
import com.example.project_agriculture.entity.Crop;
import com.example.project_agriculture.exception.ApplicationException;
import com.example.project_agriculture.request.cooperative.UpdateCooperativeRequest;
import com.example.project_agriculture.request.crop.UpdateCropRequest;
import com.example.project_agriculture.response.ResponseData;
import com.example.project_agriculture.response.crop.UpdateCropResponse;
import com.example.project_agriculture.service.base.CropService;
import com.example.project_agriculture.util.ModelMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@RestController
public class UpdateCropApi extends AbstractApi<UpdateCropRequest, UpdateCropResponse> {

    @Autowired
    private CropService cropService;

    @Override
    protected void validateRequest(UpdateCropRequest request) {
        if (!request.validateRequest()) {
            throw new ApplicationException(ErrorCode.WRONG_FORMAT_INPUT.getValue());
        }
    }

    @PutMapping("/api/updateCrop")
    public ResponseData updateCrop(@RequestBody UpdateCropRequest request) {
        return handle(request);
    }

    @Override
    protected UpdateCropResponse execute(UpdateCropRequest request) {
        request.setCreated_time(Timestamp.valueOf(LocalDateTime.now()));
        Crop crop = ModelMapperUtils.mapperRequestToEntity(request, Crop.class);
        Crop cropId = cropService.findEntityById(request.getId());
        crop.setCropId(cropId.getCropId());
        Crop cropRequest = cropService.updateEntity(crop);
        UpdateCropResponse response = ModelMapperUtils.mapperEntityToResponse(cropRequest, UpdateCropResponse.class);
        return response;
    }
}

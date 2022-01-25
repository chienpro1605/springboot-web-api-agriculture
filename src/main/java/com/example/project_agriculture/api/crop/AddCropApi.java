package com.example.project_agriculture.api.crop;

import com.example.project_agriculture.api.AbstractApi;
import com.example.project_agriculture.constant.ErrorCode;
import com.example.project_agriculture.dto.crop.CropDTO;
import com.example.project_agriculture.entity.Cooperative;
import com.example.project_agriculture.entity.Crop;
import com.example.project_agriculture.exception.ApplicationException;
import com.example.project_agriculture.request.cooperative.AddCooperativeRequest;
import com.example.project_agriculture.request.crop.AddCropRequest;
import com.example.project_agriculture.response.ResponseData;
import com.example.project_agriculture.response.cooperative.AddCooperativeResponse;
import com.example.project_agriculture.response.crop.AddCropResponse;
import com.example.project_agriculture.service.base.CropService;
import com.example.project_agriculture.util.ModelMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@RestController
public class AddCropApi extends AbstractApi<AddCropRequest, AddCropResponse> {

    @Autowired
    private CropService cropService;

    @Override
    protected void validateRequest(AddCropRequest request) {
        if (!request.validateRequest()) {
            throw new ApplicationException(ErrorCode.WRONG_FORMAT_INPUT.getValue());
        }
    }

    @PostMapping("/api/addCrop")
    public ResponseData addCrop(@RequestBody AddCropRequest request) {
        return handle(request);
    }

    @Override
    protected AddCropResponse execute(AddCropRequest request) {
        request.setCreated_time(Timestamp.valueOf(LocalDateTime.now()));
        CropDTO cropDTO = ModelMapperUtils.mapperRequestToDTO(request, CropDTO.class);
        Crop crop = cropService.addCrop(cropDTO);
        AddCropResponse response = ModelMapperUtils.mapperEntityToResponse(crop, AddCropResponse.class);
        return response;
    }

//    @Override
//    protected AddCropResponse execute(AddCropRequest request) {
//        request.setCreated_time(Timestamp.valueOf(LocalDateTime.now()));
//        Crop requestCrop =  ModelMapperUtils.mapperRequestToEntity(request, Crop.class);
//        Crop crop = cropService.addEntity(requestCrop);
//        AddCropResponse response = ModelMapperUtils.mapperEntityToResponse(crop, AddCropResponse.class);
//        return response;
//    }
}

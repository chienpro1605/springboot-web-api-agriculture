package com.example.project_agriculture.api.pesticide;

import com.example.project_agriculture.api.AbstractApi;
import com.example.project_agriculture.constant.ErrorCode;
import com.example.project_agriculture.entity.Crop;
import com.example.project_agriculture.entity.Pesticide;
import com.example.project_agriculture.exception.ApplicationException;
import com.example.project_agriculture.request.crop.UpdateCropRequest;
import com.example.project_agriculture.request.pesticide.UpdatePesticideRequest;
import com.example.project_agriculture.response.ResponseData;
import com.example.project_agriculture.response.crop.UpdateCropResponse;
import com.example.project_agriculture.response.pesticide.UpdatePesticideResponse;
import com.example.project_agriculture.service.base.PesticideService;
import com.example.project_agriculture.util.ModelMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdatePesticideApi extends AbstractApi<UpdatePesticideRequest, UpdatePesticideResponse> {

    @Autowired
    private PesticideService pesticideService;
    @Override
    protected void validateRequest(UpdatePesticideRequest request) {
        if (!request.validateRequest()) {
            throw new ApplicationException(ErrorCode.WRONG_FORMAT_INPUT.getValue());
        }
    }

    @PutMapping("/api/updatePesticide")
    public ResponseData updatePesticide (@RequestBody UpdatePesticideRequest request) {
        return handle(request);
    }

    @Override
    protected UpdatePesticideResponse execute(UpdatePesticideRequest request) {
        Pesticide pesticide = ModelMapperUtils.mapperRequestToEntity(request, Pesticide.class);
        Pesticide pesticideId = pesticideService.findEntityById(request.getPesticideId());
        pesticide.setPesticideId(pesticideId.getPesticideId());
        Pesticide pesticideRequest = pesticideService.updateEntity(pesticide);
        UpdatePesticideResponse response = ModelMapperUtils.mapperEntityToResponse(pesticideRequest, UpdatePesticideResponse.class);
        return response;
    }
}

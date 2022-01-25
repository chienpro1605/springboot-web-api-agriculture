package com.example.project_agriculture.api.pesticide;

import com.example.project_agriculture.api.AbstractApi;
import com.example.project_agriculture.constant.ErrorCode;
import com.example.project_agriculture.dto.crop.CropDTO;
import com.example.project_agriculture.dto.pesticide.PesticideDTO;
import com.example.project_agriculture.entity.Crop;
import com.example.project_agriculture.entity.Pesticide;
import com.example.project_agriculture.exception.ApplicationException;
import com.example.project_agriculture.request.crop.AddCropRequest;
import com.example.project_agriculture.request.pesticide.AddPesticideRequest;
import com.example.project_agriculture.response.ResponseData;
import com.example.project_agriculture.response.crop.AddCropResponse;
import com.example.project_agriculture.response.pesticide.AddPesticideResponse;
import com.example.project_agriculture.service.base.PesticideService;
import com.example.project_agriculture.util.ModelMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@RestController
public class AddPesticideApi extends AbstractApi<AddPesticideRequest, AddPesticideResponse> {

    @Autowired
    private PesticideService pesticideService;

    @Override
    protected void validateRequest(AddPesticideRequest request) {
        if (!request.validateRequest()) {
            throw new ApplicationException(ErrorCode.WRONG_FORMAT_INPUT.getValue());
        }
    }

    @PostMapping("/api/addPesticide")
    public ResponseData addPesticide(@RequestBody AddPesticideRequest request) {
        return handle(request);
    }

    @Override
    protected AddPesticideResponse execute(AddPesticideRequest request) {
        PesticideDTO pesticideDTO = ModelMapperUtils.mapperRequestToDTO(request, PesticideDTO.class);
        Pesticide pesticide = pesticideService.addPesticide(pesticideDTO);
        AddPesticideResponse response = ModelMapperUtils.mapperEntityToResponse(pesticide, AddPesticideResponse.class);
        return response;
    }


//    @PostMapping("/api/pesticides/add")
//    public ResponseEntity<Pesticide> createCrop(@RequestBody Pesticide pesticide) {
//        return new ResponseEntity<>(pesticideService.addEntity(pesticide), HttpStatus.CREATED);
//    }

}

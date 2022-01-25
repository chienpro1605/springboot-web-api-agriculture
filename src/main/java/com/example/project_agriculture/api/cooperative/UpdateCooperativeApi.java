package com.example.project_agriculture.api.cooperative;

import com.example.project_agriculture.api.AbstractApi;
import com.example.project_agriculture.constant.ErrorCode;
import com.example.project_agriculture.entity.Cooperative;
import com.example.project_agriculture.exception.ApplicationException;
import com.example.project_agriculture.request.cooperative.AddCooperativeRequest;
import com.example.project_agriculture.request.cooperative.UpdateCooperativeRequest;
import com.example.project_agriculture.response.ResponseData;
import com.example.project_agriculture.response.cooperative.AddCooperativeResponse;
import com.example.project_agriculture.response.cooperative.UpdateCooperativeResponse;
import com.example.project_agriculture.service.base.CooperativeService;
import com.example.project_agriculture.util.ModelMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@RestController
public class UpdateCooperativeApi extends AbstractApi<UpdateCooperativeRequest, UpdateCooperativeResponse> {

    @Autowired
    private CooperativeService cooperativeService;

    @Override
    protected void validateRequest(UpdateCooperativeRequest request) {
        if (!request.validateRequest()) {
            throw new ApplicationException(ErrorCode.WRONG_FORMAT_INPUT.getValue());
        }
    }

    @PutMapping("/api/updateCooperative")
    public ResponseData updateCooperative (@RequestBody UpdateCooperativeRequest request) {
        return handle(request);
    }

    @Override
    protected UpdateCooperativeResponse execute(UpdateCooperativeRequest request) {
        request.setCreated_time(Timestamp.valueOf(LocalDateTime.now()));
        Cooperative requestCooperative = ModelMapperUtils.mapperRequestToEntity(request, Cooperative.class);
        Cooperative cooperativeId = cooperativeService.findEntityById(request.getId());
        requestCooperative.setCooperativeId(cooperativeId.getCooperativeId());
        Cooperative cooperative = cooperativeService.updateEntity(requestCooperative);
        UpdateCooperativeResponse response = ModelMapperUtils.mapperEntityToResponse(cooperative, UpdateCooperativeResponse.class);
        return response;
    }
}

package com.example.project_agriculture.api.cooperative;

import com.example.project_agriculture.api.AbstractApi;
import com.example.project_agriculture.constant.ErrorCode;
import com.example.project_agriculture.entity.Cooperative;
import com.example.project_agriculture.exception.ApplicationException;
import com.example.project_agriculture.request.cooperative.AddCooperativeRequest;
import com.example.project_agriculture.request.cooperative.GetAllCooperativeRequest;
import com.example.project_agriculture.request.cooperative.GetCooperativeIdRequest;
import com.example.project_agriculture.response.ResponseData;
import com.example.project_agriculture.response.cooperative.AddCooperativeResponse;
import com.example.project_agriculture.response.cooperative.GetCooperativeIdResponse;
import com.example.project_agriculture.service.base.CooperativeService;
import com.example.project_agriculture.util.ModelMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@RestController
public class AddCooperativeApi extends AbstractApi<AddCooperativeRequest, AddCooperativeResponse> {

    @Autowired
    private CooperativeService cooperativeService;
    @Override
    protected void validateRequest(AddCooperativeRequest request) {
        if (!request.validateRequest()) {
            throw new ApplicationException(ErrorCode.WRONG_FORMAT_INPUT.getValue());
        }
    }

    @PostMapping("/api/addCooperative")
    public ResponseData addCooperative(@RequestBody AddCooperativeRequest request) {
        return handle(request);
    }

    @Override
    protected AddCooperativeResponse execute(AddCooperativeRequest request) {
        request.setCreated_time(Timestamp.valueOf(LocalDateTime.now()));
        Cooperative requestCooperative = ModelMapperUtils.mapperRequestToEntity(request, Cooperative.class);
        Cooperative cooperative = cooperativeService.addEntity(requestCooperative);
        AddCooperativeResponse response = ModelMapperUtils.mapperEntityToResponse(cooperative, AddCooperativeResponse.class);
        return response;
    }
}

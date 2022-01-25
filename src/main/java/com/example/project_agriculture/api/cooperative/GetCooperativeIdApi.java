package com.example.project_agriculture.api.cooperative;

import com.example.project_agriculture.api.AbstractApi;
import com.example.project_agriculture.entity.Cooperative;
import com.example.project_agriculture.request.cooperative.GetAllCooperativeRequest;
import com.example.project_agriculture.request.cooperative.GetCooperativeIdRequest;
import com.example.project_agriculture.response.ResponseData;
import com.example.project_agriculture.response.cooperative.GetAllCooperativeResponse;
import com.example.project_agriculture.response.cooperative.GetCooperativeIdResponse;
import com.example.project_agriculture.service.base.CooperativeService;
import com.example.project_agriculture.util.ModelMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@RestController
public class GetCooperativeIdApi extends AbstractApi<GetCooperativeIdRequest, GetCooperativeIdResponse> {

    @Autowired
    private CooperativeService cooperativeService;

    @Override
    protected void validateRequest(GetCooperativeIdRequest request) {
    }

    @GetMapping("/api/cooperative")
//    @PreAuthorize("hasAuthority(T(com.example.project_agriculture.constant.RoleName).ADMIN.getValue())")
    public ResponseData getCooperativeById(@RequestBody GetCooperativeIdRequest request) {
        return handle(request);
    }

    @Override
    protected GetCooperativeIdResponse execute(GetCooperativeIdRequest request) {
        Cooperative cooperativeById = cooperativeService.findEntityById(request.getId());
        GetCooperativeIdResponse response = ModelMapperUtils.mapperEntityToResponse(cooperativeById, GetCooperativeIdResponse.class);
        return response;
    }
}

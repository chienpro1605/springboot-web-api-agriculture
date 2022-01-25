package com.example.project_agriculture.api.cooperative;

import com.example.project_agriculture.api.AbstractApi;
import com.example.project_agriculture.entity.Cooperative;
import com.example.project_agriculture.request.cooperative.GetAllCooperativeRequest;
import com.example.project_agriculture.response.ResponseData;
import com.example.project_agriculture.response.cooperative.GetAllCooperativeResponse;
import com.example.project_agriculture.service.base.CooperativeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/cooperatives")
@RestController
@CrossOrigin(origins = "*")
public class GetAllCooperativeApi extends AbstractApi<GetAllCooperativeRequest, GetAllCooperativeResponse> {

    @Autowired
    private CooperativeService cooperativeService;
    @Override
    protected void validateRequest(GetAllCooperativeRequest request) {
    }

//    @GetMapping("/api/cooperatives")
////    @PreAuthorize("hasAuthority(T(com.example.project_agriculture.constant.RoleName).ADMIN.getValue())")
//    public ResponseData getAllCooperatives(GetAllCooperativeRequest request) { return handle(request); }

    @Override
    protected GetAllCooperativeResponse execute(GetAllCooperativeRequest request) {
        List<Cooperative> cooperatives = cooperativeService.getEntities();
        return new GetAllCooperativeResponse(cooperatives);
    }

    @GetMapping("/sortByName")
    public ResponseEntity<?> pageCooperativeSortByName(@PageableDefault(sort = "name", direction = Sort.Direction.ASC)Pageable pageable) {
        Page<Cooperative> cooperativePage = cooperativeService.findAll(pageable);
        if (cooperativePage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(cooperativePage, HttpStatus.OK);
    }
}

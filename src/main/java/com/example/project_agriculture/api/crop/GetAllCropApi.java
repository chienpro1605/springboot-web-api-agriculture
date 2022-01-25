package com.example.project_agriculture.api.crop;

import com.example.project_agriculture.api.AbstractApi;
import com.example.project_agriculture.entity.Crop;
import com.example.project_agriculture.repository.CropRepository;
import com.example.project_agriculture.request.cooperative.GetAllCooperativeRequest;
import com.example.project_agriculture.request.crop.GetAllCropRequest;
import com.example.project_agriculture.response.ResponseData;
import com.example.project_agriculture.response.cooperative.GetAllCooperativeResponse;
import com.example.project_agriculture.response.crop.GetAllCropResponse;
import com.example.project_agriculture.service.base.CropService;
import com.example.project_agriculture.util.ModelMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/crops")
@RestController
@CrossOrigin(origins = "*")
public class GetAllCropApi extends AbstractApi<GetAllCropRequest, GetAllCropResponse> {
    @Autowired
    private CropService cropService;
    @Override
    protected void validateRequest(GetAllCropRequest request) {

    }

//    @GetMapping("/api/crops")
////    @PreAuthorize("hasAuthority(T(com.example.project_agriculture.constant.RoleName).ADMIN.getValue())")
//    public ResponseData getAllCrop(GetAllCropRequest request) { return handle(request); }

    @Override
    protected GetAllCropResponse execute(GetAllCropRequest request) {
        List<Crop> crops = cropService.getEntities();
        return new GetAllCropResponse(crops);
    }

    @GetMapping("/sortByName")
    public ResponseEntity<?> pageCropSortByName(@PageableDefault(sort = "name", direction = Sort.Direction.ASC)Pageable pageable) {
        Page<Crop> cropPage = cropService.findAll(pageable);
        if (cropPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(cropPage, HttpStatus.OK);
    }
}

package com.example.project_agriculture.api.crop;

import com.example.project_agriculture.entity.Cooperative;
import com.example.project_agriculture.entity.Crop;
import com.example.project_agriculture.service.base.CropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/api/crops")
@RestController
@CrossOrigin(origins = "*")
public class DeleteCropApi {

    @Autowired
    private CropService cropService;

    @DeleteMapping("/{id}")
    public ResponseEntity<Crop> deleteCrop(@PathVariable String id) {
        Optional<Crop> cropOptional = Optional.ofNullable(cropService.findEntityById(id));
        cropService.deleteEntityById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

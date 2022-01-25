package com.example.project_agriculture.api.crop;

import com.example.project_agriculture.entity.Cooperative;
import com.example.project_agriculture.entity.Crop;
import com.example.project_agriculture.service.base.CooperativeService;
import com.example.project_agriculture.service.base.CropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

@RequestMapping("/api/crops")
@RestController
@CrossOrigin(origins = "*")
public class CropApi {

    @Autowired
    private CropService cropService;


//    @GetMapping("")
//    public ResponseEntity<Iterable<Crop>> getAllCrop() {
//        return new ResponseEntity<>(cropService.getEntities(), HttpStatus.OK);
//    }
//
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Crop>> getCropById(@PathVariable String id) {
        Optional<Crop> cropOptional = Optional.ofNullable(cropService.findEntityById(id));
        return new ResponseEntity<>(cropOptional, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Crop> createCrop(@RequestBody Crop crop) {
        crop.setCreated_time(Timestamp.valueOf(LocalDateTime.now()));
        return new ResponseEntity<>(cropService.addEntity(crop), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Crop> updateCrop(@PathVariable String id, @RequestBody Crop crop) {
        Optional<Crop> cropOptional = Optional.ofNullable(cropService.findEntityById(id));
        crop.setCropId(cropOptional.get().getCropId());
        crop.setCreated_time(Timestamp.valueOf(LocalDateTime.now()));
        cropService.updateEntity(crop);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

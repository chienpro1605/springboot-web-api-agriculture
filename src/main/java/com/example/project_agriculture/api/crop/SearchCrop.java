package com.example.project_agriculture.api.crop;

import com.example.project_agriculture.entity.Crop;
import com.example.project_agriculture.service.base.CropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/crops")
@RestController
@CrossOrigin(origins = "*")
public class SearchCrop {

    @Autowired
    private CropService cropService;

    @GetMapping("/search")
    public ResponseEntity<Iterable<Crop>> searchCrop (@RequestParam("name") String name, @RequestParam("treeType") String treeType, @RequestParam("cultivarName") String cultivarName) {
        return new ResponseEntity<>(cropService.searchCrop(name, treeType, cultivarName), HttpStatus.OK);
    }
}

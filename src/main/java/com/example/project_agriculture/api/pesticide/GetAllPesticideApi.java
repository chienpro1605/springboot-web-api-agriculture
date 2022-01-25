package com.example.project_agriculture.api.pesticide;

import com.example.project_agriculture.entity.Pesticide;
import com.example.project_agriculture.service.base.PesticideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/pesticides")
@RestController
@CrossOrigin(origins = "*")
public class GetAllPesticideApi {

    @Autowired
    private PesticideService pesticideService;

    @GetMapping("")
    public ResponseEntity<Iterable<Pesticide>> getAllPesticide() {
        return new ResponseEntity<>(pesticideService.getEntities(), HttpStatus.OK);
    }
}

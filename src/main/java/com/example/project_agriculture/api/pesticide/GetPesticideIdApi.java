package com.example.project_agriculture.api.pesticide;

import com.example.project_agriculture.entity.Pesticide;
import com.example.project_agriculture.service.base.PesticideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/api/pesticides")
@RestController
@CrossOrigin(origins = "*")
public class GetPesticideIdApi {

    @Autowired
    private PesticideService pesticideService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Pesticide>> getPesticideById(@PathVariable String id) {
        Optional<Pesticide> pesticideOptional = Optional.ofNullable(pesticideService.findEntityById(id));
        return new ResponseEntity<>(pesticideOptional, HttpStatus.OK);
    }
}

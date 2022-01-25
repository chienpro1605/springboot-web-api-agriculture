package com.example.project_agriculture.api.pesticide;

import com.example.project_agriculture.entity.Crop;
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
public class DeletePesticideApi {

    @Autowired
    private PesticideService pesticideService;

    @DeleteMapping("/{id}")
    public ResponseEntity<Pesticide> deletePesticide(@PathVariable String id) {
        Optional<Pesticide> pesticideOptional = Optional.ofNullable(pesticideService.findEntityById(id));
        pesticideService.deleteEntityById(pesticideOptional.get().getPesticideId());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

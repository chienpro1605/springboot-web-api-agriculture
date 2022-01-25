package com.example.project_agriculture.api.cooperative;

import com.example.project_agriculture.entity.Cooperative;
import com.example.project_agriculture.service.base.CooperativeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

@RequestMapping("/api/cooperatives")
@RestController
@CrossOrigin(origins = "*")
public class CooperativeApi {
    @Autowired
    CooperativeService cooperativeService;

//    @GetMapping()
//    public ResponseEntity<Iterable<Cooperative>> getAllCooperative() {
//        return new ResponseEntity<>(cooperativeService.getEntities(), HttpStatus.OK);
//    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Optional<Cooperative>> getCooperativeById(@PathVariable String id) {
//        Optional<Cooperative> cooperativeOptional = Optional.ofNullable(cooperativeService.findEntityById(id));
//        return new ResponseEntity<>(cooperativeOptional, HttpStatus.OK);
//    }

//    @PostMapping("")
//    public ResponseEntity<Cooperative> createCooperative(@RequestBody Cooperative cooperative) {
//        cooperative.setCreated_time(Timestamp.valueOf(LocalDateTime.now()));
//        return new ResponseEntity<>(cooperativeService.addEntity(cooperative), HttpStatus.CREATED);
//    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Cooperative> updateCooperative(@PathVariable String id, @RequestBody Cooperative cooperative) {
//        Optional<Cooperative> cooperativeOptional = Optional.ofNullable(cooperativeService.findEntityById(id));
//        cooperative.setCooperativeId(cooperativeOptional.get().getCooperativeId());
//        cooperative.setCreated_time(Timestamp.valueOf(LocalDateTime.now()));
//        cooperativeService.updateEntity(cooperative);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cooperative> deleteCooperative(@PathVariable String id) {
        Optional<Cooperative> cooperativeOptional = Optional.ofNullable(cooperativeService.findEntityById(id));
        cooperativeService.deleteEntityById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

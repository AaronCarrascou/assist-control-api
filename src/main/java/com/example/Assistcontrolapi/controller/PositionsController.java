package com.example.Assistcontrolapi.controller;

import com.example.Assistcontrolapi.model.Positions;
import com.example.Assistcontrolapi.service.PositionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/position")
public class PositionsController {
    @Autowired
    private PositionsService positionsService;

    @GetMapping
    public ResponseEntity<List<Positions>> getAllPositions(){
        List<Positions> positions = positionsService.getAllPositions();
        return ResponseEntity.ok(positions);
    }

    @PostMapping("/create_position")
    public ResponseEntity<Positions> createContract(@RequestBody Positions position) {
        Positions createdPosition = positionsService.createPosition(position);
        return new ResponseEntity<>(createdPosition, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{positionId}")
    public ResponseEntity<String> deletePositionById(@PathVariable Long positionId) {
        try {
            positionsService.deletePositionById(positionId);
            return ResponseEntity.ok("Position succesfully delete.");
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Position has employees.");
        }
    }
}

package com.example.Assistcontrolapi.controller;

import com.example.Assistcontrolapi.model.Contract;
import com.example.Assistcontrolapi.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private ContractService contractService;

    @GetMapping
    public ResponseEntity<List<Contract>> getAllContracts() {
        List<Contract> contracts = contractService.getAllContracts();
        return ResponseEntity.ok(contracts);
    }

    @PostMapping("/create_contract")
    public ResponseEntity<Contract> createContract(@RequestBody Contract contract) {
        Contract createdContract = contractService.createContract(contract);
        return new ResponseEntity<>(createdContract, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{contractId}")
    public ResponseEntity<String> deleteContractById(@PathVariable Long contractId) {
        try {
            contractService.deleteContractById(contractId);
            return ResponseEntity.ok("Contract succesfully delete.");
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Contract has employees.");
        }
    }
}

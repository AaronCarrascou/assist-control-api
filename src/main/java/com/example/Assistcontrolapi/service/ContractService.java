package com.example.Assistcontrolapi.service;

import com.example.Assistcontrolapi.model.Contract;

import java.util.List;

public interface ContractService {
    List<Contract> getAllContracts();

    Contract createContract(Contract contract);

    void deleteContractById(Long contractId);

}

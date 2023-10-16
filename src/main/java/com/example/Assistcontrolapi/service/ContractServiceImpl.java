package com.example.Assistcontrolapi.service;

import com.example.Assistcontrolapi.model.Contract;
import com.example.Assistcontrolapi.model.Employee;
import com.example.Assistcontrolapi.repository.ContractRepository;
import com.example.Assistcontrolapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    private ContractRepository contractRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Contract> getAllContracts() {
        return contractRepository.findAll();
    }

    @Override
    public Contract createContract(Contract contract) {
        return contractRepository.save(contract);
    }

    @Override
    public void deleteContractById(Long contractId) {

        int contractIdAsPrimitive =  contractId.intValue();

        List<Employee> employeesWithContract = employeeRepository.findByContractId(contractIdAsPrimitive);

        if (employeesWithContract.isEmpty()) {
            contractRepository.deleteById(contractId);
        } else {

            throw new RuntimeException("Contract has employees.");        }
    }

}

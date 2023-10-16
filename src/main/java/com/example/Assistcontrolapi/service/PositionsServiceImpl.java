package com.example.Assistcontrolapi.service;

import com.example.Assistcontrolapi.model.Contract;
import com.example.Assistcontrolapi.model.Employee;
import com.example.Assistcontrolapi.model.Positions;
import com.example.Assistcontrolapi.repository.ContractRepository;
import com.example.Assistcontrolapi.repository.EmployeeRepository;
import com.example.Assistcontrolapi.repository.PositionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionsServiceImpl implements PositionsService {
    @Autowired
    private PositionsRepository positionsRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Positions> getAllPositions() {
        return positionsRepository.findAll();
    }

    @Override
    public Positions createPosition(Positions position) {
        return positionsRepository.save(position);
    }

    @Override
    public void deletePositionById(Long positionId) {

        int positionIdAsPrimitive =  positionId.intValue();

        List<Employee> employeesWithContract = employeeRepository.findByPositionId(positionIdAsPrimitive);

        if (employeesWithContract.isEmpty()) {
            positionsRepository.deleteById(positionId);
        } else {

            throw new RuntimeException("Position has employees.");        }
    }
}

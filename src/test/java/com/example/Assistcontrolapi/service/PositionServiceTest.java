package com.example.Assistcontrolapi.service;

import com.example.Assistcontrolapi.model.Employee;

import com.example.Assistcontrolapi.repository.EmployeeRepository;
import com.example.Assistcontrolapi.repository.PositionsRepository;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.when;

public class PositionServiceTest {

    @InjectMocks
    private PositionsServiceImpl positionService;

    @Mock
    private PositionsRepository positionRepository;

    @Mock
    private EmployeeRepository employeeRepository;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDeletePositionWithNoEmployees() {
        when(employeeRepository.findByContractId(Mockito.anyInt())).thenReturn(new ArrayList<>());

        assertDoesNotThrow(() -> positionService.deletePositionById(1L));

        Mockito.verify(positionRepository).deleteById(1L);
    }

    @Test
    public void testDeletePositionWithEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee());
        when(employeeRepository.findByPositionId(Mockito.anyInt())).thenReturn(employees);

        assertThrows(RuntimeException.class, () -> positionService.deletePositionById(1L));

        Mockito.verify(positionRepository, Mockito.never()).deleteById(1L);
    }
}
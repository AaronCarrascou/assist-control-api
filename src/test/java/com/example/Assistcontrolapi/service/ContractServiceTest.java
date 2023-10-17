package com.example.Assistcontrolapi.service;

import com.example.Assistcontrolapi.model.Contract;
import com.example.Assistcontrolapi.model.Employee;
import com.example.Assistcontrolapi.repository.ContractRepository;
import com.example.Assistcontrolapi.repository.EmployeeRepository;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.when;

public class ContractServiceTest {

    @InjectMocks
    private ContractServiceImpl contractService;

    @Mock
    private ContractRepository contractRepository;

    @Mock
    private EmployeeRepository employeeRepository;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateContract() {
        Contract contract = new Contract();
        contract.setId(1);
        contract.setContract_name("Contract 1");
        when(contractRepository.save(contract)).thenReturn(contract);

        Contract createdContract = contractService.createContract(contract);

        assertNotNull(createdContract);
    }



    @Test
    public void testGetAllContracts() {
        Contract contract1 = new Contract();
        contract1.setId(1);
        contract1.setContract_name("Contract 1");

        Contract contract2 = new Contract();
        contract2.setId(2);
        contract2.setContract_name("Contract 2");

        when(contractRepository.findAll()).thenReturn(Arrays.asList(contract1, contract2));

        List<Contract> allContracts = contractService.getAllContracts();

        assertEquals(2, allContracts.size());
        assertEquals(contract1, allContracts.get(0));
        assertEquals(contract2, allContracts.get(1));
    }

    @Test
    public void testDeleteContractWithNoEmployees() {
        when(employeeRepository.findByContractId(Mockito.anyInt())).thenReturn(new ArrayList<>());

        // Verify that didn't call the exception
        assertDoesNotThrow(() -> contractService.deleteContractById(1L));

        Mockito.verify(contractRepository).deleteById(1L);
    }

    @Test
    public void testDeleteContractWithEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee());
        when(employeeRepository.findByContractId(Mockito.anyInt())).thenReturn(employees);

        // Verify that did call the exception
        assertThrows(RuntimeException.class, () -> contractService.deleteContractById(1L));
        // Verify that didn't call delete of rep
        Mockito.verify(contractRepository, Mockito.never()).deleteById(1L);
    }

}

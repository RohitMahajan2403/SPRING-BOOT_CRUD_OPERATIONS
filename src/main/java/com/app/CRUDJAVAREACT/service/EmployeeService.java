package com.app.CRUDJAVAREACT.service;

import com.app.CRUDJAVAREACT.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto updateEmployee(Long employeeId,EmployeeDto updatedEmp);

    void deleteEmployee(Long employeeId);
}

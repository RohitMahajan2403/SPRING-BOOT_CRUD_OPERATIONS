package com.app.CRUDJAVAREACT.service.Impl;

import com.app.CRUDJAVAREACT.dto.EmployeeDto;
import com.app.CRUDJAVAREACT.entity.Employee;
import com.app.CRUDJAVAREACT.exception.ResourceNotFound;
import com.app.CRUDJAVAREACT.mapper.EmployeeMapper;
import com.app.CRUDJAVAREACT.repository.EmployeeRepository;
import com.app.CRUDJAVAREACT.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmp = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmp);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee EmpById = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFound("Employee is Not Exist with given id :" + employeeId));

        return EmployeeMapper.mapToEmployeeDto(EmpById);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {

        List<Employee> employees = employeeRepository.findAll();

        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmp) {

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFound("Employee is Not Exists with id "+employeeId)
        );

        employee.setFirstName(updatedEmp.getFirstName());
        employee.setLastName(updatedEmp.getLastName());
        employee.setEmail(updatedEmp.getEmail());
        employee.setRole(updatedEmp.getRole());

        Employee updatedEmpObj = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(updatedEmpObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFound("Employee is Not Exists with id "+employeeId)
        );

        employeeRepository.deleteById(employeeId);

    }
}

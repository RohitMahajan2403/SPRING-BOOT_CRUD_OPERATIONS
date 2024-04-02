package com.app.CRUDJAVAREACT.controller;

import com.app.CRUDJAVAREACT.dto.EmployeeDto;
import com.app.CRUDJAVAREACT.repository.EmployeeRepository;
import com.app.CRUDJAVAREACT.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmp = employeeService.createEmployee(employeeDto);

        return new ResponseEntity<>(savedEmp, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmpById(@PathVariable("id") Long employeeId){
        EmployeeDto employeedto =employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeedto);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmp(){
        List<EmployeeDto> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @PutMapping("{id}")
    public  ResponseEntity<EmployeeDto> updatedEmp(@PathVariable("id") Long employeeId,@RequestBody EmployeeDto updatedEmp){
        EmployeeDto employeeDto = employeeService.updateEmployee(employeeId, updatedEmp);

        return ResponseEntity.ok(employeeDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee Deleted Successfully  !!!");
    }
}

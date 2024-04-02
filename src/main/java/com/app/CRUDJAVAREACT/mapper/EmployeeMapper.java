package com.app.CRUDJAVAREACT.mapper;

import com.app.CRUDJAVAREACT.dto.EmployeeDto;
import com.app.CRUDJAVAREACT.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(
                employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getEmail(), employee.getRole()
        );
    }

    public static  Employee mapToEmployee(EmployeeDto employeeDto){
        return new Employee(
                employeeDto.getId(), employeeDto.getFirstName(), employeeDto.getLastName(), employeeDto.getEmail(), employeeDto.getRole()
        );
    }
}

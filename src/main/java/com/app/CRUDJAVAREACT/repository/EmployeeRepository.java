package com.app.CRUDJAVAREACT.repository;

import com.app.CRUDJAVAREACT.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

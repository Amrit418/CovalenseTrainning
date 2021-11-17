package com.covalense.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.covalense.beans.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}

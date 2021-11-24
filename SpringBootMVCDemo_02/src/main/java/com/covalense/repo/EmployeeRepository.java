	package com.covalense.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.covalense.beans.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
@Query("select e from Employee e where e.department.id=?1")
List<Employee> findAllByDeptno(int dept_id);
	
	
}

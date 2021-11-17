package com.covalense.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.covalense.beans.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}

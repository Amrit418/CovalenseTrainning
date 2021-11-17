package com.covalense.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.covalense.beans.Employee;
import com.covalense.beans.Department;
import com.covalense.exception.InvalidDepartmentIdException;
import com.covalense.exception.invalidEmployeeIdException;
import com.covalense.repo.DepartmentRepository;

public class DepartmentService {
	@Autowired
	DepartmentRepository departmentRepository;

	public List<Department> findAll() {
		return departmentRepository.findAll();
	}

	public Department findByID(int id) throws InvalidDepartmentIdException {

		Optional<Department> deptOptional = departmentRepository.findById(id);
		if (!deptOptional.isPresent()) {
			throw new InvalidDepartmentIdException("Department Id " + id + " not existing in repository");
		}
		return deptOptional.get();
	}

	public Department save(Department department) {
		return departmentRepository.save(department);
	}

	public Department update(Department department) throws InvalidDepartmentIdException {
		Optional<Department> deptOptional = departmentRepository.findById(department.getId());
		if (!deptOptional.isPresent()) {
			throw new InvalidDepartmentIdException(
					"Department Id" + department.getId() + "not existing in reposiotory");
		}
		return departmentRepository.save(department);
	}

	public Department delete(int id) throws InvalidDepartmentIdException {
		Optional<Department> deptOptional = departmentRepository.findById((id));
		if (!deptOptional.isPresent()) {
			throw new InvalidDepartmentIdException("Department Id " + id + "not existing in repository");
		}
		Department department = deptOptional.get();
		departmentRepository.deleteById((id));
		return department;
	}
}

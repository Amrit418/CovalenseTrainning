package com.covalense.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covalense.beans.Employee;
import com.covalense.exception.invalidEmployeeIdException;
import com.covalense.repo.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;

	public List<Employee> findAll() {

		return employeeRepository.findAll();
	}

	public Employee findByID(int id) throws invalidEmployeeIdException {
		Optional<Employee> empOptional = employeeRepository.findById(id);
		if (!empOptional.isPresent()) {
			throw new invalidEmployeeIdException("Employee Id " + id + " is not exits in repository ");
		}

		return empOptional.get();

	}

	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}

	public Employee update(Employee employee) throws invalidEmployeeIdException {
		Optional<Employee> empOptional = employeeRepository.findById(employee.getId());
		if (!empOptional.isPresent()) {
			throw new invalidEmployeeIdException("Employee Id " + employee.getId() + " is not exits in repository ");
		}
		return employeeRepository.save(employee);

	}

	public Employee delete(int id) throws invalidEmployeeIdException {
		Optional<Employee> empOptional = employeeRepository.findById(id);
		if (!empOptional.isPresent()) {
			throw new invalidEmployeeIdException("Employee Id " + id + " is not exits in repository ");
		}
		Employee employee = empOptional.get();
		employeeRepository.deleteById(id);
		return employee;

	}

}

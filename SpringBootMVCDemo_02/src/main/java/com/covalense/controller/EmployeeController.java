package com.covalense.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.covalense.beans.Employee;
import com.covalense.exception.invalidEmployeeIdException;
import com.covalense.service.DepartmentService;
import com.covalense.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	DepartmentService departmentService ;

	@RequestMapping(value = "regemp", method = RequestMethod.GET)
	public ModelAndView newEmployee()
	{
	ModelAndView modelAndView=new ModelAndView("regEmployee","employee",new Employee());
	modelAndView.addObject("departmentService", departmentService);
	return modelAndView;
	}

	@RequestMapping(value = "regemp", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute("employee") Employee emp) throws invalidEmployeeIdException
	{
	System.out.println("Trying to insert employee : "+ emp);
	System.out.println("Department : "+emp.getDepartment());
	ModelAndView modelAndView=new ModelAndView("showEmployee");
	employeeService.save(emp);
	modelAndView.addObject("emps",employeeService.findAll());
	return modelAndView;
	}

	
	@RequestMapping(value = "getemps", method = RequestMethod.GET)
	public ModelAndView findEmployeeAll() throws invalidEmployeeIdException
	{
	ModelAndView modelAndView=new ModelAndView("showEmployee");
	List<Employee> emps= employeeService.findAll();
	modelAndView.addObject("emps",emps);
	return modelAndView;
	}
	

	@RequestMapping(value = "editEmp", method = RequestMethod.GET)
	public ModelAndView editEmp(@RequestParam int id) throws invalidEmployeeIdException {
		Employee empToEdit = employeeService.findByID(id);
		ModelAndView modelAndView = new ModelAndView("editEmp", "empToEdit", empToEdit);
		return modelAndView;
	}
     
	@RequestMapping(value = "updateEmp",method = RequestMethod.POST)
	public ModelAndView updateEditEmp(@ModelAttribute("empToEdit") Employee employee)
			throws invalidEmployeeIdException {
         employeeService.update(employee);
         ModelAndView modelAndView = new ModelAndView("redirect:"+ "getemps");
         System.out.println("Employee Updated successfully with id : "+employee.getId());
         return modelAndView ;
	}
	@RequestMapping(value = "deleteEmp")
	public ModelAndView deleteEmp(@RequestParam int id) throws invalidEmployeeIdException {
	employeeService.delete(id);
	ModelAndView modelAndView = new ModelAndView("redirect:" + "getemps");
	return modelAndView;
	}
}

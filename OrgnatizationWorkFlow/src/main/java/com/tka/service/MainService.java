package com.tka.service;

import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.dao.MainDao;
import com.tka.entity.Country;
import com.tka.entity.Employee;

@Service
public class MainService {
	@Autowired
	MainDao dao;

	// Add Country
	public String addCountry(Country c) {

		String msg = dao.addCountry(c);

		if (Objects.isNull(msg)) {
			msg = "Country is Not addedd";
		}

		return msg;
	}

	// Update Country
	public String updateCountry(Country c, int id) {
		String msg = dao.updateCountry(c, id);
		if (Objects.isNull(msg)) {
			msg = "Country is not Updated";
		}
		return msg;
	}

	// Delete Country
	public String deleteCountry(int id) {

		String msg = dao.deleteCountry(id);
		if (Objects.isNull(msg)) {
			msg = "Country is not Deleted";
		}
		return msg;

	}

	// Get All Country
	public List<Country> getAllCountry() {

		List<Country> list = dao.getAllCountry();

		return list;
	}

	// GetCountry ById
	public Country getParticularCountryById(int id) {
		Country con = dao.getParticularCountryById(id);
		return con;
	}

	// Add Employee
	public String addEmployee(Employee emp) {
		String msg = dao.addEmployee(emp);
		if (Objects.isNull(msg)) {
			msg = "Employee Addedd Successfully";

		}
		return msg;

	}

  //All Employee
	public List<Employee> getAllEmployee() {
       List<Employee> list = dao.getAllEmployee(); 
		return list;
	}
	 
	//Delete Employee
	public String deleteEmployee(long id) {
		String msg = dao.deleteEmployee(id);
		if (Objects.isNull(msg)) {
			msg = "Employee is not Deleted";
		}
		return msg;

	}
	
	// Update Employee
		public String updateEmployee(Employee em, long id) {
			String msg = dao.updateEmployee(em, id);
			if (Objects.isNull(msg)) {
				msg = "Country is not Updated";
			}
			return msg;
		}
	//Get One Employee
	public Employee getEmployeeById(long id) {
		Employee emp = dao.getEmployeeById(id);
		return emp;
	}

	// Login
	public Map login(Employee emp) {
		Employee obj = dao.login(emp);
		Map map = new HashMap();
		if (Objects.isNull(obj)) {
			map.put("msg", "Invalid User");
			map.put("user", obj);
		} else {
			map.put("msg", "Valid User");
			map.put("user", obj);
		}
		return map;
	}

	// Salary
	public List<Employee> salaryRange(double startSal, double endSal) {
		List<Employee> list = dao.salaryRange(startSal, endSal);
		return list;
	}

	

}

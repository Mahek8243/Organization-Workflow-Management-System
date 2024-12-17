package com.tka.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.entity.Country;
import com.tka.entity.Employee;

@Repository
public class MainDao {
	@Autowired
	SessionFactory factory;

	Session session = null;
	Transaction tx = null;
	String msg = null;

	// ****Country*****
	// Add Country
	public String addCountry(Country c) {
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			session.save(c);
			tx.commit();
			msg = "Country Addedd Successfully!!!";
		} catch (Exception e) {
			if (tx!= null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;
	}

	// Update Country
	public String updateCountry(Country c, int id) {
		Country country = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			country = session.get(Country.class, id);
			country.setCname(c.getCname());
			// session.merge(country);
			session.update(country);

			tx.commit();
			msg = "Country Updated Successfully!!!";
		} catch (Exception e) {
			if (tx!= null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;
	}

	// Delete Country
	public String deleteCountry(int id) {
		Country country = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			country = session.get(Country.class, id);

			session.delete(country);
			tx.commit();
			msg = "Country Deleted Successfully!!!";
		} catch (Exception e) {
			if (tx!= null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;

	}

	// Get All Country
	public List<Country> getAllCountry() {
		List<Country> list = null;
		String hqlQuery = "from Country";
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			Query<Country> query = session.createQuery(hqlQuery, Country.class);
			list = query.list();
			tx.commit();

		} catch (Exception e) {
			if (tx!= null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return list;
	}

	// Get Country ByID
	public Country getParticularCountryById(int id) {
		Country country = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			country = session.get(Country.class, id);
			tx.commit();

		} catch (Exception e) {
			if (tx!= null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return country;
	}

	// *****Employee*****
	// Add Employee
	public String addEmployee(Employee emp) {
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			session.persist(emp);
			tx.commit();
			msg = "Employee Addedd Successfully..";
		} catch (Exception e) {
			if (tx!= null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;
	}

//        ***** ALL Employee*****
	public List<Employee> getAllEmployee() {
		List<Employee> list = null;
		String hqlQuery = "from Employee";
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			Query<Employee> query = session.createQuery(hqlQuery, Employee.class);
			list = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx!= null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;

	}

	// ***** Delete Employee *****
	public String deleteEmployee(long id) {
		Employee emp = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			emp = session.get(Employee.class, id);

			session.delete(emp);
			tx.commit();
			msg = "Employee Deleted Successfully!!!";
		} catch (Exception e) {
			if (tx!= null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;
	}
	
	// Update Employee
	public String updateEmployee(Employee e1 , long id) {
		 Employee emp = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			emp = session.get(Employee.class, id);
			emp.setName(e1.getName());
			emp.setStatus(e1.getStatus());
			emp.setDepartment(e1.getDepartment());
			emp.setEmailid(e1.getEmailid());
			emp.setMobileno(e1.getMobileno());
			emp.setSalary(e1.getSalary());
			emp.setCreatedBy(e1.getCreatedBy());
			emp.setCreatedDate(e1.getCreatedDate());
			emp.setUpdatedBy(e1.getUpdatedBy());
			emp.setUpdatedDate(e1.getUpdatedDate());
			session.merge(emp);
			
          
			tx.commit();
			msg = "Employee Updated Successfully!!!";
		} catch (Exception e) {
			if (tx!= null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;
	}


	// ***** Get One Employee *****
	public Employee getEmployeeById(long id) {
		Employee emp = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			emp = session.get(Employee.class, id);
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return emp;
	}
	

	// *****Login*****
	public Employee login(Employee emp) {
		Employee employee = null;
		String hqlQuery = "from Employee where emailid=:emailid and mobileno=:mobileno";
		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			Query<Employee> query = session.createQuery(hqlQuery, Employee.class);
			query.setParameter("emailid", emp.getEmailid());
			query.setParameter("mobileno", emp.getMobileno());
			employee = query.uniqueResult();
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return employee;
	}

	// *****Salary*****
	public List<Employee> salaryRange(double startSal, double endSal) {
		List<Employee> list = null;
		String hqlQuery = "from Employee where salary between :startSal and :endSal";
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			Query<Employee> query = session.createQuery(hqlQuery, Employee.class);
			query.setParameter("startSal", startSal);
			query.setParameter("endSal", endSal);
			list = query.list();
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return list;
	}

}

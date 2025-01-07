
package com.sprk.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.sprk.dao.EmployeeDao;
import com.sprk.model.Employee;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/employee")
public class ProcessFormController extends HttpServlet {

	private EmployeeDao employeeDao;

	@Resource(name = "emp_management")
	private DataSource dataSource;

	@Override
	public void init() throws ServletException {
		employeeDao = new EmployeeDao(dataSource);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		String salaryStr = req.getParameter("salary");
		String joiningDateStr = req.getParameter("joiningDate");
		String email = req.getParameter("email");
		
		List<String> errors = new ArrayList<>();
		int errorCount = 0;
		
		if(name.isBlank()|| name == null) {
			errors.add("Name cannot be empty");
			errorCount++;
		}
		if(email.isBlank()|| email == null) {
			errors.add("Email cannot be empty");
			errorCount++;
			
		}
		if(joiningDateStr.isBlank()|| joiningDateStr== null) {
			errors.add("Please add joining date");
			errorCount++;
		}
		if(gender== null || gender.isBlank() ) {
			errors.add("Please select gender");
			errorCount++;
		}
		if(salaryStr.isBlank()|| salaryStr== null) {
			errors.add("Please select salary");
			errorCount++;
		}
		if(errorCount>0)
		{
			req.setAttribute("errMsg", errors);
		    req.setAttribute("name", name);
		    req.setAttribute("gender", gender);
		    req.setAttribute("salary", salaryStr);
		    req.setAttribute("joiningDate", joiningDateStr);
		    req.setAttribute("email", email);
		    
			RequestDispatcher rd = req.getRequestDispatcher("add.jsp");
			req.setAttribute("errMsg", errors);
			
			rd.forward(req, resp);
		}

		Date joiningDate = Date.valueOf(joiningDateStr);
        
		
		double salary = Double.parseDouble(salaryStr);

		Employee employee = new Employee(name, gender, salary, joiningDate, email);

		
		try {
			int result = employeeDao.addEmployee(employee);
			if (result > 0) {
				session.setAttribute("successMsg", "Employee Saved Successfully!");
//				System.out.println("Insert Successfull");
			}else {
//				System.out.println("Something Bad happen");
				session.setAttribute("errMsg", "Something Bad Happen!");
				
			}
			resp.sendRedirect("employee");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		session.setAttribute("Employee",employee);
//
//		resp.sendRedirect("dash.jsp");

	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			List<Employee> employees = employeeDao.getAllEmployees();
			
			req.setAttribute("employees", employees);
			
			req.getRequestDispatcher("/dashboard.jsp").forward(req, resp);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

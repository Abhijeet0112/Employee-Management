
package com.sprk.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.sql.DataSource;

import com.sprk.dao.EmployeeDao;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/test-db")
public class DbTestController extends HttpServlet {

//	private EmployeeDao employeeDao;
//
//	@Resource(name = "emp_management")
//	private DataSource dataSource;
//
//	@Override
//	public void init() throws ServletException {
//		employeeDao = new EmployeeDao(dataSource);
//	}
//
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		try {
//			Connection conn = dataSource.getConnection();
//			System.out.println(conn);
//
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println(e);
//		}
//
//	}
}

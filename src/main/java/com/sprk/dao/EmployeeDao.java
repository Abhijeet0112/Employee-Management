
package com.sprk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.sprk.model.Employee;

public class EmployeeDao {

	private DataSource dataSource;

	public EmployeeDao(DataSource dataSource) {
//		System.out.println("Employee Dao Obj created");
		this.dataSource = dataSource;
	}

	public int addEmployee(Employee employee) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = dataSource.getConnection();
		String sql = "insert into employee(name,gender,salary,joining_date,email) values (?,?,?,?,?)";

		PreparedStatement ps = conn.prepareStatement(sql);

		ps.setString(1, employee.getName());
		ps.setString(2, employee.getGender());
		ps.setDouble(3, employee.getSalary());
		ps.setDate(4, employee.getJoiningDate());
		ps.setString(5, employee.getEmail());

		int result = ps.executeUpdate();
		closeAll(conn, ps, null);

		return result;

	}

	public List<Employee> getAllEmployees() throws Exception {
		Connection conn = dataSource.getConnection();
		String sql = "select * from employee";
		PreparedStatement ps = conn.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();

		List<Employee> employees = new ArrayList<>();
		while (rs.next()) {
			Employee employee = new Employee();
			employee.setEmpId(rs.getInt("emp_id"));
			employee.setName(rs.getString("name"));
			employee.setEmail(rs.getString("email"));
			employee.setSalary(rs.getDouble("salary"));
			employee.setGender(rs.getString("gender"));
			employee.setCreatedAt(rs.getTimestamp("created_at"));
			employee.setLastUpdate(rs.getTimestamp("last_update"));
			employee.setJoiningDate(rs.getDate("joining_date"));

			employees.add(employee);
		}

		closeAll(conn, ps, rs);

		return employees;

	}

	private void closeAll(Connection conn, PreparedStatement ps, ResultSet rs) throws Exception {
		// TODO Auto-generated method stu
		if (conn != null) {
			conn.close();
		}
		if (rs != null) {
			rs.close();
		}
		if (ps != null) {
			ps.close();
		}

	}

	public Employee getEmployeeById(int eId) throws Exception {
		Connection conn = dataSource.getConnection();
		String sql = "select * from employee where emp_id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, eId);

		ResultSet rs = ps.executeQuery();

		Employee employee = new Employee();
		if (rs.next()) {
			employee.setEmpId(rs.getInt("emp_id"));
			employee.setName(rs.getString("name"));
			employee.setEmail(rs.getString("email"));
			employee.setSalary(rs.getDouble("salary"));
			employee.setGender(rs.getString("gender"));
			employee.setCreatedAt(rs.getTimestamp("created_at"));
			employee.setLastUpdate(rs.getTimestamp("last_update"));
			employee.setJoiningDate(rs.getDate("joining_date"));

		}

		closeAll(conn, ps, rs);
		return employee;
	}

	public int deleteEmployee(Employee employee)throws Exception {
		// TODO Auto-generated method stub
		Connection conn = dataSource.getConnection();
		String sql = "delete from employee where emp_id = ?";

		PreparedStatement ps = conn.prepareStatement(sql);

		ps.setInt(1, employee.getEmpId());
		int result = ps.executeUpdate();
		closeAll(conn, ps, null);

		return result;

	}

	public int updateEmployee(Employee employee) throws Exception {
		Connection conn = dataSource.getConnection();
		String sql = "update employee set name = ?,gender =?,salary =?,joining_date = ? ,email = ? where emp_id = ?";

		PreparedStatement ps = conn.prepareStatement(sql);

		ps.setString(1, employee.getName());
		ps.setString(2, employee.getGender());
		ps.setDouble(3, employee.getSalary());
		ps.setDate(4, employee.getJoiningDate());
		ps.setString(5, employee.getEmail());
		ps.setInt(6, employee.getEmpId());

		int result = ps.executeUpdate();
		closeAll(conn, ps, null);

		return result;
	}

}

package com.crud.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.crud.db.CrudDb;

public class EmployeeDao {
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	public boolean addemployee(EmployeeDto dto) {
		boolean flag = false;
		// condition for connection stablished or not;
		if (conn == null) {
			conn = CrudDb.getDb();
		}
		try {
			String query = "insert into employee(name, mno, email, pwd, gender, salary) values(?,?,?,?,?,?)";
			ps = conn.prepareStatement(query);
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getMno());
			ps.setString(3, dto.getEmail());
			ps.setString(4, dto.getPwd());
			ps.setString(5, dto.getGender());
			ps.setFloat(6, dto.getSalary());
			if (ps.executeUpdate() > 0) {
				flag = true;
			}

		} catch (Exception e) {
			System.out.println("Exception at addEmployee():" + e);
		} finally {
			ps = null;
			conn = null;

			return flag;
		}

	}

	public boolean updateEmployee(EmployeeDto dto) {
		boolean flag = false;
		if (conn == null) {
			conn = CrudDb.getDb();
		}
		try {
			String sql = "update employee set  name=?, mno=?, email=?, pwd=?, gender=?, salary=? whear eno=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getMno());
			ps.setString(3, dto.getEmail());
			ps.setString(4, dto.getPwd());
			ps.setString(5, dto.getGender());
			ps.setFloat(6, dto.getSalary());
			ps.setInt(7, dto.getEno());
			if (ps.executeUpdate() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			System.out.println("Exception at updateEmployee():" + e);
		} finally {
			ps = null;
			conn = null;
			return flag;
		}
	}

	public boolean deleteEmployee(final int eno) {
		boolean flag = false;
		if (conn == null) {
			conn = CrudDb.getDb();
		}
		try {
			String sql = "delete from employee where eno=?";
			ps = conn.prepareStatement(sql);
			if (ps.executeUpdate() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			System.out.println("Exception at deleteEmployee():" + e);
		} finally {
			ps = null;
			conn = null;
			return flag;

		}
	}

	public ArrayList<EmployeeDto> getAllEmployies() {
		ArrayList<EmployeeDto> al = new ArrayList<EmployeeDto>();
		EmployeeDto dto;
		if (conn == null) {
			conn = CrudDb.getDb();

		}
		try {
			System.out.println(conn);
			String sql = "select *from employee";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				dto = new EmployeeDto();
				dto.setEno(rs.getInt("eno"));
				dto.setName(rs.getString("name"));
				dto.setEmail(rs.getString("email"));
				dto.setGender(rs.getString("gender"));
				dto.setMno(rs.getString("mno"));
				dto.setSalary(rs.getFloat("salary"));
				dto.setPwd(rs.getString("pwd"));
				al.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception at getAllEmployies():" + e);

		} finally {
			rs = null;
			ps = null;
			conn = null;
			return al;
		}

	}

	public static void main(String[] args) {
		EmployeeDao dao = new EmployeeDao();
		/*
		 * EmployeeDto dto=new
		 * EmployeeDto("Aman","9179553187","choudharyashwini12@","iniwhsa","femail",
		 * 89000); dto.setEno(1); boolean a=dao.addemployee(dto); System.out.println(a);
		 * //EmployeeDao dao=new EmployeeDao(); boolean x=dao.deleteEmployee(1);
		 * System.out.println(x);
		 */

		ArrayList<EmployeeDto> list = dao.getAllEmployies();
		System.out.println("Eno\tName\tEmail\tGender\tMno\tSalary\tPwd");
		System.out.println("-------------------------------");
		for (EmployeeDto dto : list) {
			System.out.println(dto.getEno() + "\t" + dto.getName() + "\t" + dto.getEmail() + "\t" + dto.getGender()
					+ "\t" + dto.getMno() + "\t" + dto.getSalary() + "\t" + dto.getPwd());

		}
	}
}

package com.uiFramework.companyName.projectName.helper.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ApplicationDBQuery {
	
	public int empSalary(int empId) throws NumberFormatException, SQLException {
		int salary=0;
		String dbQuery = "SELECT salary FROM person.employee where idemployee="+empId;
		ResultSet result = DataBaseHelper.getResultSet(dbQuery);
		while(result.next()) {
			salary = Integer.parseInt(result.getString("salary"));
		}
		return salary;
	}
	
	public List<Employee> getEmployee() throws SQLException {
		List<Employee> data = new ArrayList<Employee>();
		String dbQuery = "SELECT salary FROM person.employee";
		ResultSet result = DataBaseHelper.getResultSet(dbQuery);
		while(result.next()) {
			Employee emp = new Employee();
			emp.setEmpId(Integer.parseInt(result.getString("idemployee")));
			emp.setSalary(Integer.parseInt(result.getString("salary")));
			emp.setName(result.getString("name"));
			emp.setAddress(result.getString("idemployee"));
			data.add(emp);
		}
		return data;
	}

}

package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.dbconn.DBConnection;
import com.project.emp_entities.Emp;

public class EmpDAOImpl implements EmpDAO {

	@Override
	public void addEmployee(Emp emp) {
		
		try (Connection connection =  DBConnection.getConnection()){
			String query = "Insert into jbk_table(id, name, dept) VALUES (?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1,emp.getId());
			ps.setString(2,emp.getName());
			ps.setString(3,emp.getDept());
			ps.executeUpdate();			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}

	@Override
	public void updateEmployee(Emp emp) {
		try (Connection connection =  DBConnection.getConnection()){
			String UPDATE_EMPLOYEE = "UPDATE jbk_table SET  name=?, dept=? WHERE id=?";
			PreparedStatement ps = connection.prepareStatement(UPDATE_EMPLOYEE );
			ps.setString(1, emp.getName());
			ps.setString(2, emp.getDept());
			ps.setInt(3, emp.getId());
			ps.executeUpdate();
			int rowsUpdated = ps.executeUpdate();
	            if (rowsUpdated > 0) {
	                System.out.println("An existing employee was updated successfully!");
	            } else {
	                System.out.println("Employee with ID " + emp.getId() + " not found.");
	            }
		}
		catch(SQLException e)
		{
			e.printStackTrace();
	}
	}

	@Override
	public void deleteEmployee(int id) {
		try (Connection con = DBConnection.getConnection()){
				String DELETE_QUERY = "DELETE from jbk_table where id=?";
				PreparedStatement ps = con.prepareStatement(DELETE_QUERY);
				ps.setInt(1,id);
				ps.executeUpdate();
				
	}catch(SQLException e) {
		e.printStackTrace();
	}		
	
	
	}

	@Override
	public List<Emp> getAllEmployees() {
		List<Emp> emps= new ArrayList<>();
		try(Connection con = DBConnection.getConnection()){
			String SelectAll = "SELECt * from jbk_table";
			PreparedStatement ps = con.prepareStatement(SelectAll);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String dept = rs.getString("dept");
				emps.add(new Emp(id, name, dept));
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return emps;
		
		
	}
	
}
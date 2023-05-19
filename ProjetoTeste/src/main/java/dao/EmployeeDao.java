package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.ResultSet;

import model.Employee;


public class EmployeeDao {
	
	 public int registerEmployee(Employee employee) throws ClassNotFoundException {
	        String INSERT_USERS_SQL = "INSERT INTO employee" +
	            "  (id, first_name, last_name, username, password, address, contact) VALUES " +
	            " (?, ?, ?, ?, ?,?,?);";

	        int result = 0;

	        Class.forName("com.mysql.jdbc.Driver");

	        try (Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/employees", "root", "");

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
	            preparedStatement.setInt(1, 1);
	            preparedStatement.setString(2, employee.getFirstName());
	            preparedStatement.setString(3, employee.getLastName());
	            preparedStatement.setString(4, employee.getUsername());
	            preparedStatement.setString(5, employee.getPassword());
	            preparedStatement.setString(6, employee.getAddress());
	            preparedStatement.setString(7, employee.getContact());

	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            result = preparedStatement.executeUpdate();

	        } catch (SQLException e) {
	            // process sql exception
	            e.printStackTrace();
	        }
	        return result;
	    }




	public Employee getUser(String username) throws ClassNotFoundException {
		   String LOG_USERS_SQL = "SELECT (username) FROM employee" +
	        		" WHERE username=?";

	        Employee employee = null;

	        Class.forName("com.mysql.jdbc.Driver");

	        try (Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/employees", "root", "");

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(LOG_USERS_SQL)) {
	            preparedStatement.setString(1, username);

	            System.out.println(preparedStatement);
	            try (ResultSet resultSet = (ResultSet) preparedStatement.executeQuery();) {
	            	if(resultSet.next()) {
	            		employee = new Employee();
	            		employee.setFirstName(resultSet.getString("first_name"));
	            		employee.setFirstName(resultSet.getString("last_name"));
	            		employee.setFirstName(resultSet.getString("username"));
	            		employee.setFirstName(resultSet.getString("password"));
	            		employee.setFirstName(resultSet.getString("address"));
	            		employee.setFirstName(resultSet.getString("contact"));
	            	}
	            } catch (SQLException e) {
		            // process sql exception
		            e.printStackTrace();
		        }
		            

	        } catch (SQLException e) {
	            // process sql exception
	            e.printStackTrace();
	        }
	        
	        return employee;
	}
	
	public Employee getPassword(String password) throws ClassNotFoundException {
		   String LOG_USERS_SQL = "SELECT (password) FROM employee" +
	        		" WHERE password=?";

	        Employee employee = null;

	        Class.forName("com.mysql.jdbc.Driver");

	        try (Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/employees", "root", "");

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(LOG_USERS_SQL)) {
	            preparedStatement.setString(1, password);

	            System.out.println(preparedStatement);
	            try (ResultSet resultSet = (ResultSet) preparedStatement.executeQuery();) {
	            	if(resultSet.next()) {
	            		employee = new Employee();
	            		employee.setFirstName(resultSet.getString("first_name"));
	            		employee.setFirstName(resultSet.getString("last_name"));
	            		employee.setFirstName(resultSet.getString("username"));
	            		employee.setFirstName(resultSet.getString("password"));
	            		employee.setFirstName(resultSet.getString("address"));
	            		employee.setFirstName(resultSet.getString("contact"));
	            	}
	            } catch (SQLException e) {
		            // process sql exception
		            e.printStackTrace();
		        }
		            

	        } catch (SQLException e) {
	            // process sql exception
	            e.printStackTrace();
	        }
	        
	        return employee;
	}
	
	

}

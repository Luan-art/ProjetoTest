package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import dao.EmployeeDao;

import model.Employee;

@WebServlet("/login")

public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	EmployeeDao employeeDao = new EmployeeDao();


	public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("login");
        String password = request.getParameter("password");
        
        
        Employee employee = null;
        
        try {
            employee = employeeDao.logEmployee(username, password);
            System.out.println(employee.getUsername());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        request.setAttribute("employee", employee);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/employeedetails.jsp");
		dispatcher.forward(request, response);
    }
	
	
	
}

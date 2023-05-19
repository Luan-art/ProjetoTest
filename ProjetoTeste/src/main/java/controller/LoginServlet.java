package controller;

import java.io.IOException;


import dao.EmployeeDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Employee;

@WebServlet("/login")

public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	EmployeeDao employeeDao = new EmployeeDao();


	public LoginServlet() {
        // TODO Auto-generated constructor stub
		
		super();
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
        Employee employee1 = null;
        
        
        try {
            employee = employeeDao.getUser(username);
            employee1= employeeDao.getPassword(password);
            
            System.out.println(employee.getUsername());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        if(employee == employee1) {
            request.setAttribute("employee", employee);
            
            
            DadosEmpregadosServelts des = new DadosEmpregadosServelts();
            
            //des.doGet(request, response);
        }
    
    }
	
	
	
}

package com.softra.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.softra.model.Student;
import com.softra.service.IService;
import com.softra.service.StudentService;

/**
 * Servlet implementation class StudentRegistrationServlet
 */
public class StudentRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IService service;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentRegistrationServlet() {
        super();
        service = new StudentService();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside doPost method");
		
		String name = request.getParameter("sname");
		String age = request.getParameter("sage");
		String mobile = request.getParameter("smobile");
		String address = request.getParameter("saddress");
		
		Student s = new Student(name, Integer.parseInt(age), Integer.parseInt(mobile), address);
		request.setAttribute("student", s);
		
		System.out.println(name + ", " + age + ", " + mobile + ", " + address);
		
		ServletContext context = request.getServletContext();
		context.setAttribute("student", s);
		context.setAttribute("driverClassName", getInitParameter("driverClassName"));
		context.setAttribute("url", getInitParameter("url"));
		context.setAttribute("username", getInitParameter("username"));
		context.setAttribute("password", getInitParameter("password"));
		
		service.saveStudent(context);
		
		
		RequestDispatcher rd  = request.getRequestDispatcher("/pages/success.jsp");
		rd.forward(request, response);
	}

}

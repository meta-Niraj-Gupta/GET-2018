package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ConnectingEmployeeDatabase;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.pojo.Employee;

public class AddEmployeeServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		PrintWriter out = response.getWriter();
		ConnectingEmployeeDatabase connectingEmployee;
		try{
			connectingEmployee = new ConnectingEmployeeDatabase();
		}catch(SQLException exception){
			exception.printStackTrace();
			out.println("Database Connection failed. Please try again.");
			return;
		}catch(ClassNotFoundException exception){
			exception.printStackTrace();
			out.println("Server not configured properly");
			return;
		}
		
		try{
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			int age = Integer.valueOf(request.getParameter("age"));
			String email = request.getParameter("email");
			Employee employee = new Employee(null , firstName, lastName, email, age);
			int rowsAffected = connectingEmployee.addEmployeeDetails(employee);
			if(rowsAffected == 1){
				out.println("Data Successfully Inserted");
			}
		}catch(MySQLIntegrityConstraintViolationException exception){
			out.println("Duplicate entry for key email");
		}catch(SQLException exception){
			exception.printStackTrace();
			out.println("Invalid Input");
		}
			
		out.print("<div><a href=\"index.html\">Go to Home</a></div>");
	}
}

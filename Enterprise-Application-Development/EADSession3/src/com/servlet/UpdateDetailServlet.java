package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ConnectingEmployeeDatabase;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.pojo.Employee;

public class UpdateDetailServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
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
			Employee employee = connectingEmployee.getEmployeeById(Integer.parseInt(request.getParameter("id")));
			if(employee != null){
				out.println("<!DOCTYPE html>"); 
				out.println("<html>"); 
				out.print("\t<head>"); 
				out.println("\t\t<title>Employees Detail</title>"); 
				out.println("\t\t<style> \n\t\t\t a { text-decoration : none} \n\t\t </style>");
				out.println("\t</head>"); 
				out.println("\t<body>"); 
				out.println("\t\t<form action = \"updateDetailInDatabase\" method = \"post\">");
				out.println("<input type = 'hidden' name = 'id' value = '" + employee.getId() + "' />");
				out.println("\t\t\t<table>");
				out.println("\t\t\t\t<tr>");
				out.println("\t\t\t\t\t<td>First Name</td>");
				out.println("\t\t\t\t\t<td> <input type = \"text\" name = \"firstName\" value = \"" + employee.getFirstName() + "\" /></td>");
				out.println("\t\t\t\t</tr>");
				out.println("\t\t\t\t\t<td>Last Name</td>");
				out.println("\t\t\t\t\t<td> <input type = \"text\" name = \"lastName\" value = \"" + employee.getLastName() + "\" /></td>");
				out.println("\t\t\t\t</tr>");
				out.println("\t\t\t\t\t<td>Email</td>");
				out.println("\t\t\t\t\t<td> <input type = \"email\" name = \"email\" value = \"" + employee.getEmail() + "\" /></td>");
				out.println("\t\t\t\t</tr>");
				out.println("\t\t\t\t\t<td>Age</td>");
				out.println("\t\t\t\t\t<td> <input type = \"number\" name = \"age\" value = \"" + employee.getAge() + "\" /></td>");
				out.println("\t\t\t\t</tr>");
				out.println("\t\t\t\t</tr>");
				out.println("\t\t\t\t\t<td colspan = \"2\"> <input type = \"submit\" value = \"Update\" /></td>");
				out.println("\t\t\t\t</tr>");
				out.println("\t\t\t</table>");
				out.println("\t\t</form>");
				out.println("\t</body>");
				out.println("</html>");
			}else{
				out.println("Cannot Update right now. Try again later.");
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

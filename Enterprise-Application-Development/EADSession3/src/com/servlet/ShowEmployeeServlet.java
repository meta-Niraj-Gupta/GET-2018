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
import com.pojo.Employee;

public class ShowEmployeeServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		PrintWriter out = response.getWriter();
		ConnectingEmployeeDatabase connectingEmployee;
		try{
			connectingEmployee = new ConnectingEmployeeDatabase();
		}catch(SQLException exception){
			exception.printStackTrace();
			out.println("Connection To Database Failed. Please try later.");
			return;
		}catch(ClassNotFoundException exception){
			exception.printStackTrace();
			out.println("Server Not Configured Properly");
			return;
		}
		
		try{
			out.println("<!DOCTYPE html>"); 
			out.println("<html>"); 
			out.print("\t<head>"); 
			out.println("\t\t<title>Employees Detail</title>"); 
			out.println("\t\t<style> \n\t\t\t a { text-decoration : none} \n\t\t </style>");
			out.println("\t</head>"); 
			out.println("\t<body>"); 
			out.println("\t\t<table>");
			out.println("\t\t\t<tr>");
			out.println("\t\t\t<th>Employee Id</th>");
			out.println("\t\t\t<th>First Name</th>");
			out.println("\t\t\t<th>Last Name</th>");
			out.println("\t\t\t<th>Email</th>");
			out.println("\t\t\t<th>Age</th>");
			out.println("\t\t</tr>");
			
			for(Employee employee : connectingEmployee.getEmployeeDetails()){
				out.println("\t\t<tr>");
				out.println("\t\t\t<td>" + employee.getId() + "</td>");
				out.println("\t\t\t<td>" + employee.getFirstName() + "</td>");
				out.println("\t\t\t<td>" + employee.getLastName() + "</td>");
				out.println("\t\t\t<td>" + employee.getEmail() + "</td>");
				out.println("\t\t\t<td>" + employee.getAge() + "</td>");
				out.println("\t\t\t<td> <a href=\"updateDetail?id=" + employee.getId() + "\">Update</a>");
				out.println("\t\t</tr>");
			}

			out.println("\t\t</table>");
			out.println("\t</body>");
			out.println("</html>");
			
		}catch(SQLException exception){
			exception.printStackTrace();
			out.println("Unable to fetch Employee detail. Try again later.");
			return;
		}
		
		out.print("<div><a href=\"index.html\">Go to Home</a></div>");
	}
}

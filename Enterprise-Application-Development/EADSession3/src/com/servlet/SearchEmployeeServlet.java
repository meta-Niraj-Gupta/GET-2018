package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ConnectingEmployeeDatabase;
import com.pojo.Employee;

public class SearchEmployeeServlet extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
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
			out.println("Server Not Properly Configured");
			return;
		}

		String searchName = request.getParameter("searchName");
		try{
			List<Employee> employees = connectingEmployee.getEmployeeByName(searchName);
			if(employees.size() > 0){
				out.println("<!DOCTYPE html>");
				out.println("<html>");
				out.print("\t<head>");
				out.println("\t\t<title>Searched Result</title>");
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

				for (Employee employee : employees) {
					out.println("\t\t<tr>");
					out.println("\t\t\t<td>" + employee.getId() + "</td>");
					out.println("\t\t\t<td>" + employee.getFirstName() + "</td>");
					out.println("\t\t\t<td>" + employee.getLastName() + "</td>");
					out.println("\t\t\t<td>" + employee.getEmail() + "</td>");
					out.println("\t\t\t<td>" + employee.getAge() + "</td>");
					out.println("\t\t</tr>");
				}
				
				out.println("\t\t</table>");
				out.println("\t</body>");
				out.println("</html>");
				
			}else{
				out.println("No employee of name = " + searchName + " is available.");
			}

		} catch (SQLException exception) {
			exception.printStackTrace();
		}
	}
}

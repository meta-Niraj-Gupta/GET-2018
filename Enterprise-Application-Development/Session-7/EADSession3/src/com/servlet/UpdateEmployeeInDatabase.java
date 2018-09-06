package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ConnectingEmployeeDatabase;
import com.pojo.Employee;

public class UpdateEmployeeInDatabase extends HttpServlet{
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
			int age = Integer.parseInt(request.getParameter("age"));
			String email = request.getParameter("email");
			int id = Integer.parseInt(request.getParameter("id"));
			Employee employee = new Employee(id , firstName, lastName, email, age);
			int rowsAffected = connectingEmployee.updateEmployeeDetails(employee);
			if(rowsAffected == 1){
				out.println("Data Updated Successfully");
			}
		}catch(SQLException exception){
			exception.printStackTrace();
			out.println("Invalid Update data. Please check and try again later.");
			return;
		}

		out.println("<a href=\"showEmployee\">Go to Employee List</a>");
	}

}

package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.doa.DatabaseOperation;
import com.pojo.User;

@WebServlet("/editUser")
public class UpdateUserInDatabase extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		PrintWriter out = response.getWriter();
		DatabaseOperation dbOperation;
		try{
			dbOperation = new DatabaseOperation();
		}catch(IOException exception){
			exception.printStackTrace();
			out.println("Cannot connect to the database.");
			return;
		}catch(SQLException exception){
			exception.printStackTrace();
			out.println("Database Connection failed. Please try again.");
			return;
		}catch(ClassNotFoundException exception){
			exception.printStackTrace();
			out.println("Server not configured properly");
			return;
		}

		HttpSession session = request.getSession();
		User userInfo = (User) session.getAttribute("userDetail");
		Integer id = userInfo.getId();
		
		
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		Date birthdate = Date.valueOf(request.getParameter("birthdate"));
		String mobileNumber = request.getParameter("mobilenumber");
		String organization = request.getParameter("organization");
		String email = request.getParameter("email");
		String newPassword = request.getParameter("newPassword");
		User user = new User(id, firstName, lastName, mobileNumber, birthdate, organization, email, newPassword, null);
		int rowsAffected;
		
		try{
			rowsAffected = dbOperation.updateUserDetail(user);
			
		}catch(SQLException exception){
			exception.printStackTrace();
			out.println("Invalid Update data. Please check and try again later.");
			return;
		}
		
		if(rowsAffected == 1){
			out.println("Data updated successfully");
		}
	}
}

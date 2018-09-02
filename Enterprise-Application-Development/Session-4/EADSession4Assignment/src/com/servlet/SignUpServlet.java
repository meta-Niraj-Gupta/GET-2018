package com.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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

@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet{
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
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		Date birthDate = Date.valueOf(request.getParameter("dateOfBirth"));
		String email = request.getParameter("email");
		String mobileNumber = request.getParameter("mobileNumber");
		String organization = request.getParameter("companyName");
		String password = request.getParameter("password");
		User user = new User(null, firstName, lastName, mobileNumber, birthDate, organization, email, password, null);
		int rowsAffected;
		
		try{
			rowsAffected = dbOperation.addUser(user);
		}catch(SQLException exception){
			exception.printStackTrace();
			out.println("Invalid Input");
			return;
		}
		
		if(rowsAffected == 1){	
			try{
				user = dbOperation.fetchUserByEmail(email);
			}catch(SQLException exception){
				exception.printStackTrace();
				out.println("Invalid Input");
				return;
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("userDetail", user);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/profilePage");
			requestDispatcher.forward(request, response);
		}else{
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/signUp");
			requestDispatcher.forward(request, response);
		}
	}
}

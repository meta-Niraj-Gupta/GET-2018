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
import javax.websocket.SendResult;

import com.doa.DatabaseOperation;
import com.pojo.User;

@WebServlet("/validateLogin")
public class ValidateLoginPage extends HttpServlet{
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
		
		String userName = request.getParameter("loginEmail").trim();
		String userPassword = request.getParameter("loginPassword").trim();
		User user = null;
		
		try{
			user = dbOperation.fetchUserEmailPassword(userName, userPassword);
		}catch(SQLException exception){
			exception.printStackTrace();
			out.println("Invalid Input");
			return;
		}
		
		if(user != null){
			HttpSession session = request.getSession();
			session.setAttribute("userDetail", user);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/profilePage");
			requestDispatcher.forward(request, response);
		}else{
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.html");
			requestDispatcher.forward(request, response);
		}
	}
}

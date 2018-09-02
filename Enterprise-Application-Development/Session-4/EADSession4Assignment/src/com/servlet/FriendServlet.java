package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.doa.DatabaseOperation;
import com.pojo.User;

@WebServlet("/friends")
public class FriendServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
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

		
		out.println("<!DOCTYPE html>"); 
		out.println("<html>"); 
		out.print("\t<head>"); 
		out.println("\t\t<title>Friend List</title>"); 
		out.println("\t\t<style> \n\t\t\t a { text-decoration : none} \n\t\t </style>");
		out.println("\t</head>"); 
		out.println("\t<body>"); 
		out.println("\t\t<table>");
		out.println("\t\t\t<tr>");
		out.println("\t\t\t<th>First Name</th>");
		out.println("\t\t\t<th>Last Name</th>");
		out.println("\t\t\t<th>Mobile Number</th>");
		out.println("\t\t\t<th>Organization</th>");
		out.println("\t\t\t<th>Birth Date</th>");
		out.println("\t\t\t<th>Email</th>");
		out.println("\t\t</tr>");

		HttpSession session = request.getSession();
		User userDetail = (User) session.getAttribute("userDetail");
		String organization = userDetail.getOrganization();
		String email = userDetail.getEmail();
		
		List<User> users = new ArrayList<>();
		try{
			users = dbOperation.getFriendList(organization, email);
		}catch(SQLException exception){
			exception.printStackTrace();
			out.println("Unable to fetch Employee detail. Try again later.");
			return;
		}
		
		for(User user : users){
			out.println("\t\t<tr>");
			out.println("\t\t\t<td>" + user.getFirstName() + "</td>");
			out.println("\t\t\t<td>" + user.getFirstName() + "</td>");
			out.println("\t\t\t<td>" + user.getLastName() + "</td>");
			out.println("\t\t\t<td>" + user.getMobileNumber() + "</td>");
			out.println("\t\t\t<td>" + user.getOrganization() + "</td>");
			out.println("\t\t\t<td>" + user.getBirthDate() + "</td>");
			out.println("\t\t\t<td>" + user.getEmail() + "</td>");
			out.println("\t\t\t<td> <a href='ProfilePage?friendEmail=" + user.getEmail() + "'>View Profile</a>");
			out.println("\t\t</tr>");
		}

		out.println("\t\t</table>");
		out.println("\t</body>");
		out.println("</html>");
		
		out.println("<form action = 'profilePage' method = 'post'>"
				+ "\n<input type = 'submit' value = 'Go to profile page' /> </form>");
	}

}

package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.coyote.http11.Http11Processor;

import com.doa.DatabaseOperation;
import com.pojo.User;

@WebServlet("/ProfilePage")
public class ViewOthersProfile extends HttpServlet{
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
		
		HttpSession session = request.getSession();
		User userInfo = (User) session.getAttribute("userDetail");
		String friendEmail = request.getParameter("friendEmail");
		
		User friend = null;
		try{
			friend = dbOperation.fetchUserByEmail(friendEmail);
		}catch(SQLException exception){
			exception.printStackTrace();
			out.println("Cannot Fetch " + friend.getFirstName() + " " + friend.getLastName() 
				+ " Pofile at this moment. Try again later.");
		}
		
		out.println("<!DOCTYPE html><html>"
				+ "\n<head>\n<title>Profile Page</title>\n<style>\n a { text-decoration : none}</style>\n</head>"
				+ "\n<body>\n<table width = '100%'>\n<tr>"
                + "\n<td width = '60%'> <img src = 'logo.png' width = '50px'/> </td>"
                + "\n<td align = 'right' width = '10%'> <a href = 'friends'>Friends</a></td>"
                + "\n<td align = 'right' width = '5%'>Welcome</td>"
                + "\n<td align = 'center' width = '5%'> <img src = 'defaultProfilePic.jpg' name = 'profilePic' width = '50px'/> </td>"
                + "\n<td align = 'right' width = '10%'>" + userInfo.getFirstName() + " " + userInfo.getLastName() + "</td>"
                + "\n<td align = 'right' width = '10%'> <a href = 'login.html' >Logout</a> </td>\n</tr>\n</table>\n</body>\n</html>");
		
		out.println("<form action = 'profilePage' method = 'post'>\n<table align = 'center' cellspacing = '10px'>\n<tr>"
				+ "\n<td>First Name</td>"
				+ "\n<td>" + friend.getFirstName() + "</td>\n</tr>\n<tr>"
				+ " \n<td>Last Name</td>"
				+ "<td>" + friend.getLastName() + "</td>\n</tr>\n<tr>"
				+ "\n<td>Birth Date</td>"
				+ "\n<td>" + friend.getBirthDate() + "</td>\n</tr>\n<tr>"
				+ "\n<td>Mobile Number</td>"
				+ "\n<td>" + friend.getMobileNumber() + "</td>\n</tr>\n<tr>"
				+ "\n<td>Organization</td>"
				+ "\n<td>" + friend.getOrganization() + "</td>\n</tr><tr>"
				+ "\n<td>Email</td>"
				+ "\n<td>" + friend.getEmail() + "</td>\n</tr><tr>"
				+ "\n<td colspan = '2' align = 'center'> <input type = 'submit' value = 'Go Back To Profile Page' /> </td></table></form>");
	}
}

package com.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Blob;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pojo.User;

@WebServlet("/profilePage")
public class ProfilePageServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
        User userInfo = (User) session.getAttribute("userDetail");
        
        
		out.println("<!DOCTYPE html><html>"
				+ "\n<head>\n<title>Profile Page</title>\n<style>\n a { text-decoration : none}</style>\n</head>"
				+ "\n<body>\n<table width = '100%'>\n<tr>"
                + "\n<td width = '60%'> <img src = 'logo.png' width = '50px'/> </td>"
                + "\n<td align = 'right' width = '10%'> <a href = 'friends'>Friends</a></td>"
                + "\n<td align = 'right' width = '5%'>Welcome</td>"
                + "\n<td align = 'center' width = '5%'> <a href = 'uploadImage.html'> <img src = '/image' name = 'profilePic' width = '50px'/> </a> </td>"
                + "\n<td align = 'right' width = '10%'>" + userInfo.getFirstName() + " " + userInfo.getLastName() + "</td>"
                + "\n<td align = 'right' width = '10%'> <a href = 'login.html' >Logout</a> </td>\n</tr>\n</table>\n</body>\n</html>");
		
		out.println("<form action = 'editUserDetail' method = 'post'>\n<table align = 'center' cellspacing = '10px'>\n<tr>"
				+ "\n<td>First Name</td>"
				+ "\n<td>" + userInfo.getFirstName() + "</td>\n</tr>\n<tr>"
				+ " \n<td>Last Name</td>"
				+ "<td>" + userInfo.getLastName() + "</td>\n</tr>\n<tr>"
				+ "\n<td>Birth Date</td>"
				+ "\n<td>" + userInfo.getBirthDate() + "</td>\n</tr>\n<tr>"
				+ "\n<td>Mobile Number</td>"
				+ "\n<td>" + userInfo.getMobileNumber() + "</td>\n</tr>\n<tr>"
				+ "\n<td>Organization</td>"
				+ "\n<td>" + userInfo.getOrganization() + "</td>\n</tr><tr>"
				+ "\n<td>Email</td>"
				+ "\n<td>" + userInfo.getEmail() + "</td>\n</tr><tr>"
				+ "\n<td colspan = '2' align = 'center'> <input type = 'submit' value = 'Edit' /> </td></table></form>");
	}
}

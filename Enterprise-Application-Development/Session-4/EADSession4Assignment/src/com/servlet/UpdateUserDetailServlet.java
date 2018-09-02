package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.doa.DatabaseOperation;
import com.pojo.User;

@WebServlet("/editUserDetail")
public class UpdateUserDetailServlet extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		User userDetail = (User) session.getAttribute("userDetail");
		
		out.println("<!DOCTYPE html><html>"
				+ "\n<head>\n<title>Profile Page</title>\n<style>\n a { text-decoration : none}</style>\n</head>"
				+ "\n<body>\n<table width = '100%'>\n<tr>"
                + "\n<td width = '60%'> <img src = 'logo.png' width = '50px'/> </td>"
                + "\n<td align = 'right' width = '10%'> <a href = 'friendServlet'>Friends</a></td>"
                + "\n<td align = 'right' width = '5%'>Welcome</td>"
                + "\n<td align = 'center' width = '5%'> <img src = 'defaultProfilePic.jpg' name = 'profilePic' width = '50px'/> </td>"
                + "\n<td align = 'right' width = '10%'>" + userDetail.getFirstName() + " " + userDetail.getLastName() + "</td>"
                + "\n<td align = 'right' width = '10%'> <a href = 'login.html' >Logout</a> </td>\n</tr>\n</table>\n</body>\n</html>");
		
		out.println("<form action = 'editUser' method = 'post'>\n<table align = 'center'>\n<tr>"
                    + "\n<td>First Name</td>"
                    + "\n<td> <input type = 'text' name = 'firstname' value = '" + userDetail.getFirstName() + "' /> </td>\n</tr>\n<tr>"
                    + "\n<td>Last Name</td>"
                    + "\n<td> <input type = 'text' name = 'lastname' value = '" + userDetail.getLastName() + "' /></td>\n</tr>\n<tr>"
                    + "\n<td>Birth Date</td>"
                    + "\n<td> <input type = 'date' name = 'birthdate' value = '" + userDetail.getBirthDate() + "' /></td>\n</tr>\n<tr>"
                    + "\n<td>Mobile Number</td>"
                    + "\n<td> <input type = 'text' name = 'mobilenumber' value = '" + userDetail.getMobileNumber() + "' /></td>\n</tr>\n<tr>"
                    + "\n<td>Organization</td>"
                    + "\n<td> <select name = 'organization' required>\n<option> Appcino </option>\n<option> Infosys </option>"
                                + "\n<option> Metacube Software </option>\n<option> Mindtree </option>\n<option> TCS </option>"
                            +"\n</select> </td>\n</tr>\n<tr>"
                    + "\n<td>Email</td>"
                    + "\n<td> <input type = 'email' name = 'email' value = '" + userDetail.getEmail() + "' /></td>\n</tr>\n<tr>"
                    + "\n<td>Enter new Password</td>"
                    + "\n<td> <input type = 'password' name = 'newPassword'/></td>\n</tr><tr>"
                    + "<td> <input type = 'submit' value = 'update' /></td>\n</tr>\n</table>\n</form>");
	}

}

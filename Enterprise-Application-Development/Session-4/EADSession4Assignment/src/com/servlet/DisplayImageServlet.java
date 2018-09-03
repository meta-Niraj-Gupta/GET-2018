package com.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pojo.User;

@WebServlet("/image")
public class DisplayImageServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		HttpSession session = request.getSession();
        User user = (User) session.getAttribute("userDetail");
        System.out.println("in image sevlet");
		byte[] image = null;
		try{
			image = user.getImage().getBytes(1, (int) user.getImage().length());
		}catch(SQLException e){}
		
		response.setContentType("image/gif");
		OutputStream output = response.getOutputStream();
		output.write(image);
	}
}

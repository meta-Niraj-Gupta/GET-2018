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

@WebServlet("/editImage")
public class EditImageServlet extends HttpServlet {
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
		User user = (User) session.getAttribute("userDetail");
		
		String filePath = "C:/Users/Brothers/Downloads/" + request.getParameter("image");
		
		int rowsAffected = 0;
		try{
			rowsAffected = dbOperation.updateImage(filePath, user.getId());
		}catch(SQLException exception){
			exception.printStackTrace();
			out.println("Invalid Update data. Please check and try again later.");
			return;
		}
	}
}

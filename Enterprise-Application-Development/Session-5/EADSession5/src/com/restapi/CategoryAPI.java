package com.restapi;

import java.io.IOException;
import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dao.CategoryDAO;
import com.pojo.Category;
import com.resources.ConvertingObjectToJSON;

@Path("/category")
public class CategoryAPI{
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCategories() throws IOException{
		Response response;
		try{
			CategoryDAO categoryDAO = new CategoryDAO();
			response = Response.ok(ConvertingObjectToJSON.toJSON(categoryDAO.getAllCategory()), MediaType.APPLICATION_JSON_TYPE).build();
		}catch(ClassNotFoundException exception){
			exception.printStackTrace();
			response = Response.status(500).entity(ConvertingObjectToJSON.message("SERVER ERROR", "There was an error on the server and the request could not be completed.")).build();
			return response;
		}catch(SQLException exception){
			exception.printStackTrace();
			response = Response.status(500).entity(ConvertingObjectToJSON.message("DATABASE ERROR", "The server is unavailable to handle this request right now.")).build();
			return response;
		}
		return response;
	}

	@GET
	@Path("{categoryid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCategory(@PathParam("id") int id) throws IOException {
		Response response;
		Category category = null;
		try{
			CategoryDAO categoryDAO = new CategoryDAO();
			category = categoryDAO.getCategoryById(id);
		}catch (ClassNotFoundException exception){
			exception.printStackTrace();
			response = Response.status(500).entity(ConvertingObjectToJSON.message("SERVER ERROR", "There was an error on the server and the request could not be completed.")).build();
			return response;
		}catch (SQLException exception){
			exception.printStackTrace();
			response = Response.status(500).entity(ConvertingObjectToJSON.message("DATABASE ERROR", "The server is unavailable to handle this request right now.")).build();
			return response;
		}
		if(category == null){
			response = Response.status(404).entity(ConvertingObjectToJSON.message("INVALID ID", " The requested resource was not found.")).build();
		}else{
			response = Response.ok(ConvertingObjectToJSON.toJSON(category), MediaType.APPLICATION_JSON_TYPE).build();
		}
		return response;
	}

	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addCategory(Category category) throws IOException{
		Response response;
		try{
			CategoryDAO categoryDAO = new CategoryDAO();
			categoryDAO.addCategory(category);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			response = Response.status(500).entity(ConvertingObjectToJSON.message("SERVER ERROR", "There was an error on the server and the request could not be completed.")).build();
			return response;
		}catch(SQLException e){
			e.printStackTrace();
			response = Response.status(500).entity(ConvertingObjectToJSON.message("DATABASE ERROR", "The server is unavailable to handle this request right now.")).build();
			return response;
		}
		response = Response.status(200).build();
		return response;
	}

	@PUT
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response setName(Category category) throws IOException{
		Response response;
		try{
			CategoryDAO categoryDAO = new CategoryDAO();
			if(categoryDAO.updateCategoryName(category.getId(), category.getCategoryName())){
				response = Response.status(200).build();
			}else{
				response = Response.status(404).entity(ConvertingObjectToJSON.message("INVALID CATEGORY ID", "The requested resource was not found.")).build();
			}
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			response = Response.status(500).entity(ConvertingObjectToJSON.message("SERVER ERROR", "There was an error on the server and the request could not be completed.")).build();
			return response;
		}catch(SQLException e){
			e.printStackTrace();
			response = Response.status(500).entity(ConvertingObjectToJSON.message("DATABASE ERROR", "The server is unavailable to handle this request right now.")).build();
			return response;
		}
		return response;
	}
}

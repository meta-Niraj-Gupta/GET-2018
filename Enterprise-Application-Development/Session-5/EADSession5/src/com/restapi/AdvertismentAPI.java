package com.restapi;

import java.io.IOException;
import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dao.AdvertismentDAO;
import com.dao.CategoryDAO;
import com.pojo.Advetisment;
import com.pojo.Category;
import com.pojo.CategoryAndAdvertisment;
import com.resources.ConvertingObjectToJSON;

@Path("/advertisement")
public class AdvertismentAPI{
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAdvertisements() throws IOException{
		Response response;
		AdvertismentDAO advertisementDAO;
		try{
			advertisementDAO = new AdvertismentDAO();
			response = Response.ok(ConvertingObjectToJSON.toJSON(advertisementDAO.getAll()), MediaType.APPLICATION_JSON_TYPE).build();
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
	public Response getAdvertisementsByCategoryId(@PathParam("id") int id) throws IOException, SQLException{
		Response response;
		AdvertismentDAO advertisementDAO = null;
		CategoryDAO categoryDAO = null;
		try{
			advertisementDAO = new AdvertismentDAO();
			categoryDAO = new CategoryDAO();
		}catch(ClassNotFoundException exception){
			exception.printStackTrace();
			response = Response.status(500).entity(ConvertingObjectToJSON.message("SERVER ERROR", "There was an error on the server and the request could not be completed.")).build();
			return response;
		}
		Category category = null;
		try{
			category = categoryDAO.getCategoryById(id);
		}catch(SQLException exception){
			exception.printStackTrace();
			response = Response.status(500).entity(ConvertingObjectToJSON.message("DATABASE ERROR", "The server is unavailable to handle this request right now.")).build();
			return response;
		}

		if(category == null){
			response = Response.status(404).entity(ConvertingObjectToJSON.message("INVALID CATEGORY ID", "The requested resource was not found.")).build();
		}else{
			CategoryAndAdvertisment categoryAd = new CategoryAndAdvertisment();
			categoryAd.setCategoryId(category.getId());
			categoryAd.setCategoryName(category.getCategoryName());
			try {
				categoryAd.setAdvList(advertisementDAO.getAllAdvertisment(id));
			}catch(SQLException e){
				e.printStackTrace();
				response = Response.status(500).entity(ConvertingObjectToJSON.message("DATABASE ERROR", "The server is unavailable to handle this request right now.")).build();
				return response;
			}
			response = Response.ok(ConvertingObjectToJSON.toJSON(categoryAd), MediaType.APPLICATION_JSON).build();
		}
		return response;
	}

	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addAdvertisement(Advetisment advertisement) throws IOException{
		Response response;
		AdvertismentDAO advertisementDAO = null;
		try{
			advertisementDAO = new AdvertismentDAO();
		}catch(ClassNotFoundException exception){
			exception.printStackTrace();
			response = Response.status(500).entity(ConvertingObjectToJSON.message("SERVER ERROR", "There was an error on the server and the request could not be completed.")).build();
			return response;
		}catch(SQLException exception){
			exception.printStackTrace();
			response = Response.status(500).entity(ConvertingObjectToJSON.message("DATABASE ERROR", "The server is unavailable to handle this request right now.")).build();
			return response;
		}

		if(advertisement.getCategoryId() <= 0){
			response = Response.status(400).entity(ConvertingObjectToJSON.message("INVALID CATEGORY ID", "The requested resource was not found.")).build();
		}else{
			try{
				advertisementDAO.addAdvertisment(advertisement);
			}catch(SQLException exception){
				exception.printStackTrace();
				response = Response.status(500).entity(ConvertingObjectToJSON.message("DATABASE ERROR", "The server is unavailable to handle this request right now.")).build();
				return response;
			}
			response = Response.status(200).build();
		}
		return response;
	}

	@PUT
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response setTitle(Advetisment advertisement) throws IOException{
		Response response;
		AdvertismentDAO advertisementDAO;
		try{
			advertisementDAO = new AdvertismentDAO();
			advertisementDAO.updateAdvertismentTitle(advertisement.getId(), advertisement.getAdvetismentTitle());
		}catch(ClassNotFoundException exception){
			exception.printStackTrace();
			response = Response.status(500).entity(ConvertingObjectToJSON.message("SERVER ERROR", "There was an error on the server and the request could not be completed.")).build();
			return response;
		}catch(SQLException exception){
			exception.printStackTrace();
			response = Response.status(500).entity(ConvertingObjectToJSON.message("DATABASE ERROR", "The server is unavailable to handle this request right now.")).build();
			return response;
		}
		response = Response.status(200).build();
		return response;
	}

	@DELETE
	@Path("remove/{advertismentid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response removeAdvertisement(@PathParam("id") int id) throws IOException{
		Response response;
		AdvertismentDAO advertisementDAO;
		try{
			advertisementDAO = new AdvertismentDAO();
			if (advertisementDAO.removeAdvertisment(id))
				response = Response.status(200).build();
			else
				response = Response.status(404).entity(ConvertingObjectToJSON.message("INVALID ADVERTISEMENT ID", "The requested resource was not found.")).build();
		}catch(ClassNotFoundException exception){
			exception.printStackTrace();
			response = Response.status(500).entity(ConvertingObjectToJSON.message("SERVER ERROR", "There was an error on the server and the request could not be completed.")).build();
		}catch(SQLException exception){
			exception.printStackTrace();
			response = Response.status(500).entity(ConvertingObjectToJSON.message("DATABASE ERROR", "The server is unavailable to handle this request right now.")).build();
		}
		return response;
	}
}

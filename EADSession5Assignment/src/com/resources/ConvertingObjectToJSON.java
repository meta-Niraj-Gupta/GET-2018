package com.resources;

import java.io.IOException;
import org.codehaus.jackson.map.ObjectMapper;

public class ConvertingObjectToJSON{
	public static String toJSON(Object object) throws IOException{
		return (new ObjectMapper()).writeValueAsString(object);
	}

	public static String message(String message, String description) throws IOException{
		return (new ObjectMapper()).writeValueAsString(new Status(message, description));
	}
}

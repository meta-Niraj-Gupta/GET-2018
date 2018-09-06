package com.metacube.training.map;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

public class Triangle {
	private Map<String, Point> points;

	public Map<String, Point> getPoints() {
		return points;
	}
	
	@Autowired
	public void setPoints(Map<String, Point> points) {
		this.points = points;
	}
	
	public void draw() {
		for(Map.Entry<String,Point> entry : points.entrySet()) {
			System.out.println(entry.getKey() + " = (" + entry.getValue().getX() + ", " + entry.getValue().getY() + ")");
		}
	}
}

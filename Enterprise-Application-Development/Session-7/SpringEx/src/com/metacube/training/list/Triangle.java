package com.metacube.training.list;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class Triangle {
	@Autowired
	private List<Point> points;

	public List<Point> getPoints() {
		return points;
	}
	
	public void setPoints(List<Point> points) {
		this.points = points;
	}

	public void draw() {
		for (Point point : points) {
			System.out.println("Point = (" + point.getX() + ", "
					+ point.getY() + ")");
		}
	}
}

package com.metacube.training.set;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

public class Triangle {
	private Set<Point> points;

	public Set<Point> getPoints() {
		return points;
	}
	
	@Autowired
	public void setPoints(Set<Point> points) {
		this.points = points;
	}

	public void draw() {
		for (Point point : points) {
			System.out.println("Point = (" + point.getX() + ", " + point.getY() + ")");
		}
	}
}

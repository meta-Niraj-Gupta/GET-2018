package Graphics;

import java.util.Date;

public class Rectangle implements Shapes{
	private Date timeStamp;
    private Point origin;
    private double length, breadth, originDistance;

    public Rectangle(Point origin, double length, double breadth){
        this.origin = origin;
        this.length = length;
        this.breadth = breadth;
        this.originDistance = Math.sqrt(Math.pow(origin.getX(), 2) + Math.pow(origin.getY(), 2));
    }
    
    public Point getPoint(){
        return origin;
    }

    public double getLength(){
        return length;
    }

    public double getBreadth(){
        return breadth;
    }
    
	public double getArea(){
		return length * breadth;
	}

	public double getPerimeter(){
		return 2 * (length + breadth);
	}

	public Point getOrigin(){
		return origin;
	}

	public boolean isPointEnclosed(Point point){
		return point.getX() >= origin.getX() && point.getX() <= length + origin.getX() 
						&& point.getY() >= origin.getY() && point.getY() <= breadth+origin.getY();
	}

	public ShapeType getShapeType(){
		return ShapeType.RECTANGLE;
	}

	public double getOriginDistance(){
		return originDistance;
	}

	public Date getTimestamp(){
		return timeStamp;
	}

	@Override
	public void setTimestamp(Date timestamp){
		this.timeStamp = timestamp;
	}

}

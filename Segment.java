import java.awt.*;

/**
 * Segment.java
 * Class for a line segment.
 * 
 * Written by THC for CS 5 Lab Assignment 3.
 *
 * @author Thomas H. Cormen
 * @see Shape
 */
public class Segment extends Shape {
	private Point firstPoint, secondPoint;
	
	public Segment(Color c, Point first) {
		super(c);
		secondPoint = new Point();
		firstPoint = first;
		secondPoint.x = firstPoint.x;
		secondPoint.y = firstPoint.y;
	}
	
	public Segment(Color c, Point first, Point second){
		super(c);
		firstPoint = first;
		secondPoint = second;
	}
	
	public Point findTopLeft(){
		if(secondPoint.y < firstPoint.y && secondPoint.x < firstPoint.x){
			return secondPoint;
		}
		else if(secondPoint.y > firstPoint.y && secondPoint.x < firstPoint.x){
			Point p = new Point(secondPoint.x,firstPoint.y);
			return p;
		}
		else if(secondPoint.y < firstPoint.y && secondPoint.x > firstPoint.x){
			Point p = new Point(firstPoint.x,secondPoint.y);
			return p;
		}
		else{
			return firstPoint;
		}
	}
	
	public int findHeight(){
		return Math.abs(secondPoint.y-firstPoint.y);
	}
	
	public int findWidth(){
		return Math.abs(secondPoint.x-firstPoint.x);
	}

	// Helper method that returns true if Point p is within a tolerance of a
	// given bounding box. Here, the bounding box is given by the coordinates of
	// its left, top, right, and bottom.
	private static boolean almostContainsPoint(Point p, int left, int top,
			int right, int bottom, double tolerance) {
		return p.x >= left - tolerance && p.y >= top - tolerance
				&& p.x <= right + tolerance && p.y <= bottom + tolerance;
	}

	// Helper method that returns the distance from Point p to the line
	// containing a line segment whose endpoints are given.
	private static double distanceToPoint(Point p, int x1, int y1, int x2,
			int y2) {
		if (x1 == x2) // vertical segment?
			return (double) (Math.abs(p.x - x1)); // yes, use horizontal distance
		else if (y1 == y2) // horizontal segment?
			return (double) (Math.abs(p.y - y1)); // yes, use vertical distance
		else {
			// Here, we know that the segment is neither vertical nor
			// horizontal.
			// Compute m, the slope of the line containing the segment.
			double m = ((double) (y1 - y2)) / ((double) (x1 - x2));

			// Compute mperp, the slope of the line perpendicular to the
			// segment.
			double mperp = -1.0 / m;

			// Compute the (x, y) intersection of the line containing the
			// segment and the line that is perpendicular to the segment and that
			// contains Point p.
			double x = (((double) y1) - ((double) p.y) - (m * x1) + (mperp * p.x))
					/ (mperp - m);
			double y = m * (x - x1) + y1;

			// Return the distance between Point p and (x, y).
			return Math.sqrt(Math.pow(p.x - x, 2) + Math.pow(p.y - y, 2));
		}
	}

	public void drawShape(Graphics page) {
		page.drawLine(firstPoint.x, firstPoint.y, secondPoint.x, secondPoint.y);
	}


	public boolean containsPoint(Point p) {
		double tolerance = 3;
		Point topLeft = findTopLeft();
		if (Segment.distanceToPoint(p, firstPoint.x,firstPoint.y, secondPoint.x,secondPoint.y)<tolerance &&
			Segment.almostContainsPoint(p, topLeft.x, topLeft.y, topLeft.x+findWidth(), topLeft.y+findHeight(), tolerance)){
			return true;
		}
		else{
			return false;
		}
	}

	
	public void move(int deltaX, int deltaY) {
		firstPoint.x+=deltaX;
		firstPoint.y+=deltaY;
		secondPoint.x+=deltaX;
		secondPoint.y+=deltaY;
	}

	
	public Point getCenter() {
		int x = findTopLeft().x+(findWidth()/2);
		int y = findTopLeft().y+(findHeight()/2);
		Point center = new Point(x,y);
		return center;
	}
	
	public void updateSize(Point p){
		secondPoint = p;
	}
}

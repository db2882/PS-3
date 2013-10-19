import java.awt.*;

/**
 * Ellipse.java
 * Class for an ellipse.
 * 
 * Written by THC for CS 5 Lab Assignment 3.
 *
 * @author Thomas H. Cormen 
 * @see Shape
 */
public class Ellipse extends Shape {
	private Point firstPoint, secondPoint;

	public Ellipse(Color c,int fX, int fY, int sX, int sY) {
		super(c);
		firstPoint = new Point(fX,fY);
		firstPoint.x = fX;
		firstPoint.y = fY;
		secondPoint.x = sX;
		secondPoint.y= sY;
	}
	
	public Ellipse(Color c,Point first) {
		super(c);
		firstPoint = first;
		secondPoint = new Point(firstPoint.x,firstPoint.y);
		
	}
	
	public Ellipse(Color c, Point first, Point second){
		super(c);
		firstPoint = first;
		secondPoint = second;
	}
	
	public int findHeight(){
		return Math.abs(secondPoint.y-firstPoint.y);
	}
	
	public int findWidth(){
		return Math.abs(secondPoint.x-firstPoint.x);
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

	// Helper method that returns whether Point p is in an Ellipse with the given
	// top left corner and size.
	private static boolean pointInEllipse(Point p, int left, int top, int width,
			int height) {
		double a = width / 2.0; // half of the width
		double b = height / 2.0; // half of the height
		double centerx = left + a; // x-coord of the center
		double centery = top + b; // y-coord of the center
		double x = p.x - centerx; // horizontal distance between p and center
		double y = p.y - centery; // vertical distance between p and center

		// Now we just apply the standard geometry formula.
		// (See CRC, 29th edition, p. 178.)
		return Math.pow(x / a, 2) + Math.pow(y / b, 2) <= 1;
	}


	public void drawShape(Graphics page) {
		Point topLeft = findTopLeft();
		page.fillOval(topLeft.x, topLeft.y, findWidth(), findHeight());
	}
	
	public void updateSize(Point p){
		secondPoint = p;
	}


	public boolean containsPoint(Point p) {
		return Ellipse.pointInEllipse(p, firstPoint.x, firstPoint.y, findWidth(), findHeight());
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
	public Shape clone() {
		Point f = new Point(firstPoint.x,firstPoint.y);
		Point s = new Point(secondPoint.x,secondPoint.y);
		Shape newSeg = new Ellipse(super.getColor(),f,s);
		return newSeg;
	}
	
}

import java.awt.*;

/**
 * Rect.java
 * Class for a rectangle.
 *
 * @author Patrick Xu 
 * @see Shape
 */
public class Rect extends Shape{
	private Point firstPoint, secondPoint;
	public Rect(Color c, Point first){
		super(c);
		firstPoint=first;
		secondPoint=new Point(first.x, first.y);
	}
	public Rect(Color c, Point first, Point second){
		super(c);
		firstPoint=first;
		secondPoint=second;
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

	public void drawShape(Graphics page) {
		Point topLeft=findTopLeft();
		page.fillRect(topLeft.x, topLeft.y, findWidth(), findHeight());
	}
	public void updateSize(Point p){
		secondPoint=p;
	}

	public boolean containsPoint(Point p) {
		Point topLeft=findTopLeft();
		return p.x>topLeft.x && p.x<topLeft.x+findWidth() && p.y>topLeft.y && p.y<topLeft.y+findHeight();
	}

	public void move(int deltaX, int deltaY) {
		firstPoint.x+=deltaX;
		firstPoint.y+=deltaY;
		secondPoint.x+=deltaX;
		secondPoint.y+=deltaY;
	}

	public Point getCenter() {
		int a = (int) (findWidth()/ 2.0); 
		int b = (int) (findHeight() / 2.0);
		int centerx = (int)firstPoint.x + a; // x-coord of the center
		int centery = (int)firstPoint.y + b;
		Point center = new Point(centerx,centery);
		return center;
	}
	
	public Shape clone() {
		Point f = new Point(firstPoint.x,firstPoint.y);
		Point s = new Point(secondPoint.x,secondPoint.y);
		Shape newSeg = new Rect(super.getColor(),f,s);
		return newSeg;
	}

}


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;


public class Drawing {
	private Color currentColor;
	private ArrayList<Shape> shape;
	
	Drawing(Color color){
		currentColor = color;
		shape = new ArrayList<Shape>();
	}
	
	public void addShape(Shape s){
		shape.add(0, s);
	}
	
	public void draw(Graphics g){
		for(Shape shapes: shape){
			shapes.draw(g);
		}
	}
	
	public ArrayList<Shape> getAllShapes(){
		return shape;
	}
	
	public Color getCurrentColor(){
		return currentColor;
	}
	
	public void setColor(Color color){
		currentColor = color;
	}
	
	public void moveToFront(Shape s){
		
	}
	
	public void moveToBack(Shape s){
		
	}
	
	public Shape getFrontmostContainer(Point p){
		for(Shape shapes:shape){
			if (shapes.containsPoint(p)){
				return shapes;
			}
		}
		return null;
	}
}

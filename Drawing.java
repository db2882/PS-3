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
		shape.add(0,s);
	}

	public void draw(Graphics g){
		if(shape.size()!=0){
			for(int i = shape.size()-1; i >=0; i--){
				shape.get(i).draw(g);
			}
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
		shape.remove(shape.indexOf(s));
		shape.add(0,s);
	}

	public void moveToBack(Shape s){
		shape.remove(shape.indexOf(s));
		shape.add(shape.size()-1,s);
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

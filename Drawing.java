import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;


public class Drawing {
	private Color currentColor;
	private ArrayList<Shape> shape;
	private Stack<ArrayList<Shape>> changes;
	private Stack<ArrayList<Shape>> redo;

	Drawing(Color color){
		currentColor = color;
		shape = new ArrayList<Shape>();
		changes = new Stack<ArrayList<Shape>>();
		redo = new Stack<ArrayList<Shape>>();
	}

	public void makeChange(){
		changes.push(copyList());
	}

	public void undo(){
		try{
			redo.push(shape);
			shape = changes.pop();
		}
		catch (EmptyStackException ex){
			//Do nothing
		}
	}

	public void redo(){
		try{
			makeChange();
			shape = redo.pop();
		
		}
		catch (EmptyStackException ex){
			shape = changes.pop();
		}
	}
	private ArrayList<Shape> copyList(){
		ArrayList<Shape> copy = new ArrayList<Shape>();
		for(Shape s : shape) {
			copy.add(s.clone());
		}
		return copy;
	}

	public void addShape(Shape s){
		makeChange();
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
		makeChange();
		shape.remove(shape.indexOf(s));
		shape.add(0,s);
	}
	public void moveToBack(Shape s){
		makeChange();
		shape.remove(shape.indexOf(s));
		shape.add(s);
	}

	public void delete(Shape s){
		makeChange();
		shape.remove(shape.indexOf(s));
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

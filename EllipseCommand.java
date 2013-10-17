import java.awt.Point;


public class EllipseCommand extends Command {
	private Ellipse currentEllipse;
	private Point startPoint;
	
	public void executePress(Point p, Drawing dwg) { 
		startPoint = p;
		currentEllipse = new Ellipse(dwg.getCurrentColor(),p);
		
	}

	public void executeDrag(Point p, Drawing dwg) {
		currentEllipse.updateSize(p);
		dwg.addShape(currentEllipse);
	}
	
	
}

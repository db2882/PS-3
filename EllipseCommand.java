import java.awt.Point;


public class EllipseCommand extends Command {
	private Ellipse currentEllipse;
	
	public void executePress(Point p, Drawing dwg) { 
		currentEllipse = new Ellipse(dwg.getCurrentColor(),p);
		dwg.addShape(currentEllipse);
		
	}

	public void executeDrag(Point p, Drawing dwg) {
		currentEllipse.updateSize(p);
	}
}

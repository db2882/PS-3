import java.awt.Point;


public class SegmentCommand extends Command {
	private Segment currentSegment;
	
	public void executePress(Point p, Drawing dwg) { 
		currentSegment = new Segment(dwg.getCurrentColor(),p);
		dwg.addShape(currentSegment);
		
	}

	public void executeDrag(Point p, Drawing dwg) {
		currentSegment.updateSize(p);
	}
}

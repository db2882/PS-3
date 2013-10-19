import java.awt.*;

public class MoveCommand extends Command{
	private Point firstPoint;
	private Point originalCenter;
	private Point newCenter;
	private Shape s;

	//doesn't work for line
	public void executePress(Point p, Drawing dwg){
		dwg.makeChange();
		s=dwg.getFrontmostContainer(p);
		if (s!=null){
			if (s.containsPoint(p)){
				firstPoint=p;
				originalCenter=dwg.getFrontmostContainer(p).getCenter();
			}
		}
	}

	public void executeDrag(Point p, Drawing dwg){
		if (s!=null){
			newCenter=s.getCenter();
			s.move(deltaX(firstPoint, p)-deltaX(originalCenter, newCenter),
					deltaY(firstPoint, p)-deltaY(originalCenter, newCenter));
		}
	}


	private int deltaX(Point a, Point b){
		return b.x-a.x;
	}

	private int deltaY(Point a, Point b){
		return b.y-a.y;
	}

}

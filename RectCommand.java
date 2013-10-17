import java.awt.*;

public class RectCommand extends Command{
	private Rect currentRect;

	public void executePress(Point p, Drawing dwg){
		currentRect=new Rect(dwg.getCurrentColor(),p);
		dwg.addShape(currentRect);
	}
	public void executeDrag(Point p, Drawing dwg){
		currentRect.updateSize(p);
	}

}

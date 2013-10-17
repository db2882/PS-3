import java.awt.Color;
import java.awt.Point;


public class GreenCommand extends Command {
	public void executeClick(Point p, Drawing dwg) { 
		if(dwg.getFrontmostContainer(p)!=null){
			dwg.getFrontmostContainer(p).setColor(Color.green);
		}
	}
}

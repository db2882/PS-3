import java.awt.Color;
import java.awt.Point;


public class RedCommand extends Command {
	public void executeClick(Point p, Drawing dwg) { 
		if(dwg.getFrontmostContainer(p)!=null){
			dwg.makeChange();
			dwg.getFrontmostContainer(p).setColor(Color.red);
		}
	}
}

import java.awt.Point;


public class FrontCommand extends Command {
	public void executeClick(Point p, Drawing dwg){
		if(dwg.getFrontmostContainer(p)!=null){
			dwg.moveToFront(dwg.getFrontmostContainer(p));
		}
	}
}

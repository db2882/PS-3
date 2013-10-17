import java.awt.Point;


public class BackCommand extends Command {
	public void executeClick(Point p, Drawing dwg){
		dwg.moveToBack(dwg.getFrontmostContainer(p));
	}
}

import java.awt.Point;


public class BackCommand extends Command {
	public void executeClick(Point p, Drawing dwg){
		if(dwg.getFrontmostContainer(p)!=null){
			dwg.moveToBack(dwg.getFrontmostContainer(p));
		}
	}
}

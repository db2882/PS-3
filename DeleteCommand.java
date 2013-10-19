import java.awt.Point;


public class DeleteCommand extends Command {
	public void executeClick(Point p, Drawing dwg){
		if(dwg.getFrontmostContainer(p)!=null){
			dwg.delete(dwg.getFrontmostContainer(p));
		}
	}
}

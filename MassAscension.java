
/*
 * by Phoebe Lu
 * a movingobject of many balloons 
 */
import java.awt.Graphics2D;
import java.util.ArrayList;

public class MassAscension implements MovingObject {

	public MassAscension() {
		windedBalloons = new ArrayList<MovingObject>();
	}

	public void add(MovingObject obj) {
		windedBalloons.add(obj);
	}

	public void draw(Graphics2D g2d) {
		for (MovingObject windedBalloon : windedBalloons) {
			windedBalloon.draw(g2d);
		}

	}

	public void translate(int xChange, int yChange) {
		for (MovingObject windedBalloon : windedBalloons) {
			windedBalloon.translate(xChange, yChange);
		}

	}
  
	private ArrayList<MovingObject> windedBalloons;

}

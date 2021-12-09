
/*
 * a decorator for movingobjects
 */
import java.awt.Graphics2D;

public class JitterObject implements MovingObject {

	public JitterObject(MovingObject object) {
		obj = object;
		// keeps track of moves so it makes sure the object jitters in both directions
		moveRight = true;
	}

	public void draw(Graphics2D g2d) {

		obj.draw(g2d);
	}

	public void translate(int xChange, int yChange) {
		setJitterFactor();

		obj.translate(xChange, yChange);
		// jitters in two different directions
		if (moveRight) {
			obj.translate(jitterFactor, 0);
			moveRight = false;
		} else {
			obj.translate(-jitterFactor, 0);
			moveRight = true;
		}

	}
	private void setJitterFactor() {
		jitterFactor = (int) (Math.random() * 5);
	}

	private Balloon obj;
	private boolean moveRight;
	private int jitterFactor;

}

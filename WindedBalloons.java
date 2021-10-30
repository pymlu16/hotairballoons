
/*
 * by Phoebe Lu
 * a collection of balloons who have the same wind factor
 */
import java.awt.Graphics2D;
import java.util.ArrayList;

public class WindedBalloons implements MovingObject {

	public WindedBalloons() {
		// randomly selects windfactor
		windFactor = (int) (Math.random() * 10);
		balloons = new ArrayList<MovingObject>();
	}

	public void add(MovingObject balloonObj) {
		balloons.add(balloonObj);
	}

	public void draw(Graphics2D g2d) {
		for (MovingObject balloon : balloons) {
			balloon.draw(g2d);
		}

	}

	public void translate(int xChange, int yChange) {
		for (MovingObject balloon : balloons) {
			balloon.translate(windFactor, 0);
			balloon.translate(xChange, yChange);
		}

	}

	private ArrayList<MovingObject> balloons;
	private int windFactor;

}

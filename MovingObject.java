import java.awt.*;

/**
 * 
 * source code from jrk based on cay horstmann
 *
 */
public interface MovingObject {
	void draw(Graphics2D g2D);
	void translate(int xChange, int yChange);
}
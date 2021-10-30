import java.awt.*;
import java.awt.geom.*;

/**
 * edited by Phoebe Lu source code from jrk based on cay horstmann implements
 * the Composite pattern constructs a Hot air balloon
 */
public class Balloon implements MovingObject {

	public Balloon(int x, int y, int unit) {
		this.x = x;
		this.y = y;
		this.unit = unit; // unit is in pixels
	}

	public void translate(int xChange, int yChange) {
		x += xChange;
		y += yChange;
	}

	public void draw(Graphics2D g2D) {

		// basic x symmetry
		int xCenter = x + unit / 2;

		// the upper balloon part
		int headXUpLeft = x;
		int headYUpLeft = y;
		int headSize = unit;
		Ellipse2D.Double head = new Ellipse2D.Double(headXUpLeft, headYUpLeft, headSize, headSize);
		int headYBot = headYUpLeft + unit;

		// control cables, assumed symmetric
		int cableOffset = unit / 2;
		int cableXLTop = xCenter - cableOffset;
		int cableXRTop = xCenter + cableOffset;
		int cableYTop = headYBot - cableOffset;
		int cableXLBot = cableXLTop - (int) (CABLELENGTH * unit * 0.5 * Math.sin(ANGLE));
		int cableXRBot = cableXRTop - (int) (CABLELENGTH * unit * 0.5 * Math.sin(-ANGLE));
		;
		int cableYBot = headYBot + (int) (CABLELENGTH * unit);
		Line2D.Double armL = new Line2D.Double(cableXLTop, cableYTop, cableXLBot, cableYBot);
		Line2D.Double armR = new Line2D.Double(cableXRTop, cableYTop, cableXRBot, cableYBot);

		// gondola
		int gondolaX = cableXLBot;
		int gondolaY = cableYBot;
		Rectangle2D.Double gondola1 = new Rectangle2D.Double(gondolaX, gondolaY, unit / 2, unit / 2); // aggregate body,
																										// cable, legs,
																										// using one
																										// GeneralPath

		GeneralPath cableLines = new GeneralPath();
		cableLines.append(armL, false);
		cableLines.append(armR, false);
		GeneralPath basket = new GeneralPath();
		basket.append(gondola1, false);

		// draw the figure, but fill both the balloon and gondola
		g2D.fill(head);
		g2D.fill(basket);
		g2D.draw(cableLines);

	}

	private int x;
	private int y;
	private int unit;
	private final double CABLELENGTH = 1.0;
	private final double ANGLE = 3.7;

}

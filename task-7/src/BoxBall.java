
import java.util.Random;
import java.awt.*;
import java.awt.geom.*;

/**
 * Class BoxBall
 * @author William Berg
 */

public class BoxBall {
    private Ellipse2D.Double circle;
    private Color color;
    private int diameter;
    private int xPosition;
    private int yPosition;
    private final int groundPosition;
    private final int wall1Position;
    private final int wall2Position;
    private final int roofPosition;
    private Canvas canvas;
    private int ySpeed;
    private int xSpeed;

    /**
     * Constructor for objects of class BoxBall
     *
     * @param xPos  the horizontal coordinate of the ball
     * @param yPos  the vertical coordinate of the ball
     * @param ballDiameter  the diameter (in pixels) of the ball
     * @param ballColor  the color of the ball
     * @param groundPos  the position of the ground (where the wall will bounce)
     * @param drawingCanvas  the canvas to draw this ball on
     */
    public BoxBall(int xPos, int yPos, int ballDiameter, Color ballColor,
                        int groundPos, int wall1Pos, int wall2Pos, int roofPos, Canvas drawingCanvas)
    {
        xPosition = xPos;
        yPosition = yPos;
        color = ballColor;
        diameter = ballDiameter;
        groundPosition = groundPos;
        wall1Position = wall1Pos;
        wall2Position = wall2Pos;
        roofPosition = roofPos;
        canvas = drawingCanvas;
        Random R1 = new Random();
        ySpeed = R1.nextInt(5)+1;
        xSpeed = ySpeed;
    }

    /**
     * Draw this ball at its current position onto the canvas.
     **/
    public void draw() {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
    }

    /**
     * Erase this ball at its current position.
     **/
    public void erase() {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }

    /**
     * Move this ball according to its position and speed and redraw.
     **/
    public void move() {
        erase();
        yPosition += ySpeed;
        xPosition += xSpeed;

        if (yPosition >= (groundPosition - 29)) {
            ySpeed = -ySpeed;
        } else if (yPosition <= (roofPosition+4)) {
            ySpeed = -ySpeed;
        } else if (xPosition >= (wall1Position - 29)) {
            xSpeed = -xSpeed;
        } else if (xPosition <= (wall2Position+4)) {
            xSpeed = -xSpeed;
        }

        draw();
    }

    /**
     * return the horizontal position of this ball
     */
    public int getXPosition() {
        return xPosition;
    }

    /**
     * return the vertical position of this ball
     */
    public int getYPosition() {
        return yPosition;
    }
}

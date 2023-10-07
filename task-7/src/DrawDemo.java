import java.awt.Color;
import java.util.Random;

/**
 * Class DrawDemo - provides some short demonstrations showing how to use the
 * Pen class to create various drawings.
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class DrawDemo {
    private Canvas myCanvas;
    private Random random;

    /**
     * Prepare the drawing demo. Create a fresh canvas and make it visible.
     */
    public DrawDemo() {
        myCanvas = new Canvas("Drawing Demo", 500, 400);
        random = new Random();
    }

    /**
     * draw a green triangle on the screen.
     * exercise 5.57
     */
    public void drawTriangle() {
        Pen pen = new Pen(250, 200, myCanvas);
        pen.setColor(Color.GREEN);
        triangle(pen);
    }

    /**
     * draw a black equilateral pentagon on the screen.
     * exercise 5.58
     */
    public void drawPentagon() {
        Pen pen = new Pen(200, 100, myCanvas);
        for (int i=0; i<5; i++) {
            pen.move(100);
            pen.turn(72);
        }
    }

    /**
     * draw a spiral on the screen.
     * exercise 5.60
     */
    public void spiral() {
        Pen pen = new Pen(260, 200, myCanvas);
        for (int i=0; i<36; i++) {
            pen.move(10+10*i);
            pen.turn(90);
        }
    }

    /**
     * draw a polygon on the screen.
     * exercise 5.59
     */
    public void drawPolygon(int n) {
        Pen pen = new Pen(200, 50, myCanvas);
        for (int i=0; i<n; i++) {
            pen.move(100);
            pen.turn(180-(((180)*(n-2))/n));
       	}
    }

    /**
     * Draw a square on the screen.
     */
    public void drawSquare() {
        Pen pen = new Pen(250, 100, myCanvas);
        pen.setColor(Color.BLUE);
        square(pen);
    }

    /**
     * Draw a wheel made of many squares.
     */
    public void drawWheel() {
        Pen pen = new Pen(250, 200, myCanvas);
        pen.setColor(Color.RED);

        for (int i=0; i<36; i++) {
            square(pen);
            pen.turn(10);
        }
    }

    /**
     * Draw a square in the pen's color at the pen's location.
     * exercise 5.57
     */
    private void triangle(Pen pen) {
        for (int i=0; i<3; i++) {
            pen.move(100);
            pen.turn(120);
        }
    }

    /**
     * Draw a square in the pen's color at the pen's location.
     */
    private void square(Pen pen) {
        for (int i=0; i<4; i++) {
            pen.move(100);
            pen.turn(90);
        }
    }

    /**
     * Draw some random squiggles on the screen, in random colors.
     */
    public void colorScribble() {
        Pen pen = new Pen(250, 200, myCanvas);

        for (int i=0; i<10; i++) {
            // pick a random color
            int red = random.nextInt(256);
            int green = random.nextInt(256);
            int blue = random.nextInt(256);
            pen.setColor(new Color(red, green, blue));

            pen.randomSquiggle();
        }
    }

    /**
     * Clear the screen.
     */
    public void clear() {
		myCanvas.erase();
    }
}

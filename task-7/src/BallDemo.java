import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

/**
 * Class BallDemo - a short demonstration showing animation with the
 * Canvas class.
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class BallDemo {
    private Canvas myCanvas;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo() {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    /**
     * create balls that bounce within a box.
     * exercise 5.65
     */
    public void boxBounce(int n) {
        myCanvas.setVisible(true);
        Random R1 = new Random();
        ArrayList<BoxBall> ballList = new ArrayList<BoxBall>();
        // draw the box
        myCanvas.setForegroundColor(Color.BLACK);
        myCanvas.drawLine(50, 450, 550, 450); //ground
        myCanvas.drawLine(50, 50, 550, 50);
        myCanvas.drawLine(50, 50, 50, 450);
        myCanvas.drawLine(550, 50, 550, 450);
        // create and show the balls
        for (int i=0; i<n; i++) {
			Color randomColor = new Color(R1.nextInt(255), R1.nextInt(255), R1.nextInt(255));
			BoxBall ball = new BoxBall(R1.nextInt(450)+70, R1.nextInt(350)+70, 25, randomColor, 450, 550, 50, 50, myCanvas);
			ball.draw();
			ballList.add(ball);
     	}
		// make them bounce
		boolean finished =  false;
			while (!finished) {
				myCanvas.wait(50);
				for(int i=0; i<n; i++) {
					ballList.get(i).move();
				}
			}
    	}

    /**
     * Simulate bouncing balls
     * exercis 5.62, 5.64
     */
    public void bounce(int n) {
        int ground = 400;   // position of the ground line
        ArrayList<BouncingBall> ballList = new ArrayList<BouncingBall>();
        Random R1 = new Random();
        myCanvas.setVisible(true);
        // draw the ground
        myCanvas.setForegroundColor(Color.BLACK);
        myCanvas.drawLine(50, ground, 550, ground);
        // create and show the balls
        for (int i=0; i<n; i++) {
			BouncingBall ball = new BouncingBall(50+20*i, R1.nextInt(250), 16, Color.BLUE, ground, myCanvas);
			ball.draw();
			ballList.add(ball);
     	}
        // make them bounce
        boolean finished = false;
        while (!finished) {
            myCanvas.wait(50);           // small delay
            for (int i=0; i<n; i++) {
				ballList.get(i).move();
				// stop once ball has travelled a certain distance on x axis
				if (ballList.get(i).getXPosition() >= 550) {
					finished = true;
				}
        	}
     	}
    }
}

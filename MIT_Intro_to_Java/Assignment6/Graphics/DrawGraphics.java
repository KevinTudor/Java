/* 
link: https://ocw.mit.edu/courses/6-092-introduction-to-programming-in-java-january-iap-2010/resources/mit6_092iap10_assn06/

Assignment 6: 
    Explore separating this functionality into two classes. This way, one class can handle moving
any drawable object around the screen, and it can move any kind of object that we define in another class, which sill
simply draw itself on the screen. 
*/

package Assignment6.Graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class DrawGraphics {
    ArrayList<Mover> movers = new ArrayList<Mover>();

    /** Initializes this class for drawing. */
    public DrawGraphics() {
        //Define shapes
        Integer rectangleWidth = SimpleDraw.WIDTH/15;
        Integer rectangleHeight = SimpleDraw.HEIGHT/10;
        Rectangle box = new Rectangle(rectangleWidth, rectangleHeight, Color.RED);
        Oval circle = new Oval(rectangleWidth, rectangleHeight, Color.GREEN);

        //Define bouncing sprites
        movers.add(new Bouncer(100, 170, box));
        movers.get(0).setMovementVector(3, 1);

        movers.add(new Bouncer(170, 100, circle));
        movers.get(1).setMovementVector(1, 3);

        //Define straight moving sprites        
        movers.add(new StraightMover(100, 170, box));
        movers.get(2).setMovementVector(2, 1);

        movers.add(new StraightMover(170, 100, circle));
        movers.get(3).setMovementVector(1, 2);
    }

    /** Draw the contents of the window on surface. */
    public void draw(Graphics surface) {
        for (Mover shape : movers){
            shape.draw(surface);
        }
    }
}

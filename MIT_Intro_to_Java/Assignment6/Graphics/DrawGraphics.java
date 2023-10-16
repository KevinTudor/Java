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

public class DrawGraphics {
    Bouncer movingSprite;

    /** Initializes this class for drawing. */
    public DrawGraphics() {
        Rectangle box = new Rectangle(15, 20, Color.RED);
        movingSprite = new Bouncer(100, 170, box);
        movingSprite.setMovementVector(3, 1);
    }

    /** Draw the contents of the window on surface. */
    public void draw(Graphics surface) {
        movingSprite.draw(surface);
    }
}

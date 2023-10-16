/* 
link: https://ocw.mit.edu/courses/6-092-introduction-to-programming-in-java-january-iap-2010/resources/mit6_092iap10_assn06/

Assignment 6: 
    Explore separating this functionality into two classes. This way, one class can handle moving
any drawable object around the screen, and it can move any kind of object that we define in another class, which sill
simply draw itself on the screen. 
*/

package Assignment6.Graphics;

import java.awt.Graphics;

public interface Sprite {
    /**
     * Draws this sprite on surface, with the coordinate (leftX, topY) as the
     * top left corner.
     */
    void draw(Graphics surface, int leftX, int topY);

    /** Returns the width of the sprite. */
    int getWidth();

    /** Returns the height of the sprite. */
    int getHeight();
}

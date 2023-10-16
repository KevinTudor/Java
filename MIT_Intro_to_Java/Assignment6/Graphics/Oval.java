/* 
link: https://ocw.mit.edu/courses/6-092-introduction-to-programming-in-java-january-iap-2010/resources/mit6_092iap10_assn06/

Assignment 6: 
    Explore separating this functionality into two classes. This way, one class can handle moving
any drawable object around the screen, and it can move any kind of object that we define in another class, which sill
simply draw itself on the screen. 
*/

package Assignment6.Graphics;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Oval implements Sprite {
    private int width;
    private int height;
    private Color color;

    /**
     * Create a box that has dimensions width and height, filled with
     * startColor.
     */
    public Oval(int width, int height, Color color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public void draw(Graphics surface, int x, int y) {
        // Draw the object
        surface.setColor(color);
        surface.fillOval(x, y, width, height);
        surface.setColor(Color.BLACK);
        ((Graphics2D) surface).setStroke(new BasicStroke(3.0f));
        surface.drawOval(x, y, width, height);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}

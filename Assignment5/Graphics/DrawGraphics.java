/* 
link: https://ocw.mit.edu/courses/6-092-introduction-to-programming-in-java-january-iap-2010/resources/mit6_092iap10_assn05/

Assignment 5: 
    Problem set on programming in Java, building software with objects, Java’s built-in graphics, containers, and animation.
*/

package Assignment5.Graphics;

import java.awt.Color;
//import java.awt.Frame;
import java.awt.Graphics;
import java.util.ArrayList;

public class DrawGraphics {
    ArrayList<BouncingBox> boxes;
    
    /** Initializes this class for drawing. */
    public DrawGraphics() {
        boxes = new ArrayList<BouncingBox>();

        boxes.add(new BouncingBox(SimpleDraw.WIDTH/2 - BouncingBox.SIZE, SimpleDraw.HEIGHT/2, Color.RED));
        boxes.get(0).setMovementVector(0, 1);
        boxes.add(new BouncingBox(SimpleDraw.WIDTH/2, SimpleDraw.HEIGHT/2, Color.GREEN));
        boxes.get(1).setMovementVector(1, 2);
        boxes.add(new BouncingBox(SimpleDraw.WIDTH/2 + BouncingBox.SIZE, SimpleDraw.HEIGHT/2, Color.BLUE));
        boxes.get(2).setMovementVector(1, -3);
    }
    
    /** Draw the contents of the window on surface. Called 20 times per second. */
    public void draw(Graphics surface) {
        //Line
        surface.drawLine(0, 0, SimpleDraw.WIDTH, SimpleDraw.HEIGHT);

        //Oval
        Integer ovalWidth = SimpleDraw.WIDTH/10;
        Integer ovalHeight = SimpleDraw.HEIGHT/10;
        surface.drawOval(0, SimpleDraw.HEIGHT-ovalHeight, ovalWidth, ovalHeight);

        //Polygon (Triangle)
        int[] polygonX = {0, SimpleDraw.WIDTH/10, SimpleDraw.WIDTH/5};
        int[] polygonY = {0, SimpleDraw.WIDTH/10, 0};
        surface.drawPolygon(polygonX, polygonY, 3);

        //Arrow
        int[] starX1= {0+SimpleDraw.WIDTH/4, SimpleDraw.WIDTH/20+SimpleDraw.WIDTH/4, SimpleDraw.WIDTH/10+SimpleDraw.WIDTH/4};
        int[] starY1 = {0+SimpleDraw.WIDTH/8, SimpleDraw.WIDTH/20+SimpleDraw.WIDTH/8, 0+SimpleDraw.WIDTH/8};
        surface.drawPolygon(starX1, starY1, 3);
        surface.drawLine(SimpleDraw.WIDTH/20+SimpleDraw.WIDTH/4, SimpleDraw.WIDTH/8, SimpleDraw.WIDTH/20+SimpleDraw.WIDTH/4, SimpleDraw.WIDTH/20);

        for (int i = 0; i < boxes.size(); i++){
            boxes.get(i).draw(surface);
        }
    }
}

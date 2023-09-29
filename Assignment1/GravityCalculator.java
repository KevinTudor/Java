/* 
link: https://ocw.mit.edu/courses/6-092-introduction-to-programming-in-java-january-iap-2010/resources/mit6_092iap10_assn01/

Assignment 1: In this assignment, you will create a program that computes the distance an object will fall in Earth's gravity. 
*/

package Assignment1;
public class GravityCalculator {
    public static void main(String[] arguments) {
        double gravity = -9.81; // Earth's gravity in m/s^2
        double initialVelocity = 0.0;
        double fallingTime = 10.0;
        double initialPosition = 0.0;
        double finalPosition = 0.0;

        finalPosition = 0.5 * (gravity*Math.pow(fallingTime, 2)) + initialVelocity*fallingTime + initialPosition;

        System.out.println("The object's position after " + fallingTime +
        " seconds is " + finalPosition + " m."); 
        // Clone output: The object's position after 10.0 seconds is 0.0 m.
        // Final output: The object's position after 10.0 seconds is -490.5 m.

    }
}
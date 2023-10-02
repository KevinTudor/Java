/* 
link: https://ocw.mit.edu/courses/6-092-introduction-to-programming-in-java-january-iap-2010/9d3abddaa082867e7d77161ff79df692_MIT6_092IAP10_assn03.pdf

Assignment 3: 
    Write a method that takes as input an array of integers and returns the index corresponding to the person with the lowest
time. Run this method on the array of times. Print out the name and time corresponding to the returned index.

    Write a second method to find the second-best runner. The second method should use the first method to determine the
best runner, and then loop through all values to find the second-best (second lowest) time. 
*/

package Assignment3;

//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.List;

public class Marathon {
    public static void main(String[] args) {
        String[] names = {
            "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex",
            "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda",
            "Aaron", "Kate"
        };
        int[] times = {
            341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299,
            343, 317, 265
        };
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i] + ": " + times[i]);
        }
    }
}
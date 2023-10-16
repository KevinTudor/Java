/* 
link: https://ocw.mit.edu/courses/6-092-introduction-to-programming-in-java-january-iap-2010/resources/mit6_092iap10_assn07/

Assignment 7: 
    A magic square of order n is an arrangement of n × n numbers, usually distinct integers, in a square, such that the n
numbers in all rows, all columns, and both diagonals sum to the same constant
*/

package Assignment7;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MagicSquares {

    public static boolean testMagic(String pathName) throws IOException{
        // Declare variable to check if all sums are equal
        List<Integer> sumList = new ArrayList<>();

        // Open file
        File myObj = new File(pathName);
        System.out.println("Opening File name: " + myObj.getName() + "\n");
        Scanner myReader = new Scanner(new File(pathName));

        // Parse file by row
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            String[] rowList = data.split("\t");

            if (data != ""){
                Integer sum = 0;
                for (String value: rowList){
                    sum += Integer.valueOf(value);
                }
                sumList.add(sum);
                System.out.print(data + "  Sum = ");
                System.out.println(sum);
            }
        }
        myReader.close();

        return sumList.stream().allMatch(integer -> integer/1 == sumList.get(0));
    }
    
    public static void main(String[] arguments) throws IOException{
        String[] fileNames = { "MIT_Intro_to_Java\\Assignment7\\Data\\Mercury.txt", "MIT_Intro_to_Java\\Assignment7\\Data\\Luna.txt" };
        for (String fileName : fileNames) {
            System.out.println(fileName + " rows have same sum? " + testMagic(fileName));
        }
    }
} 

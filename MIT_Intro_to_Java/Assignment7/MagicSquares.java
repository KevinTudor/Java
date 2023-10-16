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
        List<Integer> rowSums = new ArrayList<>();
        List<Integer> columnSums = new ArrayList<>();
        List<List<Integer>> table = new ArrayList<>();


        // Open file
        File myObj = new File(pathName);
        System.out.println("Opening File name: " + myObj.getName() + "\n");
        Scanner myReader = new Scanner(new File(pathName));

        // Parse file by row
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            String[] rowList = data.split("\t");
            List<Integer> row = new ArrayList<>();

            if (data != ""){
                Integer sum = 0;
                for (String value: rowList){
                    row.add(Integer.valueOf(value));
                    sum += Integer.valueOf(value);
                }
                table.add(row);
                rowSums.add(sum);
                System.out.print(data + "  Sum = " + sum + "\n");
            }
        }
        myReader.close();

        // Parse by column
        for (int row = 0; row < table.size(); row++){
            for (int column = 0; column < table.get(row).size(); column++){
                Integer value = table.get(row).get(column);
                if (row == 0){
                    columnSums.add(value);
                }else{
                    columnSums.set(column, columnSums.get(column) + value);
                }
            }
        }
        for (Integer value : columnSums){
            System.out.print(String.format("%-8d", value));
        }
        System.out.println("\n");

        Boolean columnsEqual = columnSums.stream().allMatch(integer -> integer/1 == columnSums.get(0));
        Boolean rowsEqual = rowSums.stream().allMatch(integer -> integer/1 == rowSums.get(0));

        return columnsEqual && rowsEqual;
    }
    
    public static void main(String[] arguments) throws IOException{
    String[] fileNames = { "MIT_Intro_to_Java\\Assignment7\\Data\\Mercury.txt", "MIT_Intro_to_Java\\Assignment7\\Data\\Luna.txt" };
        for (String fileName : fileNames) {
            System.out.println(fileName.substring(35, fileName.length()) + " rows and columns have same sum? " + testMagic(fileName) + "\n");
        }
    }
} 

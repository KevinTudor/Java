/* 
link: https://ocw.mit.edu/courses/6-092-introduction-to-programming-in-java-january-iap-2010/resources/mit6_092iap10_assn07/

Assignment 7: 
    A magic square of order n is an arrangement of n × n numbers, usually distinct integers, in a square, such that the n
numbers in all rows, all columns, and both diagonals sum to the same constant

TESTING ECLIPSE SOURCE CONTROL
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
        Integer diagonalRight = 0;
        Integer diagonalLeft = 0;
        List<List<Integer>> table = new ArrayList<>();
        Boolean diagonalsEqual = false;

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

        // Parse by column and diagonals
        Integer columnPointer = table.size() - 1;

        for (int row = 0; row < table.size(); row++){

            // Find Diagonal Left Sum
            Integer diagValue = table.get(row).get(columnPointer);
            diagonalLeft = diagonalLeft + diagValue;
            columnPointer = columnPointer - 1;

            for (int column = 0; column < table.get(row).size(); column++){
                Integer value = table.get(row).get(column);

                // Find column Sums
                if (row == 0){
                    columnSums.add(value);
                }else{
                    columnSums.set(column, columnSums.get(column) + value);
                }

                // Find Diagonal Right Sum
                if (row == column){
                    if (row == 0){
                        diagonalRight = value;
                    }else{
                        diagonalRight = diagonalRight + value;
                    }
                }
            }
        }

        for (Integer value : columnSums){
            System.out.print(String.format("%-8d", value));
        }
        System.out.println("\n");

        if (diagonalLeft - diagonalRight == 0){
            diagonalsEqual = true;
        }

        Boolean columnsEqual = columnSums.stream().allMatch(integer -> integer/1 == columnSums.get(0));
        Boolean rowsEqual = rowSums.stream().allMatch(integer -> integer/1 == rowSums.get(0));

        return columnsEqual && rowsEqual && diagonalsEqual;
    }
    
    public static void main(String[] arguments) throws IOException{
    String[] fileNames = { "MIT_Intro_to_Java\\Assignment7\\Data\\Mercury.txt", "MIT_Intro_to_Java\\Assignment7\\Data\\Luna.txt" };
        for (String fileName : fileNames) {
            System.out.println(fileName.substring(35, fileName.length()) + " rows and columns have same sum? " + testMagic(fileName) + "\n");
        }
    }
} 

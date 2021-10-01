/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Conroy Ricketts
 */

package ex42;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Parser
{
    public static void main(String[] args) throws IOException
    {
        File inputFile = new File("src/main/java/ex42/exercise42_input.txt");
        Scanner scInput = new Scanner(inputFile);

        ArrayList<String> records = new ArrayList<String>();

        while (scInput.hasNextLine())
        {
            String[] fields = scInput.nextLine().split(",");

            for(String field : fields)
                records.add(field);
        }

        displayRecords(records);
    }

    public static int displayRecords(ArrayList<String> listOfRecords)
    {
        int iterations = 1;
        System.out.format("%-15s%-15s%-15s\n------------------------------------\n", "Last", "First", "Salary");

        for(String record : listOfRecords)
        {
            System.out.format("%-15s", record);

            if(iterations % 3 == 0)
                System.out.format("\n");

            iterations++;
        }

        //"1" indicates successful completion.
        return 1;
    }
}

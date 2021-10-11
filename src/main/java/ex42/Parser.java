/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Conroy Ricketts
 */

package ex42;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Parser
{
    public static void main(String[] args) throws IOException
    {
        //initialize/declare any necessary variables
        File inputFile = new File("src/main/java/ex42/exercise42_input.txt");
        Scanner scInput = new Scanner(inputFile);
        String output;
        ArrayList<String> records = new ArrayList<String>();

        //split all entries of the input file into list elements
        while (scInput.hasNextLine())
        {
            String[] fields = scInput.nextLine().split(",");
            records.addAll(Arrays.asList(fields));
        }

        //get the formatted table to display
        output = displayRecords(records);

        //display the formatted table
        System.out.println(output);
    }

    public static String displayRecords(ArrayList<String> listOfRecords)
    {
        //initialize/declare any necessary variables
        int iterations = 1;
        StringBuilder stringBuilder = new StringBuilder();

        //append table header
        stringBuilder.append(String.format("%-15s%-15s%-15s\n------------------------------------\n", "Last", "First", "Salary"));

        //append each record
        for(String record : listOfRecords)
        {
            stringBuilder.append(String.format("%-15s", record));

            if(iterations % 3 == 0)
                stringBuilder.append("\n");

            iterations++;
        }

        //return the table
        return stringBuilder.toString();
    }
}

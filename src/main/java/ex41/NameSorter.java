/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Conroy Ricketts
 */

package ex41;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class NameSorter
{
    public static void main(String[] args) throws IOException
    {
        //get input file
        File inputFile = new File("src/main/java/ex41/exercise41_input.txt");

        //create output file
        File outputFile = new File("src/main/java/ex41/exercise41_output.txt");

        //get scanner and buffered writer
        Scanner scInput = new Scanner(inputFile);
        BufferedWriter bwOutput = new BufferedWriter(new FileWriter(outputFile));

        //create array lists to store names
        ArrayList<String> names = new ArrayList<String>();
        ArrayList<String> namesSorted = new ArrayList<String>();

        //read input into array list
        while (scInput.hasNextLine())
            names.add(scInput.nextLine());

        //write output header
        bwOutput.write(String.format("Total of %d names\n-------------------", names.size()));
        bwOutput.newLine();

        //sort names
        namesSorted = sortNames(names);

        //write each sorted name to output
        for(String name : namesSorted)
        {
            bwOutput.write(name);
            bwOutput.newLine();
        }

        //close buffered writer
        bwOutput.flush();
        bwOutput.close();
    }

    public static ArrayList<String> sortNames(ArrayList<String> namesToBeSorted)
    {
        //create array list to store the sorted names
        ArrayList<String> returnList = new ArrayList<String>();

        //until the original list of names is empty
        while(!namesToBeSorted.isEmpty())
        {
            //initialize var to store the highest name in the alphabetical list
            String highestName = namesToBeSorted.get(0);

            //for each name in the list to be sorted
            for(int i = 1; i < namesToBeSorted.size(); i++)
            {
                //store the name that is highest in the alphabetical list
                if(namesToBeSorted.get(i).compareTo(highestName) <= 0)
                    highestName = namesToBeSorted.get(i);
            }

            //add the name to the sorted names
            returnList.add(highestName);

            //remove the name from the original list
            namesToBeSorted.remove(highestName);
        }

        //return the sorted names
        return returnList;
    }
}

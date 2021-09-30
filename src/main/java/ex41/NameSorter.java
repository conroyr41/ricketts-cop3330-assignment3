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
        File inputFile = new File("src/main/java/ex41/exercise41_input.txt");
        File outputFile = new File("src/main/java/ex41/exercise41_output.txt");

        Scanner scInput = new Scanner(inputFile);
        BufferedWriter bwOutput = new BufferedWriter(new FileWriter(outputFile));

        ArrayList<String> names = new ArrayList<String>();
        ArrayList<String> namesSorted = new ArrayList<String>();

        while (scInput.hasNextLine())
            names.add(scInput.nextLine());

        bwOutput.write(String.format("Total of %d names\n-------------------", names.size()));
        bwOutput.newLine();

        namesSorted = sortNames(names);

        for(String name : namesSorted)
        {
            bwOutput.write(name);
            bwOutput.newLine();
        }

        bwOutput.flush();
        bwOutput.close();
    }

    public static ArrayList<String> sortNames(ArrayList<String> namesToBeSorted)
    {
        ArrayList<String> returnList = new ArrayList<String>();

        while(!namesToBeSorted.isEmpty())
        {
            String highestName = namesToBeSorted.get(0);

            for(int i = 1; i < namesToBeSorted.size(); i++)
            {
                if(namesToBeSorted.get(i).compareTo(highestName) <= 0)
                    highestName = namesToBeSorted.get(i);
            }

            returnList.add(highestName);
            namesToBeSorted.remove(highestName);
        }

        return returnList;
    }
}

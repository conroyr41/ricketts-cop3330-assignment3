/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Conroy Ricketts
 */

package ex45;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WordFinder
{
    public static void main(String[] args) throws IOException
    {
        Scanner scan;
        String outName, result;

        System.out.print("Enter the name of the output file: ");
        scan = new Scanner(System.in);
        outName = scan.next();

        result = generateOutputFile(outName);
        System.out.print(result);
    }

    public static String generateOutputFile(String nameOfOutputFile) throws IOException
    {
        try
        {
            File inputFile, outputFile;
            BufferedWriter bufferedWriter;
            Scanner inputScanner;
            String oldText = "", newText;

            inputFile = new File("src/main/java/ex45/exercise45_input.txt");
            outputFile = new File( String.format("src/main/java/ex45/%s.txt", nameOfOutputFile));

            bufferedWriter = new BufferedWriter(new FileWriter(outputFile));
            inputScanner = new Scanner(inputFile);

            while(inputScanner.hasNextLine())
                oldText += inputScanner.nextLine() + "\n";

            newText = oldText.replaceAll("utilize", "use");

            bufferedWriter.write(newText);
            bufferedWriter.flush();
            bufferedWriter.close();

            return "The output file was generated successfully with no errors!";
        }
        catch (Exception e)
        {
            return "Something went wrong.";
        }
    }
}

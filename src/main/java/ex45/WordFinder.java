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
        //initialize/declare any necessary variables
        Scanner scan;
        String outName, result;

        //prompt for name of output file
        System.out.print("Enter the name of the output file: ");
        scan = new Scanner(System.in);
        outName = scan.next();

        //generate output file
        result = generateOutputFile(outName);

        //output the result
        System.out.print(result);
    }

    public static String generateOutputFile(String nameOfOutputFile) throws IOException
    {
        try
        {
            //initialize/declare any necessary variables
            File inputFile, outputFile;
            BufferedWriter bufferedWriter;
            Scanner inputScanner;
            String oldText = "", newText;

            //get input file
            inputFile = new File("src/main/java/ex45/exercise45_input.txt");

            //create output file
            outputFile = new File( String.format("src/main/java/ex45/%s.txt", nameOfOutputFile));

            //create buffered writer to write output
            bufferedWriter = new BufferedWriter(new FileWriter(outputFile));

            //create scanner to read input
            inputScanner = new Scanner(inputFile);

            //read the input
            while(inputScanner.hasNextLine())
                oldText += inputScanner.nextLine() + "\n";

            //replace the word as specified by the assignment instructions
            newText = oldText.replaceAll("utilize", "use");

            //write the result to the output file
            bufferedWriter.write(newText);

            //close the buffered writer
            bufferedWriter.flush();
            bufferedWriter.close();

            //indicate that the code block ran without error
            return "The output file was generated successfully with no errors!";
        }
        catch (Exception e)
        {
            //indicate that the code block ran with some error
            return "Something went wrong.";
        }
    }
}

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Conroy Ricketts
 */

package ex46;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class WordFrequency
{
    public static void main(String[] args) throws FileNotFoundException
    {
        //initialize/declare any necessary variables
        File inputFile;
        ArrayList<String> words;
        ArrayList<Integer> occurrencesOfWords;

        //get input file
        inputFile = new File("src/main/java/ex46/exercise46_input.txt");

        //get all unique words from input
        words = getAllWords(inputFile);

        //get the occurrences of each unique word
        occurrencesOfWords = getOccurrencesOfWords(inputFile, words);

        //generate histogram for output
        System.out.print(generateHistogram(words, occurrencesOfWords));
    }

    public static ArrayList<String> getAllWords(File input) throws FileNotFoundException
    {
        //initialize/declare any necessary variables
        Scanner scan = new Scanner(input);
        ArrayList<String> returnList = new ArrayList<String>();

        //read input and store each unique word in a list
        while(scan.hasNext())
        {
            String word = scan.next();

            if(!returnList.contains(word))
                returnList.add(word);
        }

        //return the list of unique words
        return returnList;
    }

    public static ArrayList<Integer> getOccurrencesOfWords(File input, ArrayList<String> wordsList) throws FileNotFoundException
    {
        //initialize/declare any necessary variables
        Scanner scan = new Scanner(input);
        ArrayList<Integer> returnList = new ArrayList<Integer>();

        //for each word, initialize its "occurrences" to 0
        for(String word : wordsList)
            returnList.add(0);

        //read input and for each word we read, increment its occurrence value
        while(scan.hasNext())
        {
            String word = scan.next();
            int index = wordsList.indexOf(word);

            returnList.set(index, returnList.get(index) + 1);
        }

        //return the list of occurrences
        return returnList;
    }

    public static String generateHistogram(ArrayList<String> wordsList, ArrayList<Integer> occurrencesList)
    {
        //initialize/declare any necessary variables
        StringBuilder stringBuilder = new StringBuilder();
        int maxValue, indexOfMostOccurredWord, longestLength = 0;
        String stringForFiller;

        //get the longest word
        for(String word : wordsList)
        {
            if(word.length() > longestLength)
                longestLength = word.length();
        }

        //while the words list is not empty
        while(!wordsList.isEmpty())
        {
            //get the word with the most occurrences
            maxValue = Collections.max(occurrencesList);
            indexOfMostOccurredWord = occurrencesList.indexOf(Collections.max(occurrencesList));

            //add some filler to the string so that we get the same output as shown in the assignment
            stringForFiller = wordsList.get(indexOfMostOccurredWord) + ": ";
            stringBuilder.append(stringForFiller);

            //add some filler to the string so that we get the same output as shown in the assignment
            for(int i = stringForFiller.length(); i < longestLength + 2; i++)
                stringBuilder.append(" ");

            //add the number of respective stars to show a words occurrences
            for(int i = 0; i < maxValue; i++)
            {
                stringBuilder.append("*");
            }

            //go to the next line for the next word
            stringBuilder.append("\n");

            //remove the word from both lists
            wordsList.remove(indexOfMostOccurredWord);
            occurrencesList.remove(indexOfMostOccurredWord);
        }

        //return the histogram
        return stringBuilder.toString();
    }
}

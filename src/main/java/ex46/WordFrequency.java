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
        File inputFile;
        ArrayList<String> words;
        ArrayList<Integer> occurrencesOfWords;

        inputFile = new File("src/main/java/ex46/exercise46_input.txt");
        words = getAllWords(inputFile);
        occurrencesOfWords = getOccurrencesOfWords(inputFile, words);

        System.out.print(generateHistogram(words, occurrencesOfWords));
    }

    public static ArrayList<String> getAllWords(File input) throws FileNotFoundException
    {
        Scanner scan = new Scanner(input);
        ArrayList<String> returnList = new ArrayList<String>();

        while(scan.hasNext())
        {
            String word = scan.next();

            if(!returnList.contains(word))
                returnList.add(word);
        }

        return returnList;
    }

    public static ArrayList<Integer> getOccurrencesOfWords(File input, ArrayList<String> wordsList) throws FileNotFoundException
    {
        Scanner scan = new Scanner(input);
        ArrayList<Integer> returnList = new ArrayList<Integer>();

        for(String word : wordsList)
            returnList.add(0);

        while(scan.hasNext())
        {
            String word = scan.next();
            int index = wordsList.indexOf(word);

            returnList.set(index, returnList.get(index) + 1);
        }

        return returnList;
    }

    public static String generateHistogram(ArrayList<String> wordsList, ArrayList<Integer> occurrencesList)
    {
        StringBuilder stringBuilder = new StringBuilder();
        int maxValue, indexOfMostOccurredWord, longestLength = 0;
        String stringForFiller;

        for(String word : wordsList)
        {
            if(word.length() > longestLength)
                longestLength = word.length();
        }

        while(!wordsList.isEmpty())
        {
            maxValue = Collections.max(occurrencesList);
            indexOfMostOccurredWord = occurrencesList.indexOf(Collections.max(occurrencesList));

            stringForFiller = wordsList.get(indexOfMostOccurredWord) + ": ";
            stringBuilder.append(stringForFiller);

            for(int i = stringForFiller.length(); i < longestLength + 2; i++)
                stringBuilder.append(" ");

            for(int i = 0; i < maxValue; i++)
            {
                stringBuilder.append("*");
            }

            stringBuilder.append("\n");

            wordsList.remove(indexOfMostOccurredWord);
            occurrencesList.remove(indexOfMostOccurredWord);
        }

        return stringBuilder.toString();
    }
}

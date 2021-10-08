/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Conroy Ricketts
 */

package ex46;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class WordFrequencyTest
{
    @Test
    public void getAllWords_GivenInputFile_ListOfOnlyUniqueWords() throws FileNotFoundException
    {
        ArrayList<String> testList, expectedList = new ArrayList<String>(3);
        WordFrequency wordFrequency = new WordFrequency();

        expectedList.add("badger");
        expectedList.add("mushroom");
        expectedList.add("snake");

        testList = wordFrequency.getAllWords(new File("src/main/java/ex46/exercise46_input.txt"));

        Assertions.assertEquals(expectedList, testList);
    }

    @Test
    public void getOccurrencesOfWords_GivenInputFileAndItsUniqueWords_ListOfOccurrencesOfUniqueWords() throws FileNotFoundException
    {
        ArrayList<Integer> testList, expectedList = new ArrayList<Integer>(3);
        ArrayList<String> testListOfWords = new ArrayList<String>(3);
        WordFrequency wordFrequency = new WordFrequency();

        expectedList.add(7);
        expectedList.add(2);
        expectedList.add(1);

        testListOfWords.add("badger");
        testListOfWords.add("mushroom");
        testListOfWords.add("snake");

        testList = wordFrequency.getOccurrencesOfWords(new File("src/main/java/ex46/exercise46_input.txt"), testListOfWords);

        for(Integer value : expectedList)
            Assertions.assertTrue(testList.contains(value));
    }

    @Test
    public void generateHistogram_GivenSampleList_ExpectedOutput()
    {
        String expectedOutput, testOutput;
        WordFrequency wordFrequency = new WordFrequency();
        ArrayList<Integer> testListOfOccurrences = new ArrayList<Integer>(3);
        ArrayList<String> testListOfWords = new ArrayList<String>(3);

        testListOfWords.add("a");
        testListOfWords.add("b");

        testListOfOccurrences.add(1);
        testListOfOccurrences.add(2);

        expectedOutput = "b: **\na: *\n";
        testOutput = wordFrequency.generateHistogram(testListOfWords, testListOfOccurrences);

        Assertions.assertEquals(expectedOutput, testOutput);
    }
}

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Conroy Ricketts
 */

package ex45;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class WordFinderTest
{
    @Test
    public void generateOutputFile_GivenAnyName_RunsWithoutAHitch() throws IOException
    {
        String testOutput, expectedOutput = "The output file was generated successfully with no errors!";

        WordFinder wordFinder = new WordFinder();
        testOutput = wordFinder.generateOutputFile("testName");

        Assertions.assertEquals(expectedOutput, testOutput);
    }
}

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Conroy Ricketts
 */

package ex42;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ParserTest
{
    @Test
    public void displayRecords_GivenOneEntry_CorrectlyFormattedSingleEntryTable()
    {
        ArrayList<String> testList = new ArrayList<String>();
        testList.add("Ling");
        testList.add("Mai");
        testList.add("55900");

        Parser parser = new Parser();
        String testOutput = parser.displayRecords(testList);
        String expectedOutput = String.format("%-15s%-15s%-15s\n------------------------------------\n%-15s%-15s%-15s\n", "Last", "First", "Salary","Ling","Mai","55900");

        Assertions.assertEquals(expectedOutput, testOutput);
    }
}

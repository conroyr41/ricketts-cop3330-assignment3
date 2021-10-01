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
    public void displayRecords_GivenAnyList_1()
    {
        ArrayList<String> testList = new ArrayList<String>();
        testList.add("Ling");
        testList.add("Mai");
        testList.add("55900");

        Parser parser = new Parser();

        //"1" indicates successful completion of the method.
        Assertions.assertEquals(1, parser.displayRecords(testList));
    }
}

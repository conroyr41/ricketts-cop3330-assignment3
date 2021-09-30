/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Conroy Ricketts
 */

package ex41;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class NameSorterTest
{
    @Test
    public void sortNames_GivenCBA_ABC()
    {
        ArrayList<String> testList = new ArrayList<String>();
        ArrayList<String> expectedList = new ArrayList<String>();

        testList.add("C");
        testList.add("B");
        testList.add("A");

        expectedList.add("A");
        expectedList.add("B");
        expectedList.add("C");

        NameSorter nameSorter = new NameSorter();

        Assertions.assertEquals(expectedList, nameSorter.sortNames(testList));
    }
}

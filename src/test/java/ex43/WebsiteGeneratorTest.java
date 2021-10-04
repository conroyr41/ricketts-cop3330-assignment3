/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Conroy Ricketts
 */

package ex43;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class WebsiteGeneratorTest
{
    @Test
    public void generateWebSkeleton_GivenNoJSOrCSSFolders_CreatesNoSubFolders() throws IOException
    {
        //If the user responds "no" for both JavaScript files and CSS files, then only index.html should
        //be created (no subfolders).

        String expectedOutput = "Created ./website/TestWebsiteName\nCreated ./website/TestWebsiteName/index.html\n";
        String testOutput;

        WebsiteGenerator websiteGenerator = new WebsiteGenerator();
        testOutput = websiteGenerator.generateWebSkeleton("TestWebsiteName","TestAuthorName", 0, 0);

        Assertions.assertEquals(expectedOutput, testOutput);
    }
}

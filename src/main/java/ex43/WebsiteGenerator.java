/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Conroy Ricketts
 */

package ex43;

import javax.swing.text.html.CSS;
import java.io.BufferedWriter;
import java.io.*;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class WebsiteGenerator
{
    public static void main(String[] args) throws IOException
    {
        Scanner scan;
        String name, author, output;
        int JSFolder, CSSFolder;

        System.out.print("Enter the name of the website: ");
        scan = new Scanner(System.in);
        name = scan.next();

        System.out.print("Enter the author of the website: ");
        scan = new Scanner(System.in);
        author = scan.next();

        System.out.print("Do you want a folder for JavaScript files? Enter a 1 for yes, and a 0 for no: ");
        scan = new Scanner(System.in);
        JSFolder = Integer.parseInt(scan.next());

        System.out.print("Do you want a folder for CSS files? Enter a 1 for yes, and a 0 for no: ");
        scan = new Scanner(System.in);
        CSSFolder = Integer.parseInt(scan.next());

        output = generateWebSkeleton(name, author, JSFolder, CSSFolder);
        System.out.print(output);
    }

    public static String generateWebSkeleton(String theName, String theAuthor, int includeJS, int includeCSS) throws IOException
    {
        StringBuilder stringBuilder = new StringBuilder();
        File indexHTML, JSDirectory, CSSDirectory;
        BufferedWriter bufferedWriter;

        new File(String.format("src/main/java/ex43/website/%s", theName)).mkdirs();
        stringBuilder.append(String.format("Created ./website/%s\n", theName));

        indexHTML = new File(String.format("src/main/java/ex43/website/%s/index.html", theName));
        stringBuilder.append(String.format("Created ./website/%s/index.html\n", theName));

        bufferedWriter = new BufferedWriter(new FileWriter(indexHTML));

        bufferedWriter.write(String.format(
                "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "   <title>%s</title>\n" +
                "<meta name=\"%s\">\n" +
                "</head>\n" +
                "</html>"
        , theName, theAuthor));

        bufferedWriter.flush();
        bufferedWriter.close();

        if(includeJS == 1)
        {
            new File(String.format("src/main/java/ex43/website/%s/js", theName)).mkdir();
            stringBuilder.append(String.format("Created ./website/%s/js\n", theName));
        }

        if(includeCSS == 1)
        {
            new File(String.format("src/main/java/ex43/website/%s/css", theName)).mkdir();
            stringBuilder.append(String.format("Created ./website/%s/css\n", theName));
        }

        return stringBuilder.toString();
    }
}

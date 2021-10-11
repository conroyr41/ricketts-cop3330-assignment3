/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Conroy Ricketts
 */

package ex43;

import java.io.BufferedWriter;
import java.io.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WebsiteGenerator
{
    public static void main(String[] args) throws IOException
    {
        //initialize/declare any necessary variables
        Scanner scan;
        String name, author, output;
        int JSFolder, CSSFolder;

        //prompt for website name
        System.out.print("Enter the name of the website: ");
        scan = new Scanner(System.in);
        name = scan.next();

        //prompt for author name
        System.out.print("Enter the author of the website: ");
        scan = new Scanner(System.in);
        author = scan.next();

        //prompt for JS files
        System.out.print("Do you want a folder for JavaScript files? Enter a 1 for yes, and a 0 for no: ");
        scan = new Scanner(System.in);
        JSFolder = Integer.parseInt(scan.next());

        //prompt for CSS files
        System.out.print("Do you want a folder for CSS files? Enter a 1 for yes, and a 0 for no: ");
        scan = new Scanner(System.in);
        CSSFolder = Integer.parseInt(scan.next());

        //generate the web skeleton
        output = generateWebSkeleton(name, author, JSFolder, CSSFolder);

        //output as required per assignment instructions
        System.out.print(output);
    }

    public static String generateWebSkeleton(String theName, String theAuthor, int includeJS, int includeCSS) throws IOException
    {
        //initialize/declare any necessary variables
        StringBuilder stringBuilder = new StringBuilder();
        File indexHTML, JSDirectory, CSSDirectory;
        BufferedWriter bufferedWriter;

        //create the directory
        new File(String.format("src/main/java/ex43/website/%s", theName)).mkdirs();
        stringBuilder.append(String.format("Created ./website/%s\n", theName));

        //create index.html
        indexHTML = new File(String.format("src/main/java/ex43/website/%s/index.html", theName));
        stringBuilder.append(String.format("Created ./website/%s/index.html\n", theName));

        //create buffered writer for index.html
        bufferedWriter = new BufferedWriter(new FileWriter(indexHTML));

        //write to index.html
        bufferedWriter.write(String.format(
                "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "   <title>%s</title>\n" +
                "<meta name=\"%s\">\n" +
                "</head>\n" +
                "</html>"
        , theName, theAuthor));

        //close buffered writer
        bufferedWriter.flush();
        bufferedWriter.close();

        //create JS folder
        if(includeJS == 1)
        {
            new File(String.format("src/main/java/ex43/website/%s/js", theName)).mkdir();
            stringBuilder.append(String.format("Created ./website/%s/js\n", theName));
        }

        //create CSS folder
        if(includeCSS == 1)
        {
            new File(String.format("src/main/java/ex43/website/%s/css", theName)).mkdir();
            stringBuilder.append(String.format("Created ./website/%s/css\n", theName));
        }

        //return output
        return stringBuilder.toString();
    }
}

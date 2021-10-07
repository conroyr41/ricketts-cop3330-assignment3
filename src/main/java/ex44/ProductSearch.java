/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Conroy Ricketts
 */

package ex44;

import org.json.JSONArray;
import org.json.JSONObject;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class ProductSearch
{
    public static void main(String[] args) throws IOException
    {
        Scanner scan;
        JSONObject myJSONObject;
        JSONArray myJSONArray;
        String output, productName = "";
        File file;
        Boolean foundProduct = false;
        int productIndex = 0;

        //get JSON array
        file = new File("src/main/java/ex44/exercise44_input.json");
        myJSONObject = new JSONObject(FileUtils.readFileToString(file, "utf-8"));
        myJSONArray = myJSONObject.getJSONArray("products");

        //wait for correct user input
        while(Objects.equals(productName, ""))
        {
            System.out.print("What is the product name? ");
            scan = new Scanner(System.in);
            productName = scan.next();

            for(int i = 0; i < myJSONArray.length(); i++)
            {
                JSONObject product = myJSONArray.getJSONObject(i);

                if(Objects.equals(product.get("name"), productName))
                {
                    foundProduct = true;
                    productIndex = i;
                }
            }

            if(!foundProduct)
            {
                System.out.println("Sorry, that product was not found in our inventory.");
                productName = "";
            }
        }

        //get product information
        output = getProductData(myJSONArray.getJSONObject(productIndex));
        System.out.print(output);
    }

    public static String getProductData(JSONObject theJSONObject)
    {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("Name: %s\n", theJSONObject.get("name")));
        stringBuilder.append(String.format("Price: %.2f\n", theJSONObject.get("price")));
        stringBuilder.append(String.format("Quantity: %d\n", theJSONObject.get("quantity")));

        return stringBuilder.toString();
    }
}

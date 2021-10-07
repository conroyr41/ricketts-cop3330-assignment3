/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Conroy Ricketts
 */

package ex44;

import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductSearchTest
{
    @Test
    public void getProductData_GivenTestJSON_ReturnsCorrectJSONObjectValues()
    {
        String expectedOutput = "Name: Thing\nPrice: 15.00\nQuantity: 5\n";
        String testOutput;

        JSONObject testJSONObject = new JSONObject();

        testJSONObject.put("name", "Thing");
        testJSONObject.put("price", 15.00);
        testJSONObject.put("quantity", 5);

        ProductSearch productSearch = new ProductSearch();
        testOutput = productSearch.getProductData(testJSONObject);

        Assertions.assertEquals(expectedOutput, testOutput);
    }
}

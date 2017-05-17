/**
 * Copyright 2017 Goldman Sachs.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package utility;
import java.text.SimpleDateFormat;

/**
 * Utility class to validate inputs
 */
public class InputValidator 
{

    public static boolean validateFile(String fileName)
    {   
        if(fileName.equals("companyInfo.json")) 
        {
            return true;
        }
        else if(fileName.equals("historicalStockData.json"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public static boolean validateCompany(String stockTicker)
    {
        List<String> stockTickers;
        stockTickers = getAllSymbols("companyInfo.json"); 
        if(stockTickers.contains(stockTicker))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public static boolean validateStock(String stockTicker, String startDate, String endDate)
    {
        boolean check = true;
        List<String> stockTickers, dates;
        stockTickers = readAllStockTickers("historicalStockData.json"); 
        dates = readAllDates("historicalStockData.json"); //do method

        if(!stockTickers.contains(stockTicker))
        {
            check = false;
        }
        if(!dates.contains(startDate) || !dates.contains(endDate))
        {
            check = false;
        }
        
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

        Date start = format.parse(startDate);
        Date end = format.parse(endDate);

            if (end.compareTo(start) < 0) {
                check = false;
            }

        }
        return check;
    }
    // TODO - write a method that will validate your JSON input files

    // TODO - write a method that will validate the inputs to the Company Resource

    // TODO - write a method that will validate the inputs to the Stock Resource

}

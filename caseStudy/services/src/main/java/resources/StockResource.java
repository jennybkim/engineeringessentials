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

package resources;
import javax.ws.rs.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import pojo.Stock;
import java.text.SimpleDateFormat;

@Path("services")
public class StockResource {
    @GET
    @Path("stock")
    @Produces(MediaType.APPLICATION_JSON)
    public static Stock getDateRange(String startDate, String endDate)
    {
        List<Stock> stocks;
        stocks = readAllStocks(fileName);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        Date start = format.parse(startDate);
        Date end = format.parse(endDate);

        for(Stock s: stocks)
        {
            Date curr = format.parse(s.getDate());
            if (curr.compareTo(start) < 0) {
                stocks.remove(s);
            }
            if(end.compareTo(curr) < 0) {
                stocks.remove(s);
            }
        }
        return stocks;
    }
    public static List<Map<Date, Double>> sort(Stock s)
    {
        List<Map<String,Double>> original;
        original = s.getDailyClosePrice();
        for (Entry e : original.getEntrySet())
        Scanner scan = new Scanner(// key value of a map);
        Date d = new GregorianCalendar(scan.next(), scan.next(), scan.next());
    }
    public static List<String> readAllStockTickers()
    {   
        List<String> stockTickers;
        List<Stock> stocks;
        stocks = readAllStocks("historicalStockData.json");
        for(Stock s: stocks)
        {
            stockTickers.add(s.getSymbol());
        }
        return stockTickers;

    }
      public static List<String> readAllDates()
    {   
        List<String> stockTickers;
        List<Stock> stocks;
        stocks = readAllStocks("historicalStockData.json");
        for(Stock s: stocks)
        {
            stockTickers.add(s.getSymbol());
        }
        return stockTickers;

    }
    public Response getStockResource(String stockTicker, String startDate, String endDate) 
    throws IOException
    {
        
        String fileName = "historicalStock.json";
        List<Stock> dateRange; //TODO instantiate using Company methods
        dateRange = getDateRange(startDate, endDate);
        for(Stock s: dateRange)
        {
            if(s.getName().equals(stockTicker) && dateRange.contains(s) 
            && dateRange.containsDate(s)) 
            {
                return Response.ok().entity(s).build();
            }
            
        }

    }
    // TODO - Add a @GET resource to get stock data
    // Your service should return data based on 3 inputs
    // Stock ticker, start date and end date

}

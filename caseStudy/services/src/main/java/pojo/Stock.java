package pojo;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * This class will define a company's end-of-day stock price
 * Look at resources/data/historicalStockData.json
 */
public class Stock {

	private static final ObjectMapper mapper = new ObjectMapper();

	private String name;

	private List<HashMap<String, Double>> dailyClosePrice;

	public Stock() {

	}

	public Stock(String symbol, List<HashMap<String, Double>> dailyClosePrice) {
		this.name = symbol;
		this.dailyClosePrice = dailyClosePrice;
	}

	public String getName() {
		return name;
	}

	public List<HashMap<String, Double>> getDailyClosePrice() {
		return dailyClosePrice;
	}

	public void setName(String symbol) {
		this.name = symbol;
	}

	public void setDailyClosePrice(List<HashMap<String, Double>> dailyClosePrice) {
		this.dailyClosePrice = dailyClosePrice;
	}

	public static ArrayList<Stock> readAllStocks(String fileName) throws JsonParseException, JsonMappingException, IOException {
		InputStream inputStream = new FileInputStream((fileName));
		return mapper.readValue(inputStream, new TypeReference<List<Stock>>() {});
	}
}
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

package pojo;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * This class will define a company and its attributes
 * Look at resources/data/companyInfo.json
 */
public class Company {

    private static final ObjectMapper mapper = new ObjectMapper();

	@JsonProperty
    private String symbol;

    @JsonProperty
    private String name;

    @JsonProperty
    private String headquartersCity;

    @JsonProperty
    private String headquartersStateOrCountry;

    @JsonProperty
    private int numberOfEmployees;

    @JsonProperty
    private String sector;

    @JsonProperty
    private String industry;

    public Company() {

    }


    public Company(String symbol, String name, String city, String stateOrCountry,
    	int numOfEmployees, String sector, String industry) {
    	this.symbol = symbol;
    	this.name = name;
    	this.headquartersCity = city;
    	this.headquartersStateOrCountry = stateOrCountry;
    	this.numberOfEmployees = numOfEmployees;
    	this.sector = sector;
    	this.industry = industry;
    }  

    public String getSymbol() {
    	return symbol;
    }

    public String getName() {
    	return name;
    }

    public String getCity() {
    	return headquartersCity;
    }

    public String getStateOrCountry() {
    	return headquartersStateOrCountry;
    }

    public int getNumOfEmployees() {
    	return numberOfEmployees;
    }

    public String getSector() {
    	return sector;
    }

    public String getIndustry() {
    	return industry;
    }

    public void setSymbol(String symbol) {
    	this.symbol = symbol;
    }

    public void setCity(String city) {
    	this.headquartersCity = city;
    }

    public void setStateOrCountry(String stateOrCountry) {
    	this.headquartersStateOrCountry = stateOrCountry;
    }

    public void setNumOfEmployees(int numOfEmployees) {
    	this.numberOfEmployees = numOfEmployees;
    }

    public void setSector(String sector) {
    	this.sector = sector;
    }

    public void setIndustry(String industry) {
    	this.industry = industry;
    }

    public static ArrayList<Company> readAllCompanies(String fileName) throws JsonParseException, JsonMappingException, IOException {
    	InputStream inputStream = new FileInputStream((fileName));
        return mapper.readValue(inputStream, new TypeReference<List<Company>>() {
        });
    }
}
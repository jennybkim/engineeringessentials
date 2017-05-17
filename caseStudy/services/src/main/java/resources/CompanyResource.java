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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import pojo.Company;

@Path("services")
public class CompanyResource {
    @GET
    @Path("company")
    @Produces(MediaType.APPLICATION_JSON)

    public Response getCompanyResource(String stockTicker) throws IOException
    {
       
        String fileName = "companyInfo.json";
        List<Company> companies; //TODO instantiate using Company methods
        companies = Company.readAllCompanies(fileName); 
        for(Company c: companies)
        {
            if(c.getSymbol().equals(stockTicker)) //change to correct method name
            {
                 return Response.ok().entity(c).build();
            }
        }




    }
    // TODO - Add a @GET resource to get company data
    // Your service should return data for a given stock ticker

}

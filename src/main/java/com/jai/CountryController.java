package com.jai;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

	private static List<Country> cnt = new ArrayList<Country>();

	{
		Country c1 = new Country();
		c1.setId(101);
		c1.setName("India");

		Country c2 = new Country();
		c2.setId(201);
		c2.setName("Japan");

		Country c3 = new Country();
		c3.setId(301);
		c3.setName("America");
		cnt.add(c3);
		cnt.add(c1);
		cnt.add(c2);
	}

	@ApiOperation(value = "getCountry", nickname = "getCountry")
		 @ApiResponses(value = {
			        @ApiResponse(code = 500, message = "Server error"),
			         @ApiResponse(code = 404, message = "Service not found"),
			        @ApiResponse(code = 200, message = "Successful retrieval",
			            response = Country.class, responseContainer = "Country") })
		@RequestMapping(method = RequestMethod.GET, value = "/swagger/{id}")
		public  Country getCountry(@ApiParam(value = "Pass the country id to lookup for",required = true, defaultValue = "101")@PathVariable("id" ) final int id) {
			for (Country country : cnt) {
				if(country.getId()==id)
				{
					return country;
				}
			}
			return new Country();
		}
}

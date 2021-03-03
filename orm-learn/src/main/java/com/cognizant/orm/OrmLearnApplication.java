package com.cognizant.orm;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.orm.model.Country;
import com.cognizant.orm.service.CountryService;

@SpringBootApplication
public class OrmLearnApplication {

	private static CountryService countryService;
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

	private static void testGetAllCountries() {

		LOGGER.info("start");

		List<Country> countries = countryService.getAllCountries();

		LOGGER.debug("countries={}", countries);

		LOGGER.info("End");

	}

	private static void getAllCountriesTest() {

		LOGGER.info("Start");

		Country country = countryService.findCountryByCode("KA");

		LOGGER.debug("Country:{}", country);

		LOGGER.info("End");

	}
	
	private static void testAddCountry() {
		Country country = new Country();
		country.setCode("KA");
		country.setName("Karnataka");
		countryService.addCountry(country);
	}
	
	private static void DeleteByIdTest() {

		LOGGER.info("Start");

		 countryService.deleteCountry("DZ");

//		LOGGER.debug("Country:{}", country);

		LOGGER.info("End");

	}
	
	private static void getUpdateCountry() {

		LOGGER.info("Start");

		Country country = countryService.updateCountry("KA", "Bangalore");

		LOGGER.debug("Country:{}", country);

		LOGGER.info("End");

	}
	

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		countryService = context.getBean(CountryService.class);
//		testGetAllCountries();
//		getAllCountriesTest();
//		testAddCountry();
//		getUpdateCountry();
		DeleteByIdTest();

	}

}

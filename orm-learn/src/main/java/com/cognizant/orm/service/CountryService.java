package com.cognizant.orm.service;

import java.util.List;

import com.cognizant.orm.model.Country;

public interface CountryService {
	List<Country> getAllCountries();
	public Country findCountryByCode(String countryCode);
	public void addCountry(Country country);
	public Country updateCountry(String countryCode,String countryName);
	public void deleteCountry(String CountryCode);

}

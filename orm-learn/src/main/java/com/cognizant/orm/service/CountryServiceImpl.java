package com.cognizant.orm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.orm.exception.CountryNotFoundException;
import com.cognizant.orm.model.Country;
import com.cognizant.orm.repo.CountryRepository;

@Service
public class CountryServiceImpl implements CountryService{

	@Autowired
	private CountryRepository countryRepo;
	
	@Override
	public List<Country> getAllCountries() {
		
		return countryRepo.findAll();
	}

	@Override
	public Country findCountryByCode(String countryCode) throws CountryNotFoundException{
		Optional<Country> result = countryRepo.findById(countryCode);
		Country country=null;
		if (result.isPresent()) {
			country = result.get();
		}else {
			throw new CountryNotFoundException("Country code not found"+countryCode);
		}
			
		return country;
	}

	@Override
	public void addCountry(Country country) {
	 countryRepo.save(country);
		
	}

	@Override
	public Country updateCountry(String countryCode, String countryName) {
		Optional<Country> result = countryRepo.findById(countryCode);
		Country country=null;
		if (result.isPresent()) {
			country = result.get();
			country.setName(countryName);
			countryRepo.save(country);
		}else {
			throw new CountryNotFoundException("Country code not found"+countryCode);
		}
			
		return country;
		
	}

	@Override
	public void deleteCountry(String CountryCode) {
	 countryRepo.deleteById(CountryCode);
		
	}
	
	

}

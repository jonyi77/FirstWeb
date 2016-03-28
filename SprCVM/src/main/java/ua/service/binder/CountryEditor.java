package ua.service.binder;

import java.beans.PropertyEditorSupport;

import ua.service.impl.CountryServiceImpl;

public class CountryEditor extends PropertyEditorSupport {
	
	private final CountryServiceImpl countryServiceImpl;
	
	public CountryEditor (CountryServiceImpl countryServiceImpl){
		this.countryServiceImpl = countryServiceImpl;
	}
	
	public void setAsText(String text) throws IllegalArgumentException{
		setValue(countryServiceImpl.findById(Integer.parseInt(text)));
	}

}

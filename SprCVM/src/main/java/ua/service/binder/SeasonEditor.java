package ua.service.binder;

import java.beans.PropertyEditorSupport;

import ua.service.impl.SeasonServiceImpl;

public class SeasonEditor extends PropertyEditorSupport{
	private final SeasonServiceImpl seasonServiceImpl;

	public SeasonEditor(SeasonServiceImpl seasonServiceImpl) {
		this.seasonServiceImpl = seasonServiceImpl;
	}
	
	public void setAsText(String text) throws IllegalArgumentException{
		setValue(seasonServiceImpl.findById(Integer.parseInt(text)));
	}
}
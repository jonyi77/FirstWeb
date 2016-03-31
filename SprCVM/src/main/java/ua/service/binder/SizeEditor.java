package ua.service.binder;

import java.beans.PropertyEditorSupport;

import ua.service.impl.SizeServiceImpl;

public class SizeEditor extends PropertyEditorSupport{
	private final SizeServiceImpl sizeServiceImpl;

	public SizeEditor(SizeServiceImpl sizeServiceImpl) {
		this.sizeServiceImpl = sizeServiceImpl;
	}
	
	public void setAsText(String text) throws IllegalArgumentException{
		setValue(sizeServiceImpl.findById(Integer.parseInt(text)));
	}
}
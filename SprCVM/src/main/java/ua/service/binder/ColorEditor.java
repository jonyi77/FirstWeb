package ua.service.binder;

import java.beans.PropertyEditorSupport;

import ua.service.impl.ColorServiceImpl;

public class ColorEditor extends PropertyEditorSupport{
	private final ColorServiceImpl colorServiceImpl;

	public ColorEditor(ColorServiceImpl colorServiceImpl) {
		this.colorServiceImpl = colorServiceImpl;
	}
	
	public void setAsText(String text) throws IllegalArgumentException{
		setValue(colorServiceImpl.findById(Integer.parseInt(text)));
	}
}

package ua.service.binder;

import java.beans.PropertyEditorSupport;

import ua.service.impl.StyleServiceImpl;

public class StyleEditor extends PropertyEditorSupport{
	private final StyleServiceImpl styleServiceImpl;

	public StyleEditor(StyleServiceImpl styleServiceImpl) {
		this.styleServiceImpl = styleServiceImpl;
	}
	
	public void setAsText(String text) throws IllegalArgumentException{
		setValue(styleServiceImpl.findById(Integer.parseInt(text)));
	}
}

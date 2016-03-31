package ua.service.binder;

import java.beans.PropertyEditorSupport;

import ua.service.impl.TypeServiceImpl;

public class TypeEditor extends PropertyEditorSupport{
	private final TypeServiceImpl typeServiceImpl;

	public TypeEditor(TypeServiceImpl typeServiceImpl) {
		this.typeServiceImpl = typeServiceImpl;
	}
	
	public void setAsText(String text) throws IllegalArgumentException{
		setValue(typeServiceImpl.findById(Integer.parseInt(text)));
	}
}
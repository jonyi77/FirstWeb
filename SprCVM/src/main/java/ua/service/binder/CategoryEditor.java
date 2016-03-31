package ua.service.binder;

import java.beans.PropertyEditorSupport;

import ua.service.impl.CategoryServiceImpl;

public class CategoryEditor extends PropertyEditorSupport{
	private final CategoryServiceImpl categoryServiceImpl;

	public CategoryEditor(CategoryServiceImpl categoryServiceImpl) {
		this.categoryServiceImpl = categoryServiceImpl;
	}
	
	public void setAsText(String text) throws IllegalArgumentException{
		setValue(categoryServiceImpl.findById(Integer.parseInt(text)));
	}

}

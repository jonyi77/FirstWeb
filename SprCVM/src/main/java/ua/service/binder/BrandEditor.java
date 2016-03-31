package ua.service.binder;

import java.beans.PropertyEditorSupport;

import ua.service.impl.BrandServiceImpl;

public class BrandEditor extends PropertyEditorSupport{
	private final BrandServiceImpl brandServiceImpl;

	public BrandEditor(BrandServiceImpl brandServiceImpl) {
		this.brandServiceImpl = brandServiceImpl;
	}
	
	public void setAsText(String text) throws IllegalArgumentException{
		setValue(brandServiceImpl.findById(Integer.parseInt(text)));
	}
}

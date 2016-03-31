package ua.service.binder;

import java.beans.PropertyEditorSupport;

import ua.service.impl.ArticleServiceImpl;

public class ArticleEditor extends PropertyEditorSupport{
	private final ArticleServiceImpl articleServiceImpl;
	
	public ArticleEditor (ArticleServiceImpl articleServiceImpl){
		this.articleServiceImpl = articleServiceImpl;
	}
	
	public void setAsText(String text) throws IllegalArgumentException{
		setValue(articleServiceImpl.findById(text));
	}

}

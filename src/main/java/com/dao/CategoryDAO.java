package com.dao;

import java.util.List;

import com.model.Category;

public interface CategoryDAO {

	public boolean addCategory(Category category);
	public Category getCategory(int cid);
	List<Category> getAllCategories();
}

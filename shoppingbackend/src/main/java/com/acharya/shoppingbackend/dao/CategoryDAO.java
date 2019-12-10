package com.acharya.shoppingbackend.dao;

import java.util.List;

import com.acharya.shoppingbackend.dto.Category;

public interface CategoryDAO {

	boolean add(Category category);
	Category get(int id);
	List<Category> list();
	boolean update(Category category);
	boolean delete(Category category);
	


}

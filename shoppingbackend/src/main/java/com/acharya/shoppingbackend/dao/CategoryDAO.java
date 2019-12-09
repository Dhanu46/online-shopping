package com.acharya.shoppingbackend.dao;

import java.util.List;

import com.acharya.shoppingbackend.dto.Category;

public interface CategoryDAO {

	
	List<Category> list();
	Category get(int id);


}

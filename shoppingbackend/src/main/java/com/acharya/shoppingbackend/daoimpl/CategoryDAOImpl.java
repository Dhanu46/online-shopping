package com.acharya.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.acharya.shoppingbackend.dao.CategoryDAO;
import com.acharya.shoppingbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<>();
	
	static {
		Category category = new Category();
		
		//adding first category
		category.setId(1);
		category.setName("Telivision");
		category.setDescription("this is TV");
		category.setImageURL("cat_1.png");
		
		categories.add(category);
	
		category = new Category();
		
		//adding second category
		category.setId(2);
		category.setName("Laptop");
		category.setDescription("this is LAPTOP");
		category.setImageURL("cat_2.png");
		
		categories.add(category);
		
		category = new Category();
		
		//adding third category
		category.setId(3);
		category.setName("Mobile");
		category.setDescription("this is MOBILE");
		category.setImageURL("cat_3.png");
	
		categories.add(category);
	}
	
	
	
	@Override
	public List<Category> list() {
		
		return categories;
	}
	
	@Override
	public Category get(int id) {
		
		for(Category category:categories) {
			
			if(category.getId()==id) {
			return category;
	}
		}
		return null;
	}
}

package com.acharya.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.acharya.shoppingbackend.dao.CategoryDAO;
import com.acharya.shoppingbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	private Category category;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.acharya.shoppingbackend");
		context.refresh();

		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	/*
	 * @Test public void testAddCategory() {
	 * 
	 * category = new Category(); category.setName("Television");
	 * category.setDescription("this is some description about TV");
	 * category.setImageURL("cat_1.png");
	 * 
	 * assertEquals("Succesfully added a category inside the table", true,
	 * categoryDAO.add(category));
	 * 
	 * category = new Category(); category.setName("Mobile");
	 * category.setDescription("this is some description about Mobile");
	 * category.setImageURL("cat_2.png");
	 * 
	 * assertEquals("Succesfully added a category inside the table", true,
	 * categoryDAO.add(category));
	 * 
	 * category = new Category(); category.setName("Laptop");
	 * category.setDescription("this is some description about Laptop");
	 * category.setImageURL("cat_3.png");
	 * 
	 * assertEquals("Succesfully added a category inside the table", true,
	 * categoryDAO.add(category));
	 * 
	 * }
	 */
	/*
	 * @Test public void testGetCategory() {
	 * 
	 * category = categoryDAO.get(1);
	 * assertEquals("successfully fetched a single category from the table!"
	 * ,"Television",category.getName()); }
	 */

	/*
	 * @Test public void testUpdateCategory() {
	 * 
	 * category = categoryDAO.get(1); category.setName("TV");
	 * assertEquals("successfully updated  single category in the table!"
	 * ,true,categoryDAO.update(category));
	 * 
	 * }
	 * 
	 */

	/*
	 * @Test public void testDeleteCategory() {
	 * 
	 * category = categoryDAO.get(1);
	 * 
	 * assertEquals("successfully deleted  single category in the table!",true,
	 * categoryDAO.delete(category));
	 * 
	 * }
	 * 
	 */

	/*
	 * @Test public void testListCategory() {
	 * 
	 * category = categoryDAO.get(1);
	 * 
	 * assertEquals("successfully fetched list of categories from the table!",3,
	 * categoryDAO.list().size());
	 * 
	 * }
	 */
	
	@Test
	public void testCRUDCategory() {
		
		//add category test
		  category = new Category();
		  category.setName("Television");
		  category.setDescription("this is some description about TV");
		  category.setImageURL("cat_1.png");
		  
		  assertEquals("Succesfully added a category inside the table", true,
		  categoryDAO.add(category));
		  
		  category = new Category();
		  category.setName("Mobile");
		  category.setDescription("this is some description about Mobile");
		  category.setImageURL("cat_2.png");
		  
		  assertEquals("Succesfully added a category inside the table", true,
		  categoryDAO.add(category));
		 
		  
		  //fetching and updating category
		
		  category = categoryDAO.get(1);
		  category.setName("TV");
		  assertEquals("successfully updated  single category in the table!"
		  ,true,categoryDAO.update(category));
		  
		  
		  //delete the category
		  
		
		  category = categoryDAO.get(1);
		  assertEquals("successfully deleted  single category in the table!",true,
		  categoryDAO.delete(category));
		  
		  
		  //fetching the list
		  
		
		  category = categoryDAO.get(1);
		  assertEquals("successfully fetched list of categories from the table!",1,
		  categoryDAO.list().size());
		 
		  
		 
		 
		 
	}
	  
	 

}

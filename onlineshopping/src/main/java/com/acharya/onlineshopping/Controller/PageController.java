package com.acharya.onlineshopping.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.acharya.onlineshopping.exception.ProductNotFoundException;
import com.acharya.shoppingbackend.dao.CategoryDAO;
import com.acharya.shoppingbackend.dao.ProductDAO;
import com.acharya.shoppingbackend.dto.Category;
import com.acharya.shoppingbackend.dto.Product;

@Controller
public class PageController {
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	


	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		
		logger.info("Inside PaeController index method -INFO");
		logger.debug("Inside PaeController index method -DEBUG");
		
		
		mv.addObject("userClickHome", true);

		mv.addObject("categories", categoryDAO.list());
		return mv;
	}

	@RequestMapping(value = "/about")
	public ModelAndView about() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		return mv;
	}

	@RequestMapping(value = "/contact")
	public ModelAndView contact() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact", true);
		return mv;
	}

	/*
	 * Methods to load all the products and based on category
	 */
	@RequestMapping(value = { "/show/all/products" })
	public ModelAndView showAllProdcuts() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Products");
		mv.addObject("userClickAllProducts", true);

		// passing the list of categories
		mv.addObject("categories", categoryDAO.list());
		return mv;
	}

	@RequestMapping(value = { "/show/category/{id}/products" })
	public ModelAndView showCategoryProdcuts(@PathVariable("id") int id) {

		ModelAndView mv = new ModelAndView("page");

		// categoryDAO to fetch single category
		Category category = null;

		category = categoryDAO.get(id);

		mv.addObject("title", category.getName());
		// passing the list of categories

		mv.addObject("categories", categoryDAO.list());

		// passing the single category object
		mv.addObject("category", category);

		mv.addObject("userClickCategoryProducts", true);

		return mv;
	}

	/*
	 * @RequestMapping(value="/test") public ModelAndView
	 * test(@RequestParam(value="greeting", required=false)String greeting) {
	 * if(greeting==null) { greeting = "hello there"; }
	 * 
	 * ModelAndView mv = new ModelAndView("page");
	 * mv.addObject("greeting",greeting); return mv;
	 * 
	 * @RequestMapping(value="/test/{greeting}") public ModelAndView
	 * test(@PathVariable(value="greeting") String greeting) { if(greeting==null) {
	 * greeting = "hello there"; }
	 * 
	 * ModelAndView mv = new ModelAndView("page");
	 * mv.addObject("greeting",greeting); return mv; }
	 */
	
	/* viewing a single product */
	
	@RequestMapping(value="/show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable int id) throws ProductNotFoundException {
		
		ModelAndView mv = new ModelAndView("page");
		
		Product product = productDAO.get(id);
		
		if(product==null) throw new ProductNotFoundException();
		
		//updating the view count
		product.setViews(product.getViews()+1);
		productDAO.update(product);
		//---------------
		
		mv.addObject("title", product.getName());
		mv.addObject("product", product);
		
		mv.addObject("userClickShowProduct", true);
		
		
		return mv;
		
		
	}
	
	
	
	
	
	
	
	
	

}

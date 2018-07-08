package com.E_Cart.Category;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dao.CategoryDAO;
import com.model.Category;

public class CategoryTestcase {


	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDao;
	private Category category;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
		categoryDao = (CategoryDAO) context.getBean("categoryDao");
	}

	@Ignore	
	@Test
	public void testAddCategory() {
		category = new Category();
		category.setCname("Mobiles");
		assertEquals("Successfully added a supplier details into the table", true, categoryDao.addCategory(category));
	}
@Ignore
	@Test
	 public void testGetSupplier(){
	 category=categoryDao.getCategory(6);
	 assertEquals("Successfully fetched a supplier details from the table","Electronics",category.getCname());
	 }
//@Ignore
	@Test
	public void testGetAllSupplier() {
		List<Category> listCategories = categoryDao.getAllCategories();
		assertEquals("Successfully fetched all supplier details from the table",2, categoryDao.getAllCategories().size());
		System.out.println("<======List of Blog fetched======>");
		for (Category cate : listCategories) {
			System.out.println(" Category ID :" + cate.getCid());
			System.out.println("Category Name :" + cate.getCname());	
		}
		System.out.println("<-----------Successfully retrieved list of blog-------->");
	}


}

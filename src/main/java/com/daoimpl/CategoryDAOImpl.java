package com.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.dao.CategoryDAO;
import com.model.Category;

@Repository("categoryDao")
public class CategoryDAOImpl implements CategoryDAO {

	private SessionFactory sessionFactory;

	public CategoryDAOImpl(SessionFactory sf) {
		super();
		this.sessionFactory = sf;
	}

	public boolean addCategory(Category category) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			session.saveOrUpdate(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			session.getTransaction().commit();
			session.close();
		}

	}

	public Category getCategory(int cid) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Category category = (Category) session.get(Category.class, cid);
		session.getTransaction().commit();
		session.close();
		return category;
	}

	public List<Category> getAllCategories() {
		List<Category> catList = new ArrayList<Category>();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		Query<Category> query = session.createQuery("FROM Category");
		catList = query.list();
		session.getTransaction().commit();
		session.close();
		return catList;
	}
}

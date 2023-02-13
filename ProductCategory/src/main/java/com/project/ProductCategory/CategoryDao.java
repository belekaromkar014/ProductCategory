package com.project.ProductCategory;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Repository
public class CategoryDao {
	@Autowired
	SessionFactory sessionFactory;
	
	public void insertCatData(Category category) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(category);
		transaction.commit();
	}

	public List<Category> getAllCatData() {
		List<Category> list = sessionFactory.openSession().createCriteria(Category.class).list();
		return list;
	}

	public Category getCatDataById(int cid) {
		Session session = sessionFactory.openSession();
		Category category = session.get(Category.class, cid);
		return category;
	}
	 
	public void updateCatData(Category category) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(category);
		transaction.commit();
	}
	
	public void deleteCatData(int cid) {
		Session session = sessionFactory.openSession();
		Category category = session.get(Category.class, cid);
		Transaction transaction = session.beginTransaction();
		session.delete(category);
		transaction.commit();
	}

}

package com.project.ProductCategory;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Service
public class CategoryService {
	@Autowired
	CategoryDao categoryDao;
	
	public void insertCatData(Category category) {
		categoryDao.insertCatData(category);
	}

	public List<Category> getAllCatData() {
		List<Category> list = categoryDao.getAllCatData();
		return list;
	}

	public Category getCatDataById(int cid) {
		Category category = categoryDao.getCatDataById(cid);
		return category;
	}
	 
	public void updateCatData(Category category) {
		categoryDao.updateCatData(category);
	}
	
	public void deleteCatData(int cid) {
		categoryDao.deleteCatData(cid);
	}
	

}

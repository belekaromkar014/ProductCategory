package com.project.ProductCategory;

import java.util.List;

import javax.websocket.server.PathParam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("categoryapi")
public class CategoryController {
	@Autowired
	CategoryService CategoryService;
	
	@PostMapping("category")
	public Category insertCatData(Category category) {
		CategoryService.insertCatData(category);
		return category;
	}

	@GetMapping("category")
	public List<Category> getAllCatData() {
		List<Category> list = CategoryService.getAllCatData();
		return list;
	}

	@GetMapping("category/{cid}")
	public Category getCatDataById(int cid) {
		Category category = CategoryService.getCatDataById(cid);
		return category;
	}
	
	@PutMapping("category") 
	public String updateCatData(Category category) {
		CategoryService.updateCatData(category);
		return "Record Updated";
	}
	
	@DeleteMapping("category/{cid}")
	public String deleteCatData(int cid) {
		CategoryService.deleteCatData(cid);
		return "Record Deleted";
	}
}

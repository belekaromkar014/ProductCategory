package com.project.ProductCategory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ProductService {
	@Autowired
	ProductDao productDao;

	public void insertProdData(@RequestBody Product product, @PathVariable int cid) {
		productDao.insertProdData(product, cid);
	}

	public List getAllProdData() {
		List<Object[]> list2 = productDao.getAllProdData();
		return list2;
	}

	public String getProdDataById(@PathVariable int pid) {
		String string = productDao.getProdDataById(pid);
		return string;
	}

	public void UpdateProdData(@RequestBody Product product) {
		productDao.UpdateProdData(product);
	}

	public void DeleteProdData(int pid) {
		productDao.DeleteProdData(pid);
	}
	
//	public List<Object[]> getProdDataByCat(int cid) {
//		List<Object[]> list = productDao.getProdDataByCat(cid);
//	    return list;
//	}
}

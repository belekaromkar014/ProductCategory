package com.project.ProductCategory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class ProductDao {
	@Autowired
	SessionFactory sessionFactory;

	public Product insertProdData(Product product,int cid) {
		Session session = sessionFactory.openSession();
		Category category = session.load(Category.class, cid);
		List<Product> list = category.getProducts();
		Transaction transaction = session.beginTransaction();
		list.add(product);
		transaction.commit();
		return product;
	}

	public List getAllProdData() {
		Session session = sessionFactory.openSession();
		NativeQuery<Object[]> query = session.createSQLQuery(
				"select product.pid, product.pname, product.price, category.name from category,product where product.cid=category.cid");
		List<Object[]> list = query.list();
		// StringBuffer stringBuffer = new StringBuffer("");
		List<Object[]> list2 = new ArrayList<Object[]>();

		for (int i = 0; i < list.size(); i++) {
			Object[] array = list.get(i);
			// stringBuffer.append(Arrays.toString(array));
			list2.add(array);
		}
		// String string =stringBuffer.toString();
		return list2;
	}

	public String getProdDataById(int pid) {
		Session session = sessionFactory.openSession();
		NativeQuery<Object[]> query = session.createSQLQuery(
				"select product.pid, product.pname, product.price,category.cid, category.name from category, product where category.cid=product.cid and product.pid="
						+ pid);
		List<Object[]> list = query.list();
		Object[] array = list.get(0);
		return Arrays.toString(array);
	}

	public void UpdateProdData(Product product) {
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(product);
		Transaction transaction = session.beginTransaction();
		transaction.commit();
	}
	
	public void DeleteProdData(int pid) {
		Session session = sessionFactory.openSession();
		Product product = session.get(Product.class, pid);
        session.delete(product);	
	    Transaction transaction = session.beginTransaction();
	    transaction.commit();
	}
	
//	public List<Object[]> getProdDataByCat(int cid) {
//		Session session = sessionFactory.openSession();
//		NativeQuery<Object[]> query = session.createSQLQuery("select product.pid, product.pname, product.price, category.cname from category,product where category.cid=product.pid and cid="+cid);
//	    List<Object[]> list = query.list();
//		List<Object[]> list2 = new ArrayList<Object[]>();
//		for(int i=0; i<list.size(); i++) {
//			Object[] array = list.get(i);
//			list2.add(array);
//		}
//	    return list2;
//	}

		

}

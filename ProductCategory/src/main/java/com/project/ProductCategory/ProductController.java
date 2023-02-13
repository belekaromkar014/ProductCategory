package com.project.ProductCategory;

import java.util.ArrayList;
import java.util.List;

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
//@RequestMapping("productapi")
public class ProductController {
	@Autowired
	ProductService productService;
	
	@GetMapping("demo")
	public List<Product> get (){
		List<Product> list = new ArrayList<Product>();
		list.add(new Product(12, "biskut", 10));
		
		return list;
	}
	
	@PostMapping("product/{cid}")
	public Product insertProdData(@RequestBody Product product , @PathVariable int cid) {
		productService.insertProdData(product, cid);
		return product;
	}
	
	@GetMapping("product")
	public List getAllProdData(){
		List<Object[]> list2 = productService.getAllProdData();
		return list2;
	}
	
	@GetMapping("product/{pid}")
	public String getProdDataById(@PathVariable int pid) {
	 	String string = productService.getProdDataById(pid);
		return string;
	}
	
	@PutMapping("product")
	public String UpdateProdData(@RequestBody Product product) {
		productService.UpdateProdData(product);
		return "Record Updated";
	}
	
	@DeleteMapping("product/{pid}")
	public String DeleteProdData(@PathVariable int pid) {
		productService.DeleteProdData(pid);
		return "Product Deleted";
	}
	
//	@GetMapping("productcat/{cid}")
//	public List<Object[]> getProdDataByCat(@PathVariable int cid) {
//		List<Object[]> list = productService.getProdDataByCat(cid);
//	    return list;
//	}


}

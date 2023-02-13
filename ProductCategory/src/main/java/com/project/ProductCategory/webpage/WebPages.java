package com.project.ProductCategory.webpage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.ProductCategory.ProductController;
import com.project.ProductCategory.ProductDao;

@Controller
public class WebPages {
	@RequestMapping("index")
	public String index () {
		return "index";
	}
	
}

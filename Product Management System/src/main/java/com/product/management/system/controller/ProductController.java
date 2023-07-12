package com.product.management.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.product.management.system.entity.ProductEntity;
import com.product.management.system.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/")
	public ModelAndView viewHomePage(Model model)
	{
		ModelAndView model1 = new ModelAndView();
		List<ProductEntity> list = productService.listAll();
		model.addAttribute("listProducts", list);
		model1.setViewName("index");
		return model1;
	}
	
	@RequestMapping("/new")
	public String showNewProduct(Model model)
	{
		ProductEntity product= new ProductEntity();
		model.addAttribute("product", product);
		return "new_product";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") ProductEntity productEntity)
	{  
		productService.save(productEntity);
		return "redirect:/";
	}
	   
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductPage(@PathVariable("id") int id)
	{
		
		ModelAndView modelAndView= new ModelAndView("edit_product");
		ProductEntity product=productService.getProductBasedOnId(id);
		modelAndView.addObject("product", product);
		return modelAndView;
	}      
	
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable("id") int id)
	{
		productService.deleteBasedOnId(id);
		return "redirect:/";
	}

}

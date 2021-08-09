package com.phoenix.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.phoenix.entities.Product;
import com.phoenix.exceptions.ProductNotFoundException;
import com.phoenix.services.ProductService;

/*
 * @author kashish.jain@stltech.in
 * @version 1.0
 * @creation_date 02-Aug-2021
 * @copyright Sterlite Technologies Ltd.
 */

@Controller
public class ProductController {
	
	@Autowired
	private ProductService proService;
	
	@GetMapping("/products")
	public String displayProducts(ModelMap map,HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session != null) {
			List<Product> pro = proService.getAllProducts();
			session.setAttribute("product",pro);
			return "redirect:/products.jsp";
		}
		else {
			return "redirect:/SessionExpire.jsp";
		}
	}
	
	@GetMapping("/update")
	public String updateProduct(Product pro,ModelMap map,HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session != null) {
			try {
				Product p = proService.findById(pro.getId());
				p.setBrand(pro.getBrand());
				p.setName(pro.getName());
				p.setPrice(pro.getPrice());
				//map.addAttribute("chP", "Product with id: "+pro.getId()+" Updated successfully");
				session.setAttribute("chP", "Product with id: "+pro.getId()+" Updated successfully");
				proService.edit(p);
				return "redirect:/products";
			} catch (ProductNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "redirect:/SessionExpire.jsp";
	}
	
	@GetMapping("/delete")
	public String deleteProduct(int id,ModelMap map,HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session != null) {
			try {
				Product p = proService.findById(id);
				map.addAttribute("chP", "Product with id: "+p.getId()+" Deleted successfully");
				session.setAttribute("chP", "Product with id: "+p.getId()+" Deleted successfully");
				proService.remove(p);
				return "redirect:/products";
			} catch (ProductNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//map.addAttribute("pnf", e.getMessage());
				return "delete.jsp";
			}
		}
		return "redirect:/SessionExpire.jsp";
	}
	
	@GetMapping("/insert")
	public String insertProduct(Product pro,ModelMap map,HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session != null) {
			proService.add(pro);
			//map.addAttribute("chP", "Product with id: "+pro.getId()+" insered successfully");
			session.setAttribute("chP", "Product with id: "+pro.getId()+" inserted successfully");
			return "redirect:/products";
		}
		return "redirect:/SessionExpire.jsp";
	}
	
	@PostMapping("/sort")
	public String sort(ModelMap map,HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session!=null) {
			String s = (String)session.getAttribute("s");
			List<Product> pros = (List<Product>)session.getAttribute("product");
			if(s!=null) {
				if(s.equals("Name"))
					pros = proService.sortByName(pros);
				else if(s.equals("Brand"))
					pros = proService.sortByBrand(pros);
				else if(s.equals("Price"))
					pros = proService.sortByPrice(pros);
				else if(s.equals("PriceDesc"))
					pros = proService.sortByPriceDesc(pros);
			}
			session.setAttribute("product", pros);
			return "products.jsp";
		}
		else {
			return "redirect:/SessionExpire.jsp";
		}
	}
	
}

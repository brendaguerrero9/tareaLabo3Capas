package com.uca.capas.tarea3Capas.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.tarea3Capas.domain.Product;

@Controller 
public class ProductController {
	private List<Product> productos = new ArrayList<Product>();
	
	@GetMapping("/compraProducto")
	public ModelAndView compraProducto() {
		ModelAndView mav = new ModelAndView();
		productos.add(new Product(0, "Leche" , 50));
		productos.add(new Product(1, "Cereal" , 80));
		productos.add(new Product(2, "Galletas" , 40));
		productos.add(new Product(3, "Huevos" , 70));
		productos.add(new Product(4, "Queso" , 30));
		
		mav.setViewName("select");
		mav.addObject("product", new Product());
		mav.addObject("producto", productos);
		return mav;

	}
	
	@PostMapping("/validar")
	public ModelAndView validar(Product product) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("producto", productos.get(product.getId()).getNombre());
		
		if( product.getCantidad() > productos.get(product.getId()).getCantidad()) {
			mav.setViewName("error");
			
		}else {
			mav.setViewName("compra");
		}
		return mav;
		
	}
	
	
}


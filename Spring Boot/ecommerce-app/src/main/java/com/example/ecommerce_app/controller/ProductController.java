package com.example.ecommerce_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.ecommerce_app.model.Product;
import com.example.ecommerce_app.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	@GetMapping("/product-home")
	public String showHomePage(Model model) {
		List<Product> productList = productService.getAllProducts();
		System.out.println(" product list "+productList.size());
		model.addAttribute("productList", productList);
		return "product-home";
	}
	@GetMapping("/add-product")
	public String showAddProductPage(Model model) {
		Product p = new Product();
		model.addAttribute("product", p);
		return "add-product";
	}
	 @PostMapping("/save-product")
	    public String saveProduct(@ModelAttribute("product") Product product) {
	    	System.out.println(" inside save Product "+product);
	    	productService.saveProduct(product);
	    	return "redirect:/product-home";
	 }
	 @GetMapping("/edit-product/{id}")
	 public String showEditProduct(Model model, @PathVariable Long id) {
		 Product product = productService.getProductById(id);
		 model.addAttribute("product", product);
		 return "edit-product";
	 }
	 @PostMapping("/update-product")
	    public String updateProduct(@ModelAttribute("product") Product product) {
	    	System.out.println(" inside save Product "+product);
	    	Product existingProduct = productService.getProductById(product.getId());
	    	existingProduct.setName(product.getName());
	    	existingProduct.setPrice(product.getPrice());
	    	
	    	productService.saveProduct(existingProduct);
	    	return "redirect:/product-home";
	    }
	 @GetMapping("/delete-product/{id}")
	 public String showDeleteProduct( @PathVariable Long id) {
		 Product product = productService.getProductById(id);
		 productService.deleteProduct(id);
		// model.addAttribute("customer", customer);
		 return "redirect:/product-home";
	 }
}

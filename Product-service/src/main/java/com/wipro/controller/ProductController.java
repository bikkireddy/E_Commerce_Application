package com.wipro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.dto.ProductDto;
import com.wipro.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
@Tag(
		name="CRUD Operations REST APIs for Product Service" ,
		description="REST APIs for Create product, Get the product, Update the product, Delete the product, etc.. ")
@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	
	@Operation(
			summary="ADD the New product ",
			description="Create the new products"
			) 
	@PostMapping("/product")
	public ProductDto createProducts(@RequestBody ProductDto prodcutDto) {
		return productService.createProduct(prodcutDto);
	}
	
	
	@Operation(
			summary="Get the product",
			description="Get the product details by it ID"
			)
	@GetMapping("/product/{id}")
	public ProductDto getProductById(@PathVariable("id") Long id) {
		return productService.getProductById(id);
	}
	
	
	@Operation(
			summary="Get the All Products ",
			description=" Get the details of all the products"
			) 
	@GetMapping("/getallproducts")
	public List<ProductDto> getAllProducts(){
		return productService.getAllProducts();
	}
	
	
	@Operation(
			summary="Get the Product By Category",
			description="Get the product details by its category"
			) 
	@GetMapping("/getproductsbycategory/query")
	public List<ProductDto> getProductsByCategory(@RequestParam String category){
		return productService.getProductByCategory(category);		
	}
	
	
	@Operation(
			summary="Delete the product",
			description="Delete the product by its id"
			) 
	@DeleteMapping("/product/{id}")
	public String deleteProductById(@PathVariable("id") Long id) {
		return productService.deleteProductById(id);
	}
	
	
	@Operation(
			summary="Update the product",
			description="To Update the product details by its id"
			) 
	@PutMapping("/product/{id}")
	public ProductDto updateProductById(@PathVariable("id") Long id, @RequestBody ProductDto productDto) {
		return productService.updateProduct(id, productDto);
	}
	
	
	@Operation(
			summary="Get the products by avilability",
			description="Get the product details by its availability"
			) 
	@GetMapping("/getproductsbyavailability/query")
	public List<ProductDto> getProductsByAvailability(@RequestParam boolean available){
		return productService.getProductByAvailabilty(available);
	}
}

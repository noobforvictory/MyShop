package com.lcwd.store.services;

import java.util.List;

import com.lcwd.store.dtos.ProductDto;


public interface ProductServices {

	ProductDto addProduct(ProductDto productDto);
	
	ProductDto updateProduct(ProductDto productDto,String productDtoId);
	
	void deleteProduct(String  productDtoId);
	
	ProductDto getProduct(String  productDtoId);
	
	List<ProductDto> getAllProduct();
	
	List<ProductDto> searchProduct(int keyword);
}

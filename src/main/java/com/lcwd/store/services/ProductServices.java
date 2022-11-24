package com.lcwd.store.services;

import java.util.List;

import com.lcwd.store.dtos.ProductDto;


public interface ProductServices {

	ProductDto addProduct(ProductDto productDto);
	
	ProductDto updateProduct(ProductDto productDto,int productDtoId);
	
	void deleteProduct(int productDtoId);
	
	ProductDto getProduct(int productDtoId);
	
	List<ProductDto> getAllProduct();
	
	List<ProductDto> searchProduct(String keyword);
}

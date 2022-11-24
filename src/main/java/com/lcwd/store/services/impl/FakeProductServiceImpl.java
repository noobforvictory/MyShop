package com.lcwd.store.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.store.dtos.ProductDto;
import com.lcwd.store.entities.Product;
import com.lcwd.store.exceptions.ResourceNotFoundException;
import com.lcwd.store.services.ProductServices;

@Service
public class FakeProductServiceImpl implements ProductServices{

	private List<Product> products = new ArrayList<>();
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public ProductDto addProduct(ProductDto productDto) {
		Product product = mapper.map(productDto, Product.class);
		products.add(product);
		return mapper.map(product, ProductDto.class);
	}

	@Override
	public ProductDto updateProduct(ProductDto productDto, int productDtoId) {
		List<Product> productList = products.stream().map(product -> {
			
			if(product.getId() == productDtoId) {
				product.setColour(productDto.getColour());
				product.setModel(productDto.getModel());
				product.setPrice(productDto.getPrice());
				product.setQuantity(productDto.getQuantity());
				return product;
			}else {
				return product;
			}
		}).collect(Collectors.toList());
		products = productList;
		return productDto;
	}

	@Override
	public void deleteProduct(int productDtoId) {
		List<Product> productList = products.stream()
											.filter(product -> product.getId() != productDtoId)
											.collect(Collectors.toList());
		products = productList;
		
	}

	@Override
	public ProductDto getProduct(int productDtoId) {
		Product product = products.stream()
								  .filter(product1 -> product1.getId() == productDtoId)
								  .findFirst()
								  .orElseThrow(() -> new ResourceNotFoundException("product with id not found"));
								  
		return mapper.map(product, ProductDto.class);
	}

	@Override
	public List<ProductDto> getAllProduct() {
		List<ProductDto> productDtos = products.stream()
											   .map(product -> mapper.map(product, ProductDto.class))
											   .collect(Collectors.toList());
		
		return productDtos;
	}

	@Override
	public List<ProductDto> searchProduct(String keyword) {
		List<Product> productList = products.stream()
								  .filter(product1 ->product1.getModel().contains(keyword))
								  .collect(Collectors.toList());
		List<ProductDto> productDtos = productList.stream()
												  .map(product -> mapper.map(product, ProductDto.class))
												  .collect(Collectors.toList());
		return productDtos;
	}

}

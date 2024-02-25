package com.acc.products.controller;

import com.acc.products.dto.ProductDto;
import com.acc.products.dto.ReviewDto;
import com.acc.products.entity.Product;
import com.acc.products.entity.Review;
import com.acc.products.mapper.ProductMapStructMapper;
import com.acc.products.mapper.ProductMapper;
import com.acc.products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductMapStructMapper productMapStructMapper;
    private final ProductService productService;

    public ProductController(ProductService productService, ProductMapStructMapper productMapStructMapper) {
        this.productService = productService;
        this.productMapStructMapper = productMapStructMapper;
    }


    @GetMapping("/getByBrand")
    public ResponseEntity<List<ProductDto>> getProductsByBrand(@RequestParam String brand) {

        List<Product> productsList = productService.getProductsByBrand(brand);

        List<ProductDto> productDtosList = productMapStructMapper.toDtoList(productsList);

        return ResponseEntity.ok(productDtosList);
    }


    @PostMapping("/save")
    public ResponseEntity<String> saveProduct(@RequestBody ProductDto productDto) {
        try {
            productService.saveProduct(productDto);
            return new ResponseEntity<>("Product saved successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to save product: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}


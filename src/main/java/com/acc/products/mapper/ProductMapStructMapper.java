package com.acc.products.mapper;

import com.acc.products.dto.ProductDto;
import com.acc.products.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;


@Mapper(componentModel = "spring")
public interface ProductMapStructMapper
{
    @Mapping(target = "prodId", source = "productId")
    @Mapping(target = "desc", source = "description")
    @Mapping(target = "name", source = "productName")
    ProductDto toDto(Product product);

    Product fromDto(ProductDto productDto);

    List<ProductDto> toDtoList(List<Product> products);

}

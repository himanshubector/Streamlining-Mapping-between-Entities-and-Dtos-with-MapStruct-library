package com.acc.products.dto;

import com.acc.products.entity.ProductDetails;
import com.acc.products.entity.Review;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Data
public class ProductDto
{
    private int prodId;
    private String name;
    private String brand;
    private String desc;
    private String manufacturer;

    private ProductDetailsDto productDetails;

    private List<ReviewDto> reviews;
    private List<RatingDto> ratings;
}

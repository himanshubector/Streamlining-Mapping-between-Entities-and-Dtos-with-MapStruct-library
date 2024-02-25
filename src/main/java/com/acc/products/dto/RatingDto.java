package com.acc.products.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RatingDto
{
    @JsonProperty("id")
    private long id;

    @JsonProperty("ratingValue")
    private double ratingValue;

}

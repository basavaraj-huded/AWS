package com.basavaraj.productservice.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@Data
public class Coupon {
    private long id;
    private String code;
    private BigDecimal discount;
    private String expDate;
}

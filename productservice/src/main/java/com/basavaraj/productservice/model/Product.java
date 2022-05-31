package com.basavaraj.productservice.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private BigDecimal price;
    @Transient
    private String couponCode;
}

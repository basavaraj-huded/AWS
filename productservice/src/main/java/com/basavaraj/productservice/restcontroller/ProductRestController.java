package com.basavaraj.productservice.restcontroller;

import com.basavaraj.productservice.dto.Coupon;
import com.basavaraj.productservice.model.Product;
import com.basavaraj.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/productapi")
public class ProductRestController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private RestTemplate restTemplate;
    @Value("${couponService.url}")
    private String couponServiceURl;

    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product){
        Coupon coupon = restTemplate.getForObject(couponServiceURl + product.getCouponCode(), Coupon.class);
        product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
        return productRepository.save(product);
    }
}

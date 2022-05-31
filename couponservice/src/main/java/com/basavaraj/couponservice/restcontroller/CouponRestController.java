package com.basavaraj.couponservice.restcontroller;

import com.basavaraj.couponservice.model.Coupon;
import com.basavaraj.couponservice.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/couponapi")
public class CouponRestController {

    @Autowired
    CouponRepository couponRepository;

    @PostMapping("/coupons")
    public Coupon createCoupon(@RequestBody Coupon coupon){
        return couponRepository.save(coupon);
    }
    @GetMapping("/coupon/{code}")
    public Coupon getCoupon(@PathVariable("code") String code){
        return couponRepository.findByCode(code);
    }

}

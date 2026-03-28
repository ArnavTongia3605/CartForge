package com.cartforge.controller;

import com.cartforge.model.Cart;
import com.cartforge.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping
    public Cart addToCart(@RequestBody Cart cart) {
        return cartService.addToCart(cart);
    }

    @GetMapping("/{userId}")
    public List<Cart> getUserCart(@PathVariable Long userId) {
        return cartService.getUserCart(userId);
    }
}
package com.cartforge.controller;

import com.cartforge.model.Cart;
import com.cartforge.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.context.SecurityContextHolder;
import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping
    public Cart addToCart(@RequestBody Cart cart) {

        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        return cartService.addToCart(cart, email);
    }

    @GetMapping
    public List<Cart> getCart() {

        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        return cartService.getUserCart(email);
    }

    @PutMapping("/{productId}")
    public Cart updateQuantity(@PathVariable Long productId, @RequestBody Cart cart) {

        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        return cartService.updateQuantity(productId, cart.getQuantity(), email);
    }

    @DeleteMapping("/{productId}")
    public void removeItem(@PathVariable Long productId) {

        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        cartService.removeItem(productId, email);
    }
}
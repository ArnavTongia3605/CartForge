package com.cartforge.service;

import com.cartforge.model.Cart;
import com.cartforge.model.User;
import com.cartforge.repository.CartRepository;
import com.cartforge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private UserRepository userRepository;

    public Cart addToCart(Cart cart, String email) {

        if (cart == null) throw new RuntimeException("Cart cannot be null");
        if (cart.getProductId() == null) throw new RuntimeException("ProductId required");
        if (cart.getQuantity() <= 0) throw new RuntimeException("Quantity must be > 0");

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        cart.setUserId(user.getId());

        return cartRepository.save(cart);
    }

    public List<Cart> getUserCart(String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return cartRepository.findByUserId(user.getId());
    }
    public Cart updateQuantity(Long productId, int quantity, String email) {

        User user = userRepository.findByEmail(email).orElseThrow();

        Cart cart = cartRepository.findByUserIdAndProductId(user.getId(), productId)
                .orElseThrow(() -> new RuntimeException("Item not found"));

        cart.setQuantity(quantity);

        return cartRepository.save(cart);
    }

    public void removeItem(Long productId, String email) {

        User user = userRepository.findByEmail(email).orElseThrow();

        Cart cart = cartRepository.findByUserIdAndProductId(user.getId(), productId)
                .orElseThrow(() -> new RuntimeException("Item not found"));

        cartRepository.delete(cart);
    }
}
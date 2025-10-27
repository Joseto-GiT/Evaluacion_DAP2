package com.example.tiendaropa.data

import com.example.tiendaropa.model.CartItem
import com.example.tiendaropa.model.Product

object CartData {
    private val cartItems = mutableListOf<CartItem>()
    
    fun addToCart(product: Product, quantity: Int = 1) {
        val existingItem = cartItems.find { it.product.id == product.id }
        if (existingItem != null) {
            existingItem.quantity += quantity
        } else {
            cartItems.add(CartItem(product, quantity))
        }
    }
    
    fun removeFromCart(productId: Int) {
        cartItems.removeAll { it.product.id == productId }
    }
    
    fun updateQuantity(productId: Int, quantity: Int) {
        val item = cartItems.find { it.product.id == productId }
        if (item != null) {
            if (quantity <= 0) {
                removeFromCart(productId)
            } else {
                item.quantity = quantity
            }
        }
    }
    
    fun getCartItems(): List<CartItem> = cartItems.toList()
    
    fun getTotalPrice(): Double {
        return cartItems.sumOf { it.product.price * it.quantity }
    }
    
    fun getTotalItems(): Int {
        return cartItems.sumOf { it.quantity }
    }
    
    fun clearCart() {
        cartItems.clear()
    }
    
    fun isEmpty(): Boolean = cartItems.isEmpty()
}

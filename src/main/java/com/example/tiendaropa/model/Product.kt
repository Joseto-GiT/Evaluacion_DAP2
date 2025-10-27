package com.example.tiendaropa.model

import com.google.gson.annotations.SerializedName

data class Product(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    val category: ProductCategory,
    val imageUrl: String,
    val stock: Int = 10
)

enum class ProductCategory(val displayName: String) {
    @SerializedName("camisetas")
    TSHIRTS("Camisetas"),
    
    @SerializedName("jeans")
    JEANS("Jeans"),
    
    @SerializedName("gorras")
    CAPS("Gorras"),
    
    @SerializedName("zapatos")
    SHOES("Zapatos")
}

data class User(
    val id: Int,
    val name: String,
    val email: String,
    val rut: String,
    val password: String
)

data class CartItem(
    val product: Product,
    val quantity: Int
)

data class PurchaseResult(
    val success: Boolean,
    val message: String,
    val orderId: String? = null
)

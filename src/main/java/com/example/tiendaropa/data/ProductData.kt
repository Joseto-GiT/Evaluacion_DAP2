package com.example.tiendaropa.data

import com.example.tiendaropa.model.Product
import com.example.tiendaropa.model.ProductCategory

object ProductData {
    
    val products = listOf(
        // Camisetas
        Product(
            id = 1,
            name = "Camiseta Básica Blanca",
            description = "Camiseta de algodón 100% básica y cómoda. Perfecta para el día a día.",
            price = 15990.0,
            category = ProductCategory.TSHIRTS,
            imageUrl = "https://via.placeholder.com/300x300/FFFFFF/000000?text=Camiseta+Blanca",
            stock = 15
        ),
        Product(
            id = 2,
            name = "Camiseta Estampada",
            description = "Camiseta con estampado moderno. Material suave y resistente.",
            price = 19990.0,
            category = ProductCategory.TSHIRTS,
            imageUrl = "https://via.placeholder.com/300x300/FF6B6B/FFFFFF?text=Camiseta+Estampada",
            stock = 8
        ),
        Product(
            id = 3,
            name = "Camiseta Polo",
            description = "Camiseta polo clásica. Ideal para ocasiones semi-formales.",
            price = 24990.0,
            category = ProductCategory.TSHIRTS,
            imageUrl = "https://via.placeholder.com/300x300/4ECDC4/FFFFFF?text=Polo",
            stock = 12
        ),
        
        // Jeans
        Product(
            id = 4,
            name = "Jeans Clásicos Azules",
            description = "Jeans de corte clásico en azul índigo. Material denim de calidad.",
            price = 45990.0,
            category = ProductCategory.JEANS,
            imageUrl = "https://via.placeholder.com/300x300/4169E1/FFFFFF?text=Jeans+Azules",
            stock = 6
        ),
        Product(
            id = 5,
            name = "Jeans Negros Slim",
            description = "Jeans negros de corte slim. Modernos y versátiles.",
            price = 49990.0,
            category = ProductCategory.JEANS,
            imageUrl = "https://via.placeholder.com/300x300/2C2C2C/FFFFFF?text=Jeans+Negros",
            stock = 9
        ),
        Product(
            id = 6,
            name = "Jeans Rojos Vintage",
            description = "Jeans rojos con efecto vintage. Únicos y llamativos.",
            price = 52990.0,
            category = ProductCategory.JEANS,
            imageUrl = "https://via.placeholder.com/300x300/DC143C/FFFFFF?text=Jeans+Rojos",
            stock = 4
        ),
        
        // Gorras
        Product(
            id = 7,
            name = "Gorra Baseball Negra",
            description = "Gorra de baseball clásica en color negro. Ajustable y cómoda.",
            price = 19990.0,
            category = ProductCategory.CAPS,
            imageUrl = "https://via.placeholder.com/300x300/000000/FFFFFF?text=Gorra+Negra",
            stock = 20
        ),
        Product(
            id = 8,
            name = "Gorra Snapback Roja",
            description = "Gorra snapback en color rojo. Diseño moderno y urbano.",
            price = 22990.0,
            category = ProductCategory.CAPS,
            imageUrl = "https://via.placeholder.com/300x300/FF0000/FFFFFF?text=Gorra+Roja",
            stock = 15
        ),
        Product(
            id = 9,
            name = "Gorra Trucker Azul",
            description = "Gorra trucker en azul. Perfecta para actividades al aire libre.",
            price = 24990.0,
            category = ProductCategory.CAPS,
            imageUrl = "https://via.placeholder.com/300x300/0000FF/FFFFFF?text=Gorra+Azul",
            stock = 12
        ),
        
        // Zapatos
        Product(
            id = 10,
            name = "Zapatillas Deportivas Blancas",
            description = "Zapatillas deportivas blancas. Cómodas y versátiles para cualquier ocasión.",
            price = 79990.0,
            category = ProductCategory.SHOES,
            imageUrl = "https://via.placeholder.com/300x300/FFFFFF/000000?text=Zapatillas+Blancas",
            stock = 7
        ),
        Product(
            id = 11,
            name = "Zapatos Formales Negros",
            description = "Zapatos formales en cuero negro. Elegantes y duraderos.",
            price = 89990.0,
            category = ProductCategory.SHOES,
            imageUrl = "https://via.placeholder.com/300x300/1C1C1C/FFFFFF?text=Zapatos+Negros",
            stock = 5
        ),
        Product(
            id = 12,
            name = "Botas Marrones",
            description = "Botas de cuero marrón. Ideales para el invierno y ocasiones casuales.",
            price = 99990.0,
            category = ProductCategory.SHOES,
            imageUrl = "https://via.placeholder.com/300x300/8B4513/FFFFFF?text=Botas+Marrones",
            stock = 3
        )
    )
    
    fun getProductsByCategory(category: ProductCategory): List<Product> {
        return products.filter { it.category == category }
    }
    
    fun getProductById(id: Int): Product? {
        return products.find { it.id == id }
    }

    fun addProduct(product: Product) {
        _products.add(product)
    }
}

package com.example.tiendaropa.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.tiendaropa.data.CartData
import com.example.tiendaropa.data.ProductData
import com.example.tiendaropa.model.Product
import com.example.tiendaropa.model.ProductCategory
import com.example.tiendaropa.ui.components.CategoryChip
import com.example.tiendaropa.ui.components.ProductCard

@Composable
fun CatalogScreen(
    onProductClick: (Product) -> Unit,
    onCartClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    var selectedCategory by remember { mutableStateOf<ProductCategory?>(null) }
    val cartItemCount = remember { CartData.getTotalItems() }

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        // Top App Bar
        TopAppBar(
            title = { 
                Text(
                    "Catálogo",
                    fontWeight = FontWeight.Bold
                ) 
            },
            actions = {
                IconButton(onClick = onCartClick) {
                    Badge(
                        containerColor = MaterialTheme.colorScheme.error,
                        contentColor = MaterialTheme.colorScheme.onError
                    ) {
                        Text(cartItemCount.toString())
                    }
                    Icon(
                        imageVector = Icons.Default.ShoppingCart,
                        contentDescription = "Carrito"
                    )
                }
            }
        )
        
        // Category Filter
        LazyRow(
            modifier = Modifier.padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            item {
                CategoryChip(
                    category = ProductCategory.TSHIRTS,
                    isSelected = selectedCategory == ProductCategory.TSHIRTS,
                    onCategorySelected = { 
                        selectedCategory = if (selectedCategory == it) null else it 
                    }
                )
            }
            item {
                CategoryChip(
                    category = ProductCategory.JEANS,
                    isSelected = selectedCategory == ProductCategory.JEANS,
                    onCategorySelected = { 
                        selectedCategory = if (selectedCategory == it) null else it 
                    }
                )
            }
            item {
                CategoryChip(
                    category = ProductCategory.CAPS,
                    isSelected = selectedCategory == ProductCategory.CAPS,
                    onCategorySelected = { 
                        selectedCategory = if (selectedCategory == it) null else it 
                    }
                )
            }
            item {
                CategoryChip(
                    category = ProductCategory.SHOES,
                    isSelected = selectedCategory == ProductCategory.SHOES,
                    onCategorySelected = { 
                        selectedCategory = if (selectedCategory == it) null else it 
                    }
                )
            }
        }
        
        // Products Grid
        val filteredProducts = if (selectedCategory != null) {
            ProductData.getProductsByCategory(selectedCategory!!)
        } else {
            ProductData.products
        }
        
        if (filteredProducts.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "No hay productos en esta categoría",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        } else {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(filteredProducts) { product ->
                    ProductCard(
                        product = product,
                        onProductClick = onProductClick
                    )
                }
            }
        }
    }
}

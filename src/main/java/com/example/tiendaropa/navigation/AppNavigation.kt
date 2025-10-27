package com.example.tiendaropa.navigation

import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tiendaropa.data.ProductData
import com.example.tiendaropa.model.Product
import com.example.tiendaropa.ui.screens.*
import com.example.tiendaropa.ui.screens.BackOffice.AddProductScreen
import com.example.tiendaropa.ui.screens.BackOffice.BackOfficeScreen

@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController()
) {
    var currentUser by remember { mutableStateOf<String?>(null) }
    
    NavHost(
        navController = navController,
        startDestination = "login"
    ) {
        // Login Screen
        composable("login") {
            LoginScreen(
                onLoginSuccess = { userType ->
                    currentUser = userType
                    if (userType == "admin") {
                        navController.navigate("back_office") {
                            popUpTo("login") { inclusive = true }
                        }
                    } else {
                        navController.navigate("catalog") {
                            popUpTo("login") { inclusive = true }
                        }
                    }
                },
                onNavigateToRegister = {
                    navController.navigate("register")
                }
            )
        }
        
        // Register Screen
        composable("register") {
            RegisterScreen(
                onRegisterSuccess = {
                    navController.navigate("login") {
                        popUpTo("register") { inclusive = true }
                    }
                },
                onNavigateToLogin = {
                    navController.navigate("login")
                }
            )
        }
        
        // Catalog Screen
        composable("catalog") {
            CatalogScreen(
                onProductClick = { product ->
                    navController.navigate("product_detail/${product.id}")
                },
                onCartClick = {
                    navController.navigate("cart")
                }
            )
        }
        
        // Product Detail Screen
        composable("product_detail/{productId}") { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId")?.toIntOrNull()
            val product = productId?.let { ProductData.getProductById(it) }
            
            if (product != null) {
                ProductDetailScreen(
                    product = product,
                    onBackClick = {
                        navController.popBackStack()
                    },
                    onCartClick = {
                        navController.navigate("cart")
                    }
                )
            }
        }
        
        // Cart Screen
        composable("cart") {
            CartScreen(
                onBackClick = {
                    navController.popBackStack()
                },
                onCheckoutClick = {
                    // Simular proceso de compra (70% éxito, 30% fallo)
                    val isSuccess = (0..100).random() < 70
                    if (isSuccess) {
                        navController.navigate("purchase_success") {
                            popUpTo("catalog") { inclusive = false }
                        }
                    } else {
                        navController.navigate("purchase_failed") {
                            popUpTo("catalog") { inclusive = false }
                        }
                    }
                }
            )
        }
        
        // Purchase Success Screen
        composable("purchase_success") {
            PurchaseSuccessScreen(
                onContinueShopping = {
                    navController.navigate("catalog") {
                        popUpTo("purchase_success") { inclusive = true }
                    }
                }
            )
        }
        
        // Purchase Failed Screen
        composable("purchase_failed") {
            PurchaseFailedScreen(
                onRetryPurchase = {
                    navController.navigate("cart")
                },
                onContinueShopping = {
                    navController.navigate("catalog") {
                        popUpTo("purchase_failed") { inclusive = true }
                    }
                }
            )
        }
        
        // Back Office Screen
        composable("back_office") {
            BackOfficeScreen(
                onBackClick = {
                    navController.navigate("login") {
                        popUpTo("back_office") { inclusive = true }
                    }
                },
                onAddProductClick = {
                    navController.navigate("add_product")
                }
            )
        }
        
        // Add Product Screen
        composable("add_product") {
            AddProductScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}

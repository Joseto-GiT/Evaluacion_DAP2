package com.example.tiendaropa.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tiendaropa.model.ProductCategory

@Composable
fun CategoryChip(
    category: ProductCategory,
    isSelected: Boolean,
    onCategorySelected: (ProductCategory) -> Unit,
    modifier: Modifier = Modifier
) {
    FilterChip(
        onClick = { onCategorySelected(category) },
        label = { Text(category.displayName) },
        selected = isSelected,
        modifier = modifier
            .padding(horizontal = 4.dp)
            .width(100.dp)
    )
}

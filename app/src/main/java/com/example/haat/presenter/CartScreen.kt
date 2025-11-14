package com.example.haat.presenter

import ads_mobile_sdk.h4
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.haat.presenter.viewmodel.CartViewModel


@Composable
fun CartScreen()
{
    val viewModel: CartViewModel = hiltViewModel()

    var state =viewModel.cartScreenState.collectAsState().value

    LaunchedEffect(Unit) {
        viewModel.loadCartList()
    }

    CartScreenComponent (state.carlList){

    }


}

@Composable
fun CartScreenComponent(cartItems: List<CartItem>, onRemoveItem: (Int) -> Unit) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(
            text = "Your Cart",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyColumn(modifier = Modifier.weight(1f)) {
            cartItems?.let {
                items(it) { item ->
                    CartItemRow(item = item, onRemoveItem = onRemoveItem)
                }
            }

        }

        Spacer(modifier = Modifier.height(16.dp))

        val total = cartItems.sumOf { it.price * it.quantity }

        Text(
            text = "Total: Ruppes${"%.2f".format(total)}",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.align(Alignment.End).padding(end = 8.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = { /* Checkout action */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Checkout")
        }
    }
}

@Composable
fun CartItemRow(item: CartItem, onRemoveItem: (Int) -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
        //elevation = 4.dp,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = item.name,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.weight(1f),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "Rupees ${"%.2f".format(item.price)} x ${item.quantity}",
                style = MaterialTheme.typography.bodySmall
            )
            Spacer(modifier = Modifier.width(16.dp))
            IconButton(onClick = { onRemoveItem(item.id) }) {
              //  Icon(Icons.Default.Delete, contentDescription = "Remove Item")
            }
        }
    }
}



// **Preview function**
@Preview(showBackground = true)
@Composable
fun CartScreenPreview() {
    // Sample data for preview
    val sampleItems = listOf(
        CartItem(id = 1, name = "Item 1", price = 19.99, quantity = 2),
        CartItem(id = 2, name = "Item 2", price = 9.99, quantity = 1),
        CartItem(id = 3, name = "Item 3", price = 29.99, quantity = 3)
    )

    // For preview, the remove action can be a no-op
    CartScreenComponent(cartItems = sampleItems, onRemoveItem = { _ -> })
}

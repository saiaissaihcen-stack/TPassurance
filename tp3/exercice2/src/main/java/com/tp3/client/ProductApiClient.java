package com.tp3.client;

import com.tp3.model.Product;

public interface ProductApiClient {
    Product getProduct(String productId);
}
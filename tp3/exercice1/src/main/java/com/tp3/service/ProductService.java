package com.tp3.service;

import com.tp3.client.ProductApiClient;
import com.tp3.model.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductApiClient productApiClient;

    public ProductService(ProductApiClient productApiClient) {
        this.productApiClient = productApiClient;
    }

    public Product getProduct(String productId) {
        return productApiClient.getProduct(productId);
    }
}
package org.example.ex3;

public class ProductService {

    private ProductApiClient apiClient;

    public ProductService(ProductApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public Product getProduct(String productId) {
        return apiClient.getProduct(productId);
    }
}
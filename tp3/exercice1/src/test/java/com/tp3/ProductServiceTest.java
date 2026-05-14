package com.tp3;

import com.tp3.client.ProductApiClient;
import com.tp3.model.Product;
import com.tp3.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProductServiceTest {

    @Test
    public void testGetProduct_Success() {
        // Mock du client API
        ProductApiClient mockClient = Mockito.mock(ProductApiClient.class);
        Product product = new Product("P1", "Laptop", 1200.0);
        when(mockClient.getProduct("P1")).thenReturn(product);

        ProductService service = new ProductService(mockClient);
        Product result = service.getProduct("P1");

        assertNotNull(result);
        assertEquals("Laptop", result.getName());
        verify(mockClient).getProduct("P1");
    }

    @Test
    public void testGetProduct_ApiFailure() {
        ProductApiClient mockClient = Mockito.mock(ProductApiClient.class);
        when(mockClient.getProduct("P2"))
                .thenThrow(new RuntimeException("API indisponible"));

        ProductService service = new ProductService(mockClient);

        assertThrows(RuntimeException.class, () -> service.getProduct("P2"));
    }

    @Test
    public void testGetProduct_InvalidData() {
        ProductApiClient mockClient = Mockito.mock(ProductApiClient.class);
        when(mockClient.getProduct("P3")).thenReturn(null);

        ProductService service = new ProductService(mockClient);
        Product result = service.getProduct("P3");

        assertNull(result);
    }
}
package org.example.ex3;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ProductServiceTest {

    @Test
    void testGetProduct_success() {

        // MOCK API
        ProductApiClient apiMock = mock(ProductApiClient.class);

        Product expected = new Product("1", "Laptop");

        // STUB (réponse simulée)
        when(apiMock.getProduct("1")).thenReturn(expected);

        ProductService service = new ProductService(apiMock);

        Product result = service.getProduct("1");

        // VERIFY appel API
        verify(apiMock).getProduct("1");

        // ASSERT résultat
        assertEquals("Laptop", result.getName());
    }

    @Test
    void testGetProduct_apiFailure() {

        ProductApiClient apiMock = mock(ProductApiClient.class);

        when(apiMock.getProduct("1"))
                .thenThrow(new RuntimeException("API down"));

        ProductService service = new ProductService(apiMock);

        assertThrows(RuntimeException.class, () -> {
            service.getProduct("1");
        });

        verify(apiMock).getProduct("1");
    }

    @Test
    void testGetProduct_invalidData() {

        ProductApiClient apiMock = mock(ProductApiClient.class);

        when(apiMock.getProduct("1"))
                .thenReturn(null);

        ProductService service = new ProductService(apiMock);

        Product result = service.getProduct("1");

        assertNull(result);
        verify(apiMock).getProduct("1");
    }
}
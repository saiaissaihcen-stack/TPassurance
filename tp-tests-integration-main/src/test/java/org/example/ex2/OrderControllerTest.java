package org.example.ex2;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class OrderControllerTest {

    @Test
    void testCreateOrder() {

        //  MOCK DAO
        OrderDao mockDao = mock(OrderDao.class);

        // SERVICE réel mais avec DAO mocké
        OrderService service = new OrderService(mockDao);

        // SPY sur service (pour vérifier appel)
        OrderService spyService = spy(service);

        // CONTROLLER avec spy service
        OrderController controller = new OrderController(spyService);

        // ORDER test
        Order order = new Order("Laptop");

        // ACTION
        controller.createOrder(order);

        // VERIFY 1 : Controller → Service
        verify(spyService).createOrder(order);

        // VERIFY 2 : Service → DAO
        verify(mockDao).saveOrder(order);

        System.out.println("TEST OK");
    }
}
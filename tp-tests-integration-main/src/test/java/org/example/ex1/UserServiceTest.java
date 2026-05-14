package org.example.ex1;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    @Test
    void getUserById_shouldCallRepository_andReturnUser() {

        // 1. Mock (pas de vraie DB)
        UserRepository mockRepository = mock(UserRepository.class);

        // 2. Stub (comportement simulé)
        User user = new User(1, "TestUser");
        when(mockRepository.findUserById(1)).thenReturn(user);

        // 3. Injecter mock dans service
        UserService userService = new UserService(mockRepository);

        // 4. Appel méthode
        User result = userService.getUserById(1);

        // 5. Vérification résultat
        assertNotNull(result);
        assertEquals("TestUser", result.getName());

        // 6. Vérification interaction
        verify(mockRepository).findUserById(1);
    }
}
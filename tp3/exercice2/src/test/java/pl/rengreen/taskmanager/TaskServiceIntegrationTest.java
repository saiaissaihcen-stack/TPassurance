package pl.rengreen.taskmanager;

import pl.rengreen.taskmanager.model.Task;
import pl.rengreen.taskmanager.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Testcontainers
public class TaskServiceIntegrationTest {

    @Container
    static MySQLContainer<?> mysql = new MySQLContainer<>("mysql:8.0")
            .withDatabaseName("taskdb")
            .withUsername("root")
            .withPassword("password");

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", () -> mysql.getJdbcUrl());
        registry.add("spring.datasource.username", () -> mysql.getUsername());
        registry.add("spring.datasource.password", () -> mysql.getPassword());
        registry.add("spring.jpa.hibernate.ddl-auto", () -> "create-drop");
    }

    @Autowired
    private TaskRepository taskRepository;

    @BeforeEach
    void setUp() {
        taskRepository.deleteAll();
    }

    @Test
    public void testCreateTask() {
        Task task = new Task();
        task.setName("Tâche 1");
        taskRepository.save(task);

        List<Task> tasks = taskRepository.findAll();
        assertEquals(1, tasks.size());
        assertEquals("Tâche 1", tasks.get(0).getName());
    }

    @Test
    public void testGetTask() {
        Task task = new Task();
        task.setName("Tâche 2");
        taskRepository.save(task);

        Optional<Task> found = taskRepository.findById(task.getId());
        assertTrue(found.isPresent());
        assertEquals("Tâche 2", found.get().getName());
    }

    @Test
    public void testDeleteTask() {
        Task task = new Task();
        task.setName("Tâche 3");
        taskRepository.save(task);

        taskRepository.deleteById(task.getId());

        Optional<Task> found = taskRepository.findById(task.getId());
        assertFalse(found.isPresent());
    }

    @Test
    public void testUpdateTask() {
        Task task = new Task();
        task.setName("Ancien nom");
        taskRepository.save(task);

        task.setName("Nouveau nom");
        taskRepository.save(task);

        Optional<Task> updated = taskRepository.findById(task.getId());
        assertTrue(updated.isPresent());
        assertEquals("Nouveau nom", updated.get().getName());
    }
}
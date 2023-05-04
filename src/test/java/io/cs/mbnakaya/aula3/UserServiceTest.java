package io.cs.mbnakaya.aula3;

import io.cs.mbnakaya.aula3.model.User;
import io.cs.mbnakaya.aula3.repository.UserRepository;
import io.cs.mbnakaya.aula3.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class UserServiceTest {

    @Mock
    private UserRepository repository;

    @InjectMocks
    private UserService service;

    private User defaultUser;
    private User defaultSavedUser;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        this.defaultUser = new User(null, "Teste da Silva", "test@test.com", "Rua Teste", "00912345678");
        this.defaultSavedUser = new User(1L, "Teste da Silva", "test@test.com", "Rua Teste", "00912345678");
    }

    @Test
    public void testUserCreationWithSuccess() {
        Mockito.when(repository.save(Mockito.any())).thenReturn(defaultSavedUser);
        var result = service.create(defaultUser);

        Mockito.verify(repository, Mockito.times(1)).save(defaultUser);

        Assertions.assertEquals(defaultSavedUser.getId(), result.getId());
        Assertions.assertEquals(defaultSavedUser, result);
    }

    @Test
    public void testGetUserWithSuccess() {
        Mockito.when(repository.getReferenceById(Mockito.anyLong())).thenReturn(defaultSavedUser);
        var result = service.getById(1L);

        Mockito.verify(repository, Mockito.times(1)).getReferenceById(1L);

        Assertions.assertEquals(defaultSavedUser, result);
    }
}

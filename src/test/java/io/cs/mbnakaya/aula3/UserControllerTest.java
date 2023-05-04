package io.cs.mbnakaya.aula3;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cs.mbnakaya.aula3.controller.UserController;
import io.cs.mbnakaya.aula3.model.User;
import io.cs.mbnakaya.aula3.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class UserControllerTest {

    @Mock
    private UserService service;

    @InjectMocks
    private UserController controller;

    private MockMvc mockMvc;

    private User defaultUser;
    private User defaultSavedUser;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.controller).build();
        this.defaultUser = new User(null, "Teste da Silva", "test@test.com", "Rua teste", "12345678900");
        this.defaultSavedUser = new User(1L, "Teste da Silva", "test@test.com", "Rua teste", "12345678900");
    }

    @Test
    public void testCreateMethodWithSuccess() {
        Mockito.when(service.create(Mockito.any())).thenReturn(defaultSavedUser);
        var result = controller.create(defaultUser);

        Mockito.verify(service, Mockito.times(1)).create(defaultUser);

        Assertions.assertEquals(new ResponseEntity<User>(defaultSavedUser, HttpStatus.CREATED), result);
    }

    @Test
    public void testCreateMethodHttpWithSuccess() throws Exception {
        Mockito.when(service.create(Mockito.any())).thenReturn(defaultSavedUser);
        mockMvc.perform(
                MockMvcRequestBuilders.post("/v1/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(defaultUser))
        ).andDo(MockMvcResultHandlers.print());
        Mockito.verify(service, Mockito.times(1)).create(defaultUser);
    }

    @Test
    public void testCreateMethodHttpWithFail() throws Exception {
        Mockito.when(service.create(Mockito.any())).thenReturn(defaultSavedUser);
        mockMvc.perform(
                MockMvcRequestBuilders.post("/v1/users")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isBadRequest());
        Mockito.verify(service, Mockito.times(0)).create(defaultUser);
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

package io.cs.mbnakaya.aula6;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cs.mbnakaya.aula6.model.Checkout;
import io.cs.mbnakaya.aula6.model.PaymentMethod;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@AutoConfigureMockMvc
@SpringBootTest(classes = Aula6.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class IntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Order(0)
    public void testPostWithSuccess() throws Exception {
        Checkout requestBody = new Checkout(null, 100L, PaymentMethod.BOLETO);
        mockMvc.perform(MockMvcRequestBuilders
                .post("/v1/checkout")
                .content(asJsonString(requestBody))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @Order(1)
    public void testGetWithSuccess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/v1/checkout/1")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{\"id\":1,\"total\":100,\"method\":\"BOLETO\"}"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @Order(2)
    public void testGetWithFailure() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/v1/checkout/100")
                        .contentType(MediaType.APPLICATION_JSON)
                ).andExpect(MockMvcResultMatchers.status().isNotFound())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @Order(3)
    public void testUpdateWithSuccess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .patch("/v1/checkout/1")
                        .param("paymentMethod", "credit")
                        .contentType(MediaType.APPLICATION_JSON)
                ).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{\"id\":1,\"total\":100,\"method\":\"CREDIT\"}"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @Order(4)
    public void testUpdateWithFailure() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .patch("/v1/checkout/1")
                        .param("paymentMethod", "duno")
                        .contentType(MediaType.APPLICATION_JSON)
                ).andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @Order(5)
    public void testDeleteWithFailure() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/v1/checkout/1")
                        .contentType(MediaType.APPLICATION_JSON)
                ).andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

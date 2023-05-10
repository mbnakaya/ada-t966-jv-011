package io.cs.mbnakaya.aula6;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cs.mbnakaya.aula6.model.Checkout;
import io.cs.mbnakaya.aula6.model.PaymentMethod;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@AutoConfigureMockMvc
@SpringBootTest(classes = Aula6.class)
public class IntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testPostWithSuccess() throws Exception {
        Checkout requestBody = new Checkout(null, 100L, PaymentMethod.BOLETO);
        mockMvc.perform(MockMvcRequestBuilders
                .post("/v1/checkout")
                .content(asJsonString(requestBody))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isCreated())
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

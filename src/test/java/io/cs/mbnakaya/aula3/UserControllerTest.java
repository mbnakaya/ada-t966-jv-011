package io.cs.mbnakaya.aula3;

import com.fasterxml.jackson.databind.ObjectMapper;

public class UserControllerTest {

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

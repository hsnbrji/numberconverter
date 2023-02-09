package com.hsnbrji.numberconverter.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hsnbrji.numberconverter.param.ConversionParam;
import com.hsnbrji.numberconverter.service.NumberConverterService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrint;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc(print = MockMvcPrint.SYSTEM_OUT, printOnlyOnFailure = false)
@SpringBootTest
class ConversionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private NumberConverterService numberConverterService;

    @Test
    @SneakyThrows
    void testConvert_happyScenario() {
        ConversionParam param = new ConversionParam("10", "binary", "roman");
        ObjectMapper objectMapper = new ObjectMapper();
        mockMvc.perform(post("/api/convert")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(param)))
            .andExpect(status().isOk())
            .andExpect(result -> {
                result.toString().equals("II");
            });
    }

    @Test
    @SneakyThrows
    void testConvert_conversionNotPossible() {
        ConversionParam param = new ConversionParam("10", "binary", "decimal");
        ObjectMapper objectMapper = new ObjectMapper();
        mockMvc.perform(post("/api/convert")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(param)))
            .andExpect(status().isBadRequest());
    }

    @Test
    @SneakyThrows
    void testConvert_nullInputNumber () {
        ConversionParam param = new ConversionParam(null, null, "roman");
        ObjectMapper objectMapper = new ObjectMapper();
        mockMvc.perform(post("/api/convert")

                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(param))
            )
            .andDo(print())
            .andExpect(status().isBadRequest());
    }
}


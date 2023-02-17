package com.uuu.boot.Demo1.application.rest;

import com.uuu.boot.Demo1.domain.PointType;
import com.uuu.boot.Demo1.domain.common.service.PointTypeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PointTypeController.class)
public class PointTypeControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    PointTypeService service;

    @Test
    void shouldNotNull() {
        assertNotNull(mockMvc);
        assertNotNull(service);
    }

    @Test
    void hasValidPath() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/points/list").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void hasInvalidPath() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/friends/list").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

    }

    @Test
    void getEmptyRecords() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/points/list").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.pointTypes", hasSize(0)));
    }

    private static final PointType T1 = new PointType("title1", "detail1");
    private static final PointType T2 = new PointType("title2", "detail2");
    private static final PointType T3 = new PointType("title3", "detail3");

    @Test
    void getAllRecords() throws Exception {
        List<PointType> records = new ArrayList<>(Arrays.asList(T1, T2, T3));
        Mockito.when(service.allTypes()).thenReturn(records);
        mockMvc.perform(MockMvcRequestBuilders.get("/points/list")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.pointTypes",hasSize(records.size())));
    }
}
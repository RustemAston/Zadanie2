package simple_rest.controller;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class MyRequestBuilder {
    private MockMvc mockMvc;

    MyRequestBuilder(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    ResultActions findAll() throws Exception {
        return mockMvc.perform(MockMvcRequestBuilders.get("/todo-item"));
    }
}

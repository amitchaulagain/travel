package com.travel.web;

import com.travel.model.entities.enums.CategoryNameEnum;
import com.travel.model.entities.enums.LocationEnum;
import com.travel.service.TestService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TestControllerTest extends AbstractTest {
    @Autowired
    private TestController controller;
    private com.travel.model.entities.Test results;

    @Before
    public void setUp() {
        results = new com.travel.model.entities.Test();
        results.setCategoryOne(CategoryNameEnum.ACTIVE);
        results.setCategoryTwo(CategoryNameEnum.ACTIVE);
        results.setCategoryThree(CategoryNameEnum.ACTIVE);
        results.setCategoryFour(CategoryNameEnum.ACTIVE);
        results.setCategoryFive(CategoryNameEnum.ACTIVE);
        results.setCategorySix(CategoryNameEnum.ACTIVE);
        results.setCategorySeven(CategoryNameEnum.ACTIVE);
        results.setUsername("username");
        results.setId(1L);
        results.setLocation(LocationEnum.ZURICH);
        super.setUp();
    }

    @MockBean
    private TestService testService;

    @Test
    public void contextLoads() {
        assertThat(controller).isNotNull();
    }

    @Test
    public void post_results_should_work() throws Exception {
        String uri = "/test";

        String inputJson = super.mapToJson(results);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
    }

}

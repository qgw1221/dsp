package com.hy.test.mockMVC;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.skyscreamer.jsonassert.FieldComparisonFailure;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.hy.controller.DemoController;
import com.hy.service.TestProjectService;

public class DemoControllerTest_mock {
    
    @Mock
    private TestProjectService testProjectService;
    
    @InjectMocks
    private DemoController demoController;
 
    private MockMvc mockMvc;
 
    @Before
    public void setup() {
 
        // initialize mock object
        MockitoAnnotations.initMocks(this);
        
        // Setup Spring test in standalone mode
        this.mockMvc = MockMvcBuilders.standaloneSetup(demoController).build();
    }
    
    @Test
    public void test() throws Exception {
        
        //prepare test data
        FieldComparisonFailure e1 = new FieldComparisonFailure("Number", "3", "4");
        FieldComparisonFailure e2 = new FieldComparisonFailure("Number", "1", "2");
        
        //actually parameter haven't use, service was mocked
        String expect = "qwer";
        String actual = "rewq";
        
        //Sets a return value to be returned when the method is called
        when(testProjectService.compare(expect, actual)).thenReturn(expect);
        
        //construct http request and expect response
       this.mockMvc
            .perform(post("/jsonCompare").accept(MediaType.APPLICATION_JSON)
               .param("actual", actual)
               .param("expect", expect))
               .andDo(print()) //print request and response to Console
               .andExpect(status().isOk())
               .andExpect(content().contentType("text/html;charset=UTF-8"))
               .andExpect(jsonPath("$", hasSize(2)))
               .andExpect(jsonPath("$[0].field").value("Number"))
               .andExpect(jsonPath("$[0].expected").value("3"))
               .andExpect(jsonPath("$[0].actual").value("4"))
               .andExpect(jsonPath("$[1].field").value("Number"))
               .andExpect(jsonPath("$[1].expected").value("1"))
               .andExpect(jsonPath("$[1].actual").value("2"));
       
         //verify Interactions with any mock
         verify(testProjectService, times(1)).compare(expect, actual);
         verifyNoMoreInteractions(testProjectService);
    }
}
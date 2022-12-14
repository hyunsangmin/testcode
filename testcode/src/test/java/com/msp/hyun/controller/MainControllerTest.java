package com.msp.hyun.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MainControllerTest {
	 	@Autowired
	    private MockMvc mvc;

	    @Test
	    public void hello_테스트() throws  Exception {
	        String hello = "hello";
	        
	        this.mvc.perform(get("/hello"))	        		
	        		.andDo(print())
	        		.andExpect(content().string(hello))
	                .andExpect(status().isOk());
	                
	    }
	    
	    @Test	  
	    public void bye_테스트() throws  Exception {
	    	String bye = "bye";
	    	
	    	this.mvc.perform(get("/bye"))	        		
	    	.andDo(print())
	    	.andExpect(status().isOk())
	    	.andExpect(content().string(bye));
	    	
	    }
	    
	    @Test	  
	    public void user_테스트() throws  Exception {
	    	String user = "{\"name\": \"홍길동\", \"age\": \"1\"}";
	    	String info = "안녕하세요 100살 홍길동입니다";
	    	this.mvc.perform(get("/user")
	    	.contentType(MediaType.APPLICATION_JSON)
	    	.content(user))	        		
	    	.andDo(print())
	    	.andExpect(status().isOk())
	    	.andExpect(content().string(info));
	    	
	    }
}

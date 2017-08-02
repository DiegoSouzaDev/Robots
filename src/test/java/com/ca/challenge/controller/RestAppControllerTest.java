package com.ca.challenge.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RestAppControllerTest {
	
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext wac;
	
	@Before
	public void setup() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void testMoveRobotWithRightRotationSuccessfully() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/rest/mars/move/MMRMMRMM").accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk())
				.andExpect(content().string(equalTo("(2,0,S)")));
	}
	
	@Test
	public void testMoveRobotWithLeftRotationSuccessfully() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/rest/mars/move/MML").accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk())
				.andExpect(content().string(equalTo("(0,2,W)")));
	}
	
	@Test
	public void testDontSaveRobotState() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/rest/mars/move/MML").accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk())
				.andExpect(content().string(equalTo("(0,2,W)")));
		mockMvc.perform(MockMvcRequestBuilders.post("/rest/mars/move/MML").accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk())
				.andExpect(content().string(equalTo("(0,2,W)")));
	}
	
	@Test
	public void testInvalidMovementInstruction() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/rest/mars/move/AAA").accept(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isBadRequest()).andExpect(content().string(equalTo("400 Bad Request: Invalid Action Instruction")));
	}
	
	@Test
	public void testMoveToAInvalidPosition() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/rest/mars/move/MMMMMM").accept(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isBadRequest()).andExpect(content().string(equalTo("400 Bad Request: Move to a Invalid Position")));
	}
}

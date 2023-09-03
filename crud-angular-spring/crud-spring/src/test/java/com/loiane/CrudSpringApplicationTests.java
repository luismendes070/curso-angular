package com.loiane;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
class CrudSpringApplicationTests {

	@Test
	void contextLoads() {
	} // end method contextLoads

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testPutXml() throws Exception {
		mockMvc.perform(put("/api/example")
						.contentType(MediaType.APPLICATION_XML)
						.content("<request>example request</request>"))
				.andExpect(status().isOk());
	}

	@Test
	public void testPostXml() throws Exception {
		mockMvc.perform(post("/api/example")
						.contentType(MediaType.APPLICATION_XML)
						.content("<request>example request</request>"))
				.andExpect(status().isOk());
	}

} // end class CrudSpringApplicationTests

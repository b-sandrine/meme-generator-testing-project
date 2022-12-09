package com.example.classbjunit.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.classbjunit.dto.UpdateMemeDto;
import com.example.classbjunit.model.Meme;
import com.example.classbjunit.service.MemeService;
import com.example.classbjunit.utils.APIResponse;

@RunWith(SpringRunner.class)
@WebMvcTest(MemeController.class)
public class MemeControllerTest {

	@MockBean
	private MemeService MemeServiceMock;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void getAll_success() throws Exception {
		List<Meme> asList = Arrays.asList(new Meme("Life","Good","https://i.imgflip.com/30b1gx.jpg"),
				new Meme("Blessing","All over","https://i.imgflip.com/30b1gx.jpg"));
		when(MemeServiceMock.getAll()).thenReturn(asList);
		
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
				.get("/all-Memes")
				.accept(MediaType.APPLICATION_JSON);
				
				 MvcResult result = mockMvc
						.perform(request)
						.andExpect(status().isOk())
						.andExpect(content().json("[{\"id\":1,\"heading_text\":\"Life\",\"buttom_text\":\"Good\",\"https://i.imgflip.com/30b1gx.jpg\"},{\"id\":2,\"heading_text\":\"Blessings\",\"buttom_text\":\"All over me\",\"image_url\":https://i.imgflip.com/30b1gx.jpg\"}]"))
						.andReturn();
			
	}
	
	@Test
	public void getByOne_404() throws Exception {
		Meme Meme = new Meme(("Life","Good","https://i.imgflip.com/30b1gx.jpg");
		
		when(MemeServiceMock.getById(Meme.getId())).thenReturn(Meme);
		
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
				.get("/all-Memes/2")
				.accept(MediaType.APPLICATION_JSON);
				
				 MvcResult result = mockMvc
						.perform(request)
						.andExpect(status().isNotFound())
						//.andExpect(content().string(""))
						.andExpect(content().json("{\"status\":false,\"message\":\"Meme not found\"}"))
						.andReturn();
			
	}

	
	@Test
	public void update_success() throws Exception {
		Meme Meme = new Meme(1,"money",1,10);
		
		ResponseEntity.status(HttpStatus.CREATED).body(Meme);
		
		ResponseEntity<?> respnse= ResponseEntity.status(HttpStatus.CREATED).body(Meme);
		when(MemeServiceMock.updateMeme(1,new UpdateMemeDto("money", 100, 3))).thenReturn(null);
		
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
				.get("/all-Memes/2")
				.accept(MediaType.APPLICATION_JSON);
				
				 MvcResult result = mockMvc
						.perform(request)
						.andExpect(status().isNotFound())
						//.andExpect(content().string(""))
						.andExpect(content().json("{\"status\":false,\"message\":\"Meme not found\"}"))
						.andReturn();
			
	}
	
}

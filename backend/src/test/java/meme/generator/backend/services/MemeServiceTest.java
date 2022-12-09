package meme.generator.backend.services;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.example.classbjunit.dto.UpdateMemeDto;


import meme.generator.backend.model.Meme;
import meme.generator.backend.repository.MemeRepository;

@RunWith(MockitoJUnitRunner.class)
public class MemeServiceTest {


	@Mock
	private MemeRepository MemeRepositoryMock;
	
	@InjectMocks
	private MemeService MemeService;
	
	@Test
	public void getAll_withSomeElements() {

		when(MemeRepositoryMock.findAll()).thenReturn(Arrays.asList(new Meme("Life","Good","https://i.imgflip.com/30b1gx.jpg"),
				new Meme("Blessing","All over","https://i.imgflip.com/30b1gx.jpg")));
		assertEquals("Life",MemeService.getAll().get(0).getValue());
		assertEquals(2, MemeService.getAll().size());
	}
	
	@Test
	public void update_Success() {
		UpdateMemeDto dto = new UpdateMemeDto("Blessing","All over","https://i.imgflip.com/30b1gx.jpg");
		Meme Meme = new Meme(("Blessing","All over","https://i.imgflip.com/30b1gx.jpg");
		when(MemeRepositoryMock.findById(1)).thenReturn(Optional.of(Meme));
		when(MemeRepositoryMock.existsByName(dto.getName())).thenReturn(true);
		when(MemeRepositoryMock.save(Meme)).thenReturn(Meme);
		
		ResponseEntity<?> updateMeme = MemeService.updateMeme(1, dto);
		assertTrue(updateMeme.getStatusCode().is2xxSuccessful());
		
	}

	@Test
	public void update_404() {
		UpdateMemeDto dto = new UpdateMemeDto("Blessing","All over","https://i.imgflip.com/30b1gx.jpg");
		when(MemeRepositoryMock.findById(1)).thenReturn(Optional.empty());
	
		ResponseEntity<?> updateMeme = MemeService.updateMeme(1, dto);
		assertTrue(updateMeme.getStatusCodeValue()==404);
		
	}
	
	@Test
	public void update_NameExists() {
		UpdateMemeDto dto = new UpdateMemeDto("Blessing","All over","https://i.imgflip.com/30b1gx.jpg");
		Meme Meme = new Meme("Blessing","All over","https://i.imgflip.com/30b1gx.jpg")
		when(MemeRepositoryMock.findById(1)).thenReturn(Optional.of(Meme));
		when(MemeRepositoryMock.existsByName(dto.getName())).thenReturn(true);
		
		ResponseEntity<?> updateMeme = MemeService.updateMeme(1, dto);
		assertTrue(updateMeme.getStatusCodeValue()==400);
	}
	
	@Test
	public void update_sauve() {
		UpdateMemeDto dto = new UpdateMemeDto("Blessing","All over","https://i.imgflip.com/30b1gx.jpg");
		Meme Meme = new Meme("Blessing","All over","https://i.imgflip.com/30b1gx.jpg");
		when(MemeRepositoryMock.findById(1)).thenReturn(Optional.of(Meme));
		when(MemeRepositoryMock.existsByName(dto.getName())).thenReturn(false);
		Meme.setName(dto.getName());
		Meme.setPrice(dto.getPrice());
		Meme.setQuantity(dto.getQuantity());
		when(MemeRepositoryMock.save(Meme)).thenReturn(Meme);
		
		ResponseEntity<?> updateMeme = MemeService.updateMeme(1, dto);
		assertTrue(updateMeme.getStatusCodeValue()==201);
	}
	
	
}

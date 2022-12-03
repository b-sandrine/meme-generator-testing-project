package meme.generator.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import meme.generator.backend.model.Meme;

@RestController
public class MemeController {
	
	@Autowired
	MemeService service = new MemeService();
	
	@GetMapping("/api/meme/all-memes")
	public List<Meme> getAll() {
		return service.getAll();
	}
}

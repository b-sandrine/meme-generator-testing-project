package meme.generator.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import meme.generator.backend.model.Meme;
import meme.generator.backend.service.MemeService;

@RestController
public class MemeController {
	
	@Autowired
	MemeService service = new MemeService();

	@GetMapping("/api/v1")
	public String Welcome() {
		return "Welcome to our app";
	}
	
	@GetMapping("/api/meme/all-memes")
	public List<Meme> getAll() {
		return service.getAll();
	}
}

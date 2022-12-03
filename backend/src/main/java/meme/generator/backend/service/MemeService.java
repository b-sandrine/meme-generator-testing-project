package meme.generator.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import meme.generator.backend.model.Meme;
import meme.generator.backend.repository.MemeRepository;

@Service
public class MemeService {
	
	@Autowired
	private MemeRepository repository;
	
	public List<Meme> getAll() {
		return repository.findAll();
	}
	
	public Meme getMemeById(int id) {
		return repository.getById(id);
	}
	
	public Meme save(Meme meme) {
		return repository.save(meme);
	}
	
	public void deleteAll() {
		repository.deleteAll();
	}
	
}
package meme.generator.backend.DBOperation;

import org.springframework.beans.factory.annotation.Autowired;

import meme.generator.backend.repository.MemeRepository;

@Component
public class DBOperations {
	@Autowired
	MemeRepository repo;

	@Override
	public void run(String... args) throws Exception {
		repo.saveAll(List.of(
			new Meme("","","https://i.imgflip.com/30b1gx.jpg"),
			new Meme("","","https://i.imgflip.com/1g8my4.jpg"),
			new Meme("","","https://i.imgflip.com/1ur9b0.jpg"),
			new Meme("","","https://i.imgflip.com/261o3j.jpg"),
			new Meme("","","https://i.imgflip.com/43a45p.png"),
			new Meme("","","https://i.imgflip.com/22bdq6.jpg"),
			new Meme("","","https://i.imgflip.com/3lmzyx.jpg"),
			new Meme("","","https://i.imgflip.com/9ehk.jpg")
		);
		System.out.println("-------------------- All data saved --------------------")
		)
	}
}

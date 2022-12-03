package meme.generator.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import meme.generator.backend.model.Meme;

@Repository
public interface MemeRepository extends JpaRepository<Meme, Integer> {

}

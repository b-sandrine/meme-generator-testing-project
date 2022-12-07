package meme.generator.backend.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="meme_table")
public class Meme {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String heading_text;
	private String buttom_text;
	private String image_url;
	
	public Meme() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Meme(String heading_text, String buttom_text, String image_url) {
		super();
		this.heading_text = heading_text;
		this.buttom_text = buttom_text;
		this.image_url = image_url;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHeading_text() {
		return heading_text;
	}
	public void setHeading_text(String heading_text) {
		this.heading_text = heading_text;
	}
	public String getButtom_text() {
		return buttom_text;
	}
	public void setButtom_text(String buttom_text) {
		this.buttom_text = buttom_text;
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
}

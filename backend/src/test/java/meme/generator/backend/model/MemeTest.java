package meme.generator.backend.model;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

@Test
public class MemeTest {
	Meme memeModel = new Meme("True story","This is it", "https://image/laugh");
	
	public void constructorShouldSetAllValue() {
		assertEquals(memeModel.getHeading_text(), "True story");
		assertEquals(memeModel.getButtom_text(), "This is it");
		assertEquals(memeModel.getImage_url(), "https://image/laugh");
	}
}

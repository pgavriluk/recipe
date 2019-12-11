package demo.pavel.recipe.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CategoryTest {

	Category category;

	@Before
	public void setUp(){
		category = new Category();
	}

	@Test
	public void getId() {
		Long idValue = 4l;

		category.setId(idValue);

		assertEquals(idValue, category.getId());
	}

	@Test
	public void getDescription() {
		String description = "This is a description for a category.";

		category.setDescription(description);

		assertEquals(description, category.getDescription());
	}

	@Test
	public void getRecipes() {
	}
}
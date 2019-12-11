package demo.pavel.recipe.repositories;

import org.springframework.data.repository.CrudRepository;

import demo.pavel.recipe.model.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}

package demo.pavel.recipe.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import demo.pavel.recipe.model.Category;
import demo.pavel.recipe.model.Recipe;

public interface CategoryRepository extends CrudRepository<Category, Long> {

	Optional<Category> findByDescription(String description);

}
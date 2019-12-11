package demo.pavel.recipe.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import demo.pavel.recipe.model.Recipe;
import demo.pavel.recipe.model.UnitOfMeasure;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

	Optional<UnitOfMeasure> findByDescription(String description);
}

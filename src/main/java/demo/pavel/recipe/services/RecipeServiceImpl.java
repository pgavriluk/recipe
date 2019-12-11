package demo.pavel.recipe.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.pavel.recipe.commands.RecipeCommand;
import demo.pavel.recipe.converters.RecipeCommandToRecipe;
import demo.pavel.recipe.converters.RecipeToRecipeCommand;
import demo.pavel.recipe.exceptions.NotFoundException;
import demo.pavel.recipe.model.Recipe;
import demo.pavel.recipe.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService{

	// fields
	private final RecipeRepository recipeRepository;
	private final RecipeCommandToRecipe recipeCommandToRecipe;
	private final RecipeToRecipeCommand recipeToRecipeCommand;

	// constructor
	public RecipeServiceImpl(RecipeRepository recipeRepository,
	                         RecipeCommandToRecipe recipeCommandToRecipe,
	                         RecipeToRecipeCommand recipeToRecipeCommand) {
		this.recipeRepository = recipeRepository;
		this.recipeCommandToRecipe = recipeCommandToRecipe;
		this.recipeToRecipeCommand = recipeToRecipeCommand;
	}

	@Override
	public Set<Recipe> findRecipes() {
		Set<Recipe> recipeSet = new HashSet<>();
		recipeRepository.findAll().iterator().forEachRemaining(recipeSet :: add);
		return recipeSet;
	}

	@Override
	public Recipe findRecipeById(Long id) {

		Optional<Recipe> recipeOptional = recipeRepository.findById(id);

		if(!recipeOptional.isPresent()){
			throw new NotFoundException("The Recipe not found. For ID: " + id);
		}

		return recipeOptional.get();
	}

	@Override
	@Transactional
	public RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand) {
		Recipe detachedRecipe = recipeCommandToRecipe.convert(recipeCommand);

		Recipe savedRecipe = recipeRepository.save(detachedRecipe);
		log.debug("Saved RecipeId is: " + savedRecipe.getId());
		return recipeToRecipeCommand.convert(savedRecipe);
	}

	@Override
	@Transactional
	public RecipeCommand findCommandById(Long id) {
		return recipeToRecipeCommand.convert(findRecipeById(id));
	}

	@Override
	public void deleteById(Long id) {
		recipeRepository.deleteById(id);
	}
}

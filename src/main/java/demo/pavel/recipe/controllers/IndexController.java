package demo.pavel.recipe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import demo.pavel.recipe.services.RecipeService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class IndexController {

	// fields
	private final RecipeService recipeService;

	// constructors
	public IndexController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}

	@GetMapping({"/", "", "index", "index.html"})
	public String getIndexPage(Model model){
		log.debug("Getting Index page");
		model.addAttribute("recipes", recipeService.findRecipes());
		return "index";
	}
}

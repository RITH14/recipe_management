@Controller
public class RecipeController {

  private final RecipeService recipeService;

  // Additional dependency for security (assuming Spring Security is configured)
  private final AuthenticationFacade authenticationFacade; // Assuming you have a similar bean for accessing principal details

  public RecipeController(RecipeService recipeService, AuthenticationFacade authenticationFacade) {
    this.recipeService = recipeService;
    this.authenticationFacade = authenticationFacade;
  }

  // ... existing methods (getRecipes, getRecipeDetails)

  @PostMapping("/recipes")
  public String addRecipe(@ModelAttribute Recipe recipe) {
    // Security check (ensure authenticated user can add recipes)
    if (authenticationFacade.isAuthenticated()) {
      recipeService.addRecipe(recipe);
      return "redirect:/recipes"; // Redirect to the recipes list
    } else {
      return "redirect:/login"; // Redirect to login if not authenticated
    }
  }

  @GetMapping("/recipes/search")
  public String searchRecipes(@RequestParam(name = "keyword", required = false) String keyword, Model model) {
    List<Recipe> recipes;
    if (keyword != null) {
      recipes = recipeService.searchRecipes(keyword); // Implement search logic in RecipeService
    } else {
      recipes = recipeService.getAllRecipes(); // Get all recipes if no keyword
    }
    model.addAttribute("recipes", recipes);
    return "recipes"; // Use the same template for search results
  }
}


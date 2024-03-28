@Controller
public class RecipeController {

  // In-memory data structures for demonstration (replace with database access later)
  private static List<Recipe> recipes = new ArrayList<>();
  private static List<User> users = new ArrayList<>();

  public RecipeController() {
    // Sample data (replace with actual data population logic)
    recipes.add(new Recipe(1L, "Pizza", "Delicious Italian pizza", Cuisine.ITALIAN,
        Arrays.asList(
            new Ingredient(1L, "Flour", 1, Unit.CUP, null),
            new Ingredient(2L, "Tomato Sauce", 1, Unit.CAN, null),
            new Ingredient(3L, "Cheese", 200, Unit.GRAM, null)),
        "Combine ingredients, bake at 400°F for 20 minutes", 20, DifficultyLevel.EASY, 4.2, new ArrayList<>()));
    recipes.add(new Recipe(2L, "Burrito", "A classic Mexican dish", Cuisine.MEXICAN,
        Arrays.asList(
            new Ingredient(4L, "Tortilla", 2, null, null),
            new Ingredient(5L, "Ground Beef", 500, Unit.GRAM, null),
            new Ingredient(6L, "Beans", 1, Unit.CAN, null)),
        "Cook beef, assemble with beans and cheese in tortilla", 30, DifficultyLevel.MEDIUM, 4.0, new ArrayList<>()));
    users.add(new User(1L, "user1", "password1", new ArrayList<>()));
  }

  @GetMapping("/recipes")
  public String recipeCatalog(Model model) {
    model.addAttribute("recipes", recipes);
    return "recipeCatalog"; // Thymeleaf template name
  }

  @GetMapping("/recipeDetails/{id}")
  public String recipeDetails(@PathVariable Long id, Model model) {
    Recipe recipe = recipes.stream().filter(r -> r.getId().equals(id)).findFirst().orElse(null);
    if (recipe == null) {
      return "error"; // Handle recipe not found
    }
    model.addAttribute("recipe", recipe);
    return "recipeDetails"; // Thymeleaf template name
  }

  // Additional methods for functionalities like user login, favorites, etc.
}

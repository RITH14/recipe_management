public class InMemoryRecipeService implements RecipeService {

    private List<Recipe> recipes;
  
    public InMemoryRecipeService() {
      // Initialize recipes with sample data (replace with database access)
      recipes = new ArrayList<>();
      // ... sample recipes
    }
  
    @Override
    public List<Recipe> getAllRecipes() {
      return recipes;
    }
  
    @Override
    public Recipe getRecipeById(Long id) {
      for (Recipe recipe : recipes) {
        if (recipe.getId().equals(id)) {
          return recipe;
        }
      }
      return null;
    }
  
    // Add a recipe (consider security in a production environment)
    public void addRecipe(Recipe recipe) {
      // For simplicity, generate a unique ID (replace with proper ID generation)
      Long nextId = recipes.stream().mapToLong(Recipe::getId).max().orElse(0) + 1;
      recipe.setId(nextId);
      recipes.add(recipe);
    }
  
    // Update a recipe (consider security in a production environment)
    public void updateRecipe(Recipe recipe) {
      for (int i = 0; i < recipes.size(); i++) {
        if (recipes.get(i).getId().equals(recipe.getId())) {
          recipes.set(i, recipe);
          return; // Exit after successful update
        }
      }
      throw new RuntimeException("Recipe not found for update (ID: " + recipe.getId() + ")");
    }
  
    // Delete a recipe (consider security in a production environment)
    public void deleteRecipe(Long id) {
      int indexToRemove = -1;
      for (int i = 0; i < recipes.size(); i++) {
        if (recipes.get(i).getId().equals(id)) {
          indexToRemove = i;
          break;
        }
      }
      if (indexToRemove != -1) {
        recipes.remove(indexToRemove);
      } else {
        throw new RuntimeException("Recipe not found for deletion (ID: " + id + ")");
      }
    }
  }
  
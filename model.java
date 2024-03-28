public class Recipe {
    private Long id;
    private String title;
    private String description; // Optional
    private Cuisine cuisine;
    private List<Ingredient> ingredients;
    private String instructions;
    private int cookingTime;
    private DifficultyLevel difficultyLevel;
    private double averageRating; // Calculated based on ratings
    private List<User> favoritedBy; // Users who favorited this recipe
  
    public Recipe(Long id, String title, String description, Cuisine cuisine, List<Ingredient> ingredients,
                   String instructions, int cookingTime, DifficultyLevel difficultyLevel, double averageRating, List<User> favoritedBy) {
      this.id = id;
      this.title = title;
      this.description = description;
      this.cuisine = cuisine;
      this.ingredients = ingredients;
      this.instructions = instructions;
      this.cookingTime = cookingTime;
      this.difficultyLevel = difficultyLevel;
      this.averageRating = averageRating;
      this.favoritedBy = favoritedBy;
    }
  
    // Getters and Setters omitted for brevity
  }
  
  public class Ingredient {
    private Long id;
    private String name;
    private double quantity;
    private Unit unit;
    private Recipe recipe;
  
    public Ingredient(Long id, String name, double quantity, Unit unit, Recipe recipe) {
      this.id = id;
      this.name = name;
      this.quantity = quantity;
      this.unit = unit;
      this.recipe = recipe;
    }
  
    // Getters and Setters omitted for brevity
  }
  
  public class User {
    private Long id;
    private String username;
    private String password; // Hashed password in a real application
    private List<Recipe> favoriteRecipes; // User's favorited recipes
  
    public User(Long id, String username, String password, List<Recipe> favoriteRecipes) {
      this.id = id;
      this.username = username;
      this.password = password;
      this.favoriteRecipes = favoriteRecipes;
    }
  
    // Getters and Setters omitted for brevity
  }
  
  enum Cuisine {
    ITALIAN, MEXICAN, INDIAN, etc.
  }
  
  enum DifficultyLevel {
    EASY, MEDIUM, HARD
  }
  
  enum Unit {
    GRAM, ML, TSP, etc.
  }
  
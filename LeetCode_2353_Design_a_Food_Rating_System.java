class FoodRatings {
    // Map from food name to Food object for quick lookup
    private Map<String, Food> foodtofood;
    
    // Map from cuisine name to a TreeSet of Food objects sorted by rating desc, then name asc
    private Map<String, TreeSet<Food>> cuisinetofoods;

    // Constructor initializes the data structures and populates them
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodtofood = new HashMap<>();
        cuisinetofoods = new HashMap<>();
        
        // Iterate over all foods to create Food objects and organize them by cuisine
        for (int i = 0; i < foods.length; i++) {
            Food f = new Food(foods[i], cuisines[i], ratings[i]);
            
            // Map food name to Food object
            foodtofood.put(foods[i], f);
            
            // For each cuisine, get or create a TreeSet with custom sorting:
            // - Higher rating first
            // - If ratings equal, lexicographically smaller name first
            cuisinetofoods.computeIfAbsent(cuisines[i], k -> new TreeSet<>((a, b) -> {
                if (a.rating != b.rating) 
                    return Integer.compare(b.rating, a.rating); // Descending rating
                return a.name.compareTo(b.name); // Ascending name
            })).add(f); // Add the food to the TreeSet for its cuisine
        }
    }
    
    // Change the rating of a given food
    public void changeRating(String food, int newRating) {
        // Retrieve the Food object by name
        Food f = foodtofood.get(food);
        
        // Get the TreeSet for the food's cuisine
        TreeSet<Food> set = cuisinetofoods.get(f.cuisine);
        
        // Remove the food from the TreeSet before updating rating
        // This is necessary because TreeSet relies on sorting order which depends on rating
        set.remove(f);
        
        // Update the rating
        f.rating = newRating;
        
        // Re-add the food to the TreeSet so it is placed correctly according to new rating
        set.add(f);
    }
    
    // Return the name of the highest-rated food for a given cuisine
    public String highestRated(String cuisine) {
        // The first element in the TreeSet is the highest-rated food due to sorting order
        return cuisinetofoods.get(cuisine).first().name;
    }
}

// Class representing a food item with name, cuisine, and rating
class Food {
    String name;
    String cuisine;
    int rating;

    // Constructor to initialize a Food object
    Food(String n, String c, int r) {
        name = n;
        cuisine = c;
        rating = r;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food, newRating);
 * String param_2 = obj.highestRated(cuisine);
 */

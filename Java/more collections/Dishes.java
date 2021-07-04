import java.util.*;
/**
 * Stores the data for the ingredients for a restaurant's dishes in a Map ADT
 * 
 * @author Simon Malpas
 * @version 15042021
 */
public class Dishes
{
   // instance variables
   private Map<String, Set<String>> dishes;

   /**
    * Zero arg constructor for objects of class Dishes
    */
   public Dishes()
   {
      dishes = new HashMap<>(); // unordered map
   }

   /**
    * Populates the map with a selection of test data in the form of 3 dishes
    * and their ingredients. No intervention required.
    */
   public void populateTestData()
   {
      //First dish – converts array to a list inline.
      Set<String> dish1 = new HashSet<>();
      String[] ingredients1 = {"Spaghetti",
                               "Egg",
                               "Pancetta",
                               "Parmesan"};

      dish1.addAll(Arrays.asList(ingredients1));
      dishes.put("Carbonara", dish1);
      
      // Second dish – uses static method of Collections class from Java API.
      Set<String> dish2 = new HashSet<>();
      String[] ingredients2 = {"Spaghetti",
                               "Beef mince",
                               "Passata",
                               "Onion",
                               "Garlic"};
      Collections.addAll(dish2, ingredients2);      
      dishes.put("Spaghetti Bolognase", dish2);
      
      // Third dish – uses for/each loop to iterate over array and add to set.
      Set<String> dish3 = new HashSet<>();
      String[] ingredients3 = {"Flour",
                               "Yeast",
                               "Salt",
                               "Water",
                               "Passata",
                               "Mozzarella"};
      for (String each : ingredients3)
      {
         dish3.add(each);
      }
      
      dishes.put("Pizza", dish3);
   }
   
   /**
    * Prints a human readable representation of the map stored in the 
    * Dishes object.
    */
   public void printMap()
   {
      for (String eachKey : dishes.keySet())
      {
         System.out.println("Dish: "
                          + eachKey);
         System.out.println("Ingredients: ");
         for (String eachIngredient : dishes.get(eachKey))
         {
            System.out.println("\t"+ eachIngredient);
         }
         System.out.println();
      }
   }
   
   /**
    * Takes argument and checks for corresponding key in map.
    * If found prints list of the ingredients found.
    * No match for keys prints corresponding statement.
    * @param aKey
    * String to search the map for.
    */
   public void printMapValue(String aKey)
   {
      if (dishes.containsKey(aKey))
      {
         System.out.println("Ingredients for "
                          + aKey + " found:");
         for (String eachIngredient : dishes.get(aKey))
         {
            System.out.println("\t" + eachIngredient);
         }
      }
      else
      {
         System.out.println(aKey + " not found");
      }
   }
   
   /**
    * Adds new dishes to the map.
    * @param aKey Map key, duplicate overwrites.
    * @param someIngredients set of strings of new ingredients.
    */
   public void addMapEntry(String aKey, Set<String> someIngredients)
   {
      dishes.put(aKey, someIngredients);
   }
   
   /**
    * Deletes a dish from the map for a given dish name
    * Returns True if successful, false otherwise.
    * @param aKey
    * key of entry to delete from the map.
    */
   public boolean deleteEntry(String aKey)
   {
      if (dishes.containsKey(aKey))
      {
         dishes.remove(aKey);
         return true;
      }
      else
      {
         return false;
      }
   }
   
   /**
    * Adds to the set of ingredients for a given key. 
    * Takes arguments of a key (dish) and an ingredient. Both strings
    * Assumption of no incorrect input. 
    * Does not return a value.
    * @param aKey string of key to add to.
    * @param anIngredient string of ingredient to add.
    */
   public void addToValueAtKey(String aKey, String anIngredient)
   {
      dishes.get(aKey).add(anIngredient);
   }
   
   /**
    * Deletes an ingredient from a dish.
    * Takes arguments of a key (dish) and an ingredient. Both strings.
    * Assumption of no incorrect entry.
    * Does not return a value.
    * @param aKey key to delete from
    * @param anIngredient string to delete
    */
   public void deleteFromValueAtKey(String aKey, String anIngredient)
   {
      dishes.get(aKey).remove(anIngredient);
   }
}

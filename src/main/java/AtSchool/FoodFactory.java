package AtSchool;

import java.util.ArrayList;

public class FoodFactory {
  static Food getFood(int number, final ArrayList<String> foods, String type) {
    Food food = new Food() {
      @Override
      public void giveFood(Animal animal) {
      }
    };
    int n = foods.size();

    try {
      if (type.equals("plant")) {
        for (int i = 0; i < n; i++) {
          if (PlantFood.getFoods().get(i).equals(foods.get(number - 1))) {
            food = new PlantFood(PlantFood.getFoods().get(number - 1));
            break;
          }
        }
      } else if (type.equals("animal")) {
        for (int i = 0; i < n; i++) {
          if (AnimalFood.getFoods().get(i).equals(foods.get(number - 1))) {
            food = new AnimalFood(AnimalFood.getFoods().get(number - 1));
            break;
          }
        }
      }
    } catch (IllegalArgumentException e) {
      System.out.println("Illegal argument");
    }

    return food;
  }

  static Food setFood(String name, String type) {
    switch (type) {
      case "plant":
        return new PlantFood(name);
      case "animal":
        return new AnimalFood(name);
      default:
        throw new RuntimeException("Unknown type");
    }
  }
}

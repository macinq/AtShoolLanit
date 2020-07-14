package AtSchool;

import java.util.ArrayList;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class FoodFactory {
  private static final Logger log = LogManager.getLogger(FoodFactory.class);

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
          if (PlantFood.getFoods().get(i).equals(foods.get(number))) {
            food = new PlantFood(PlantFood.getFoods().get(number));
            break;
          }
        }
      } else if (type.equals("animal")) {
        for (int i = 0; i < n; i++) {
          if (AnimalFood.getFoods().get(i).equals(foods.get(number))) {
            food = new AnimalFood(AnimalFood.getFoods().get(number));
            break;
          }
        }
      }
    } catch (IllegalArgumentException e) {
      log.error("Illegal argument: " + type);
      e.printStackTrace();
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

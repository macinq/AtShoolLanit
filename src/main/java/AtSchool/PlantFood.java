package AtSchool;

import java.util.ArrayList;
import java.util.Collections;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PlantFood extends Food {
  private static final Logger log = LogManager.getLogger(PlantFood.class);

  private static final ArrayList<String> foods = new ArrayList<>();

  static {
    foods.add(String.valueOf(Foods.CARROT));
    foods.add(String.valueOf(Foods.APPLE));
    foods.add(String.valueOf(Foods.SALAD));
    foods.add(String.valueOf(Foods.CORN));
    foods.add(String.valueOf(Foods.BANANA));
    Collections.sort(foods);
  }

  public static ArrayList<String> getFoods() {
    return foods;
  }

  public PlantFood(String name) {
    try {
      this.name = name;
      this.type = "plant";
      switch (name) {
        case "CARROT":
          this.fullness = 7;
          break;
        case "APPLE":
          this.fullness = 5;
          break;
        case "SALAD":
          this.fullness = 3;
          break;
        case "CORN":
          this.fullness = 6;
          break;
        case "BANANA":
          this.fullness = 8;
          break;
        default:
          throw new RuntimeException("Unknown name");
      }
    } catch (NullPointerException e) {
      log.error("Invalid input " + name);
      e.printStackTrace();
    } catch (RuntimeException e) {
      log.error("Unknown name: " + name);
      e.printStackTrace();
    }
  }

  @Override
  public void giveFood(Animal animal) {
    try {
      animal.eat(FoodFactory.setFood(this.name, this.type));
    } catch (IllegalArgumentException e) {
      log.error("Illegal argument: " + this.type);
      e.printStackTrace();
    }
  }
}


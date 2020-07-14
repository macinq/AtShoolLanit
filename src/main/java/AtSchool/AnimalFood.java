package AtSchool;

import java.util.ArrayList;
import java.util.Collections;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class AnimalFood extends Food {
  private static final Logger log = LogManager.getLogger(AnimalFood.class);

  private static final ArrayList<String> foods = new ArrayList<>();

  static {
    foods.add(String.valueOf(Foods.BEEF));
    foods.add(String.valueOf(Foods.PORK));
    foods.add(String.valueOf(Foods.FISH));
    foods.add(String.valueOf(Foods.CHICKEN));
    foods.add(String.valueOf(Foods.MUTTON));
    Collections.sort(foods);
  }

  public static ArrayList<String> getFoods() {
    return foods;
  }

  public AnimalFood(String name) {
    try {
      this.name = name;
      this.type = "animal";
      switch (name) {
        case "BEEF":
          this.fullness = 10;
          break;
        case "PORK":
          this.fullness = 15;
          break;
        case "FISH":
          this.fullness = 5;
          break;
        case "CHICKEN":
          this.fullness = 8;
          break;
        case "MUTTON":
          this.fullness = 17;
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


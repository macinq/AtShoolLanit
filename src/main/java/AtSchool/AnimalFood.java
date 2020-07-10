package AtSchool;

import java.util.ArrayList;
import java.util.Collections;

public class AnimalFood extends Food {

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
      }
    } catch (NullPointerException e) {
      throw new NullPointerException("Invalid input");
    }
  }

  @Override
  public void giveFood(Animal animal) {
    try {
      animal.eat(FoodFactory.setFood(this.name, this.type));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}


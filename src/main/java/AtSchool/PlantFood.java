package AtSchool;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class PlantFood extends Food {

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


package AtSchool;

import java.util.ArrayList;

public class PlantFood extends Food {

  private static final ArrayList<String> foods = new ArrayList<>();

  static {
    foods.add("Carrot");
    foods.add("Apple");
    foods.add("Salad");
    foods.add("Corn");
    foods.add("Banana");
  }

  public static ArrayList<String> getFoods() {
    return foods;
  }

  public PlantFood(String name) {
    try {
      this.name = name;
      this.type = "plant";
      switch (name) {
        case "Carrot":
          this.fullness = 7;
          break;
        case "Apple":
          this.fullness = 5;
          break;
        case "Salad":
          this.fullness = 3;
          break;
        case "Corn":
          this.fullness = 6;
          break;
        case "Banana":
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
    animal.eat(FoodFactory.setFood(this.name, this.type));
  }
}


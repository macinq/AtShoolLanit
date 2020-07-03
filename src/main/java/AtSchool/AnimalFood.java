package AtSchool;

import java.util.ArrayList;

public class AnimalFood extends Food {

  private static final ArrayList<String> foods = new ArrayList<>();

  static {
    foods.add("Beef");
    foods.add("Pork");
    foods.add("Fish");
    foods.add("Chicken");
    foods.add("Mutton");
  }

  public static ArrayList<String> getFoods() {
    return foods;
  }

  public AnimalFood(String name) {
    try {
      this.name = name;
      this.type = "animal";
      switch (name) {
        case "Beef":
          this.fullness = 10;
          break;
        case "Pork":
          this.fullness = 15;
          break;
        case "Fish":
          this.fullness = 5;
          break;
        case "Chicken":
          this.fullness = 8;
          break;
        case "Mutton":
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
    animal.eat(FoodFactory.setFood(this.name, this.type));
  }
}


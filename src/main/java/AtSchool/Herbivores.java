package AtSchool;

import java.util.ArrayList;

public class Herbivores extends Animal {
  @Override
  public void eat(Food food) {
    if (food.type.equals("plant")) {
      this.fullness += food.fullness;
    } else {
      this.fullness--;
      System.out.println("This is not plant food");
    }
  }

  private static final ArrayList<String> animals = new ArrayList<>();

  static {
    animals.add("Rabbit");
    animals.add("Zebra");
    animals.add("Giraffe");
    animals.add("Koala");
    animals.add("Duck");
  }

  public static ArrayList<String> getAnimals() {
    return animals;
  }

  public Herbivores(String name) {
    try {
      this.name = name;
      this.type = "herbivores";
    } catch (NullPointerException e) {
      throw new NullPointerException("Invalid input");
    }
  }

  @Override
  public void addAnimal(Animal animal, int index) {
  }
}

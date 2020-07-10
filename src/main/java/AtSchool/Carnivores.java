package AtSchool;

import java.util.ArrayList;

public class Carnivores extends Animal {
  @Override
  public void eat(Food food) throws Exception {
    if (food.type.equals("animal")) {
      this.fullness += food.fullness;
    } else {
      this.fullness--;
      throw new Exception("This is not animal food");
    }
  }

  private static final ArrayList<String> animals = new ArrayList<>();

  static {
    animals.add("Lion");
    animals.add("Tiger");
    animals.add("Bear");
    animals.add("Wolf");
    animals.add("Crocodile");
  }

  public static ArrayList<String> getAnimals() {
    return animals;
  }

  public Carnivores(String name) {
    try {
      this.name = name;
      this.type = "carnivores";
    } catch (NullPointerException e) {
      throw new NullPointerException("Invalid input");
    }
  }

  @Override
  public void addAnimal(Animal animal, int index) {
  }
}

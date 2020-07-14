package AtSchool;

import java.util.ArrayList;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Herbivores extends Animal {
  private static final Logger log = LogManager.getLogger(Herbivores.class);

  @Override
  public void eat(Food food) throws IllegalArgumentException {
    if (food.type.equals("plant")) {
      this.fullness += food.fullness;
    } else {
      this.fullness--;
      throw new IllegalArgumentException("This is not plant food");
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
      log.error("Invalid input " + name);
      e.printStackTrace();
    } catch (RuntimeException e) {
      log.error("Unknown name: " + name);
      e.printStackTrace();
    }
  }

  @Override
  public void addAnimal(Animal animal, int index) {
  }
}

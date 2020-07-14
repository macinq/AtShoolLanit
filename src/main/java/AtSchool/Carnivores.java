package AtSchool;

import java.util.ArrayList;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Carnivores extends Animal {
  private static final Logger log = LogManager.getLogger(Carnivores.class);

  @Override
  public void eat(Food food) throws IllegalArgumentException {
    if (food.type.equals("animal")) {
      this.fullness += food.fullness;
    } else {
      this.fullness--;
      throw new IllegalArgumentException("This is not animal food");
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

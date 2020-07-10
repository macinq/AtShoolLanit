package AtSchool;

import java.util.ArrayList;

public class ZooFactory {
  static Animal getAnimal(int number, final ArrayList<String> animals, String type) {
    Animal animal = new Animal() {
      @Override
      public void addAnimal(Animal animal, int index) {
      }

      @Override
      public void eat(Food food) {
      }
    };
    int n = animals.size();

    try {
      if (type.equals("herbivores")) {
        for (int i = 0; i < n; i++) {
          if (Herbivores.getAnimals().get(i).equals(animals.get(number))) {
            animal = new Herbivores(Herbivores.getAnimals().get(number));
            break;
          }
        }
      } else if (type.equals("carnivores")) {
        for (int i = 0; i < n; i++) {
          if (Carnivores.getAnimals().get(i).equals(animals.get(number))) {
            animal = new Carnivores(Carnivores.getAnimals().get(number));
            break;
          }
        }
      }
    } catch (IllegalArgumentException e) {
      System.out.println("Illegal argument");
    }

    return animal;
  }

  static Animal setAnimal(String name, String type) {
    switch (type) {
      case "herbivores":
        return new Herbivores(name);
      case "carnivores":
        return new Carnivores(name);
      default:
        throw new RuntimeException("Unknown type");
    }
  }
}

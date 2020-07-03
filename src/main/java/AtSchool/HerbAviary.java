package AtSchool;

import java.util.ArrayList;

public class HerbAviary implements Aviary {
  int size;
  int fullness;
  Animal[] aviary;

  @Override
  public void addAnimal(Animal animal, int index) {
    aviary[index] = ZooFactory.setAnimal(animal.name, animal.type);
  }

  public HerbAviary(int size) {
    this.size = size;
    this.aviary = new Animal[size];
  }
}

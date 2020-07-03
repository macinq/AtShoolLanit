package AtSchool;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CarnAviary implements Aviary {
  int size;
  int fullness;
  Animal[] aviary;

  @Override
  public void addAnimal(Animal animal, int index) {
    aviary[index] = ZooFactory.setAnimal(animal.name, animal.type);
  }

  public CarnAviary(int size) {
    this.size = size;
    this.aviary = new Animal[size];
  }
}

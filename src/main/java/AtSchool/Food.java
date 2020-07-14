package AtSchool;

public abstract class Food {
  String name;
  String type;
  int fullness;

  public abstract void giveFood(Animal animal) throws IllegalArgumentException;

  public enum Foods {
    CARROT,
    APPLE,
    SALAD,
    CORN,
    BANANA,
    BEEF,
    PORK,
    FISH,
    CHICKEN,
    MUTTON
  }
}

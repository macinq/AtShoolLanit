package AtSchool;

public abstract class Animal implements Aviary {
  String name;
  String type;
  int fullness;
  public abstract void eat(Food food) throws Exception;
}

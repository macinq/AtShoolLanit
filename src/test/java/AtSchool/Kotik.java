package AtSchool;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

import java.util.Objects;

public class Kotik {
//  @Test
//  public void example1() {
//    Kotik kotik = new Kotik();
//    kotik.prettiness = 9999;
//    kotik.name = "Рыжый";
//    kotik.weight = 6327;//в граммах
//
//  }
//
//  @Test
//  public void example2() {
//    Kotik kotik1; // Объявление переменной
//    Kotik kotik2; // Объявление переменной
//    kotik1 = new Kotik(); // инициализация переменной
//    kotik2 = kotik1; //Переприсваивание ссылки
//    kotik1.prettiness = 9999;
//    kotik1.name = "Рыжый";
//    kotik1.weight = 6327;//в граммах
//    System.out.println(kotik2.name + " - " + kotik2.prettiness);
//  }
//
//  @Test
//  public void example3() {
//    Kotik kotik1; // Объявление переменной
//    kotik1 = new Kotik(); // инициализация переменной
//    kotik1.prettiness = 9999;
//    kotik1.name = "Рыжый";
//    kotik1.weight = 6327;//в граммах
//    kotik1.meow = "Кря кря";
//    kotik1.sayMeow();
//  }

  int prettiness;
  int weight;
  String name;
  String meow;
  int fullness;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Kotik kotik = (Kotik) o;
    return prettiness == kotik.prettiness &&
            weight == kotik.weight &&
            fullness == kotik.fullness &&
            name.equals(kotik.name) &&
            meow.equals(kotik.meow);
  }

  @Override
  public int hashCode() {
    return Objects.hash(prettiness, weight, name, meow, fullness);
  }

  //Конструктор без параметров, он идентичен конструктору по умолчанию,
  //который сюда бы подставила Java,
  // Но она его не подставит, по той причине,
  //что ниже определяется другой конструктор, с параметрами.
  public Kotik() {
  }

  public Kotik(int prettiness, int weight, String name, String meow, int fullness) {
    this.prettiness = prettiness;
    this.weight = weight;
    this.name = name;
    this.meow = meow;
    this.fullness = fullness;
  }


  void setKotik(int prettiness, int weight, String name, String meow, int fullness) {
    this.prettiness = prettiness;
    this.weight = weight;
    this.name = name;
    this.meow = meow;
    this.fullness = fullness;
  }

  int giveMeMoney() {
    return 100;
  }

  void sayMeow() {
    System.out.println(name + " говорит " + meow);
  }

  boolean eat(int fullness) {
    this.fullness += fullness;
    this.weight++;
    return true;
  }

  boolean eat(int fullness, String food) {
    if (food.equals("Meat")) {
      this.fullness += fullness;
      this.weight++;
    } else {
      this.fullness += 10;
      this.weight++;
    }
    return true;
  }

  boolean eat() {
    eat(100, "Milk");
    return true;
  }

  boolean play() {
    prettiness += 50;
    fullness -= 20;
    weight--;
    return true;
  }

  boolean sleep() {
    prettiness += 20;
    fullness -= 30;
    weight--;
    return true;
  }

  boolean lickingOut() {
    prettiness -= 5;
    fullness -= 5;
    return true;
  }

  boolean chaseMouse() {
    fullness -= 40;
    weight -= 2;
    return true;

  }

  boolean chaseSunnyBunny() {
    prettiness += 40;
    fullness -= 20;
    weight--;
    return true;
  }

  boolean goToTheToiletTray() {
    fullness -= 10;
    weight -= 2;
    return true;
  }

  void liveAnotherDay() {
    int h = 8;
    for (int i = 0; i < 24; i++) {
      int flag = (int) (Math.random() * h + 1);
      if (fullness > 0) {
        switch (flag) {
          case 1:
            sayMeow();
            System.out.println("Log: <sayMeow> true");
            break;
          case 2:
            boolean eat = eat();
            System.out.println("Log: <eat> " + eat);
            break;
          case 3:
            boolean play = play();
            System.out.println("Log: <play> " + play);
            break;
          case 4:
            boolean sleep = sleep();
            System.out.println("Log: <sleep> " + sleep);
            break;
          case 5:
            boolean lickingOut = lickingOut();
            System.out.println("Log: <lickingOut> " + lickingOut);
            break;
          case 6:
            boolean chaseMouse = chaseMouse();
            System.out.println("Log: <chaseMouse> " + chaseMouse);
            break;
          case 7:
            boolean chaseSunnyBunny = chaseSunnyBunny();
            System.out.println("Log: <chaseSunnyBunny> " + chaseSunnyBunny);
            break;
          case 8:
            boolean goToTheToiletTray = goToTheToiletTray();
            System.out.println("Log: <goToTheToiletTray> " + goToTheToiletTray);
            break;
          default:
            throw new IllegalArgumentException("Incorrect value");
        }
      } else {
        System.out.println("Log: <action> false");
        boolean eat = eat(10);
        System.out.println("Log: <eat> " + eat);
      }
    }
  }

  public static void main(String[] args) {
    Kotik kotik1 = new Kotik(6, 2, "Johnny", "Meowmeow", 0);
    Kotik kotik2 = new Kotik(10, 4, "Maks", "Murrrmeow", 0);
    Kotik kotik3 = new Kotik(8, 3, "Kuks", "Khryameow", 0);

    Gson gson1 = new Gson();
    Gson gson2 = new Gson();
    Gson gson3 = new Gson();
    String serialKotik1 = gson1.toJson(kotik1);
    String serialKotik2 = gson2.toJson(kotik2);
    String serialKotik3 = gson3.toJson(kotik3);

    System.out.println("prettiness | weight | name | meow | fullness");
    System.out.println(kotik1.prettiness + "\t\t\t" + kotik1.weight + "\t\t " + kotik1.name + "\t" + kotik1.meow + "\t\t" + kotik1.fullness);
//    kotik1.liveAnotherDay();
//    System.out.println(kotik1.prettiness + "\t\t\t" + kotik1.weight + "\t\t " + kotik1.name + "\t" + kotik1.meow + "\t\t" + kotik1.fullness);
//    System.out.println();
//    System.out.println("prettiness | weight | name | meow | fullness");
    System.out.println(kotik2.prettiness + "\t\t\t" + kotik2.weight + "\t\t " + kotik2.name + "\t" + kotik2.meow + "\t\t" + kotik2.fullness);
//    kotik1.liveAnotherDay();
//    System.out.println(kotik2.prettiness + "\t\t\t" + kotik2.weight + "\t\t " + kotik2.name + "\t" + kotik2.meow + "\t\t" + kotik2.fullness);
//    System.out.println();
//    System.out.println("prettiness | weight | name | meow | fullness");
    System.out.println(kotik3.prettiness + "\t\t\t" + kotik3.weight + "\t\t " + kotik3.name + "\t" + kotik3.meow + "\t\t" + kotik3.fullness);
//    kotik2.liveAnotherDay();
//    System.out.println(kotik3.prettiness + "\t\t\t" + kotik3.weight + "\t\t " + kotik3.name + "\t" + kotik3.meow + "\t\t" + kotik3.fullness);

    Kotik deserialKotik1 = gson1.fromJson(serialKotik1, Kotik.class);
    Kotik deserialKotik2 = gson2.fromJson(serialKotik2, Kotik.class);
    Kotik deserialKotik3 = gson3.fromJson(serialKotik3, Kotik.class);

    System.out.println("prettiness | weight | name | meow | fullness");
    System.out.println(deserialKotik1.prettiness + "\t\t\t" + deserialKotik1.weight + "\t\t " + deserialKotik1.name + "\t" + deserialKotik1.meow + "\t\t" + deserialKotik1.fullness);
//    kotik1.liveAnotherDay();
//    System.out.println(deserialKotik1.prettiness + "\t\t\t" + deserialKotik1.weight + "\t\t " + deserialKotik1.name + "\t" + deserialKotik1.meow + "\t\t" + deserialKotik1.fullness);
//    System.out.println();
//    System.out.println("prettiness | weight | name | meow | fullness");
    System.out.println(deserialKotik2.prettiness + "\t\t\t" + deserialKotik2.weight + "\t\t " + deserialKotik2.name + "\t" + deserialKotik2.meow + "\t\t" + deserialKotik2.fullness);
//    kotik1.liveAnotherDay();
//    System.out.println(deserialKotik2.prettiness + "\t\t\t" + deserialKotik2.weight + "\t\t " + deserialKotik2.name + "\t" + deserialKotik2.meow + "\t\t" + deserialKotik2.fullness);
//    System.out.println();
//    System.out.println("prettiness | weight | name | meow | fullness");
    System.out.println(deserialKotik3.prettiness + "\t\t\t" + deserialKotik3.weight + "\t\t " + deserialKotik3.name + "\t" + deserialKotik3.meow + "\t\t" + deserialKotik3.fullness);
//    kotik2.liveAnotherDay();
//    System.out.println(deserialKotik3.prettiness + "\t\t\t" + deserialKotik3.weight + "\t\t " + deserialKotik3.name + "\t" + deserialKotik3.meow + "\t\t" + deserialKotik3.fullness);

    Assert.assertNotEquals("Объекты эквивалентны", kotik1, deserialKotik1);
    Assert.assertNotEquals("Объекты эквивалентны", kotik2, deserialKotik2);
    Assert.assertNotEquals("Объекты эквивалентны", kotik3, deserialKotik3);

  }
}

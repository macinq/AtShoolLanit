package AtSchool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Zoo!
 */
public class App {
  private static void printHelp() {
    System.out.println("****HELP****");
    System.out.println("Food: Beef Pork Fish Chicken Mutton , Carrot Apple Salad Corn Banana");
    System.out.println("Animal: Lion Bear Wolf Crocodile , Rabbit Zebra Giraffe Koala Parrot");
    System.out.println("Actions: add feed [carnivorous & animal food , herbivore & plant food]");
    System.out.println("Start: start");
    System.out.println("Exit: exit");
    System.out.println("Help: help");
    System.out.println("************");
  }

  public static void main(String[] args) throws IOException {
    InputStream in = System.in;
    BufferedReader br = new BufferedReader(new InputStreamReader(in));
    String str;
    String start = "start";
    String exit = "exit";
    String help = "help";

    printHelp();

    do {
      System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd MMMM uuuu HH:mm:ss", Locale.ENGLISH)));
      System.out.println("Welcome to the cyber zoo!");
      System.out.println("************");
      System.out.println("Input:");
      try {
        str = br.readLine();
      } catch (IOException e) {
        throw new RuntimeException("Invalid input");
      }

      if (str.equalsIgnoreCase(start)) {
        try {
          System.out.println("Enter the number of Carnivores:");
          int carnCount = Integer.parseInt(br.readLine());
          System.out.println("Enter the number of Herbivores:");
          int herbCount = Integer.parseInt(br.readLine());
          System.out.println("Enter the size of aviares:");
          int h = Integer.parseInt(br.readLine());
          System.out.println("Enter the number of aviares:");
          int n = Integer.parseInt(br.readLine());
          System.out.println("LOG");
          System.out.println("***");
          System.out.println("carnCount: " + carnCount);
          System.out.println("herbCount: " + herbCount);
          System.out.println("***");

          ArrayList<CarnAviary> carnAviaries = new ArrayList<>();
          ArrayList<HerbAviary> herbAviaries = new ArrayList<>();
          for (int i = 0; i < n; i++) {
            carnAviaries.add(new CarnAviary(h));
            herbAviaries.add(new HerbAviary(h));
          }
          System.out.println("Aviaries is created");
          System.out.println("Would you like to add animals? Y/N");
          System.out.println("Input:");
          String answer = br.readLine();
          if (answer.equalsIgnoreCase("y")) {
            try {
              String add = "";
              while (!add.equalsIgnoreCase("add")) {
                System.out.println("Add carnivores?");
                System.out.println("Input:");
                add = br.readLine();
              }
              for (int i = 0; i < carnAviaries.size(); i++) {
                int flag = 1;
                System.out.println("***");
                for (int j = 0; j < carnAviaries.get(i).aviary.length; j++) {
                  if ((flag == 1) && (carnCount > 0 && carnAviaries.get(i).fullness < carnAviaries.get(i).aviary.length)) {
                    Random r = new Random();
                    int random = r.nextInt(Carnivores.getAnimals().size());
                    carnAviaries.get(i).addAnimal(ZooFactory.getAnimal(random, Carnivores.getAnimals(), "carnivores"), j);
                    carnAviaries.get(i).fullness++;
                    carnCount--;
                    System.out.println("random: " + random);
                    System.out.println("Carnivores: " + carnAviaries.get(i).aviary[j].name);
                    System.out.println("carnCount: " + carnCount);
                  } else if (carnAviaries.get(i).fullness == carnAviaries.get(i).aviary.length) {
                    flag = 0;
                    System.out.println("No room");
                    System.out.println("Next aviary");
                  } else if (carnCount == 0) {
                    System.out.println("There are no more animals");
                    break;
                  }
                  System.out.println("***");
                }
                System.out.println("Finish " + i + " aviary");
                System.out.println("carnCount: " + carnCount);
                System.out.println();
              }

              add = "";
              while (!add.equalsIgnoreCase("add")) {
                System.out.println("Add herbivores?");
                System.out.println("Input:");
                add = br.readLine();
              }
              for (int i = 0; i < herbAviaries.size(); i++) {
                int flag = 1;
                System.out.println("***");
                for (int j = 0; j < herbAviaries.get(i).aviary.length; j++) {
                  if ((flag == 1) && (herbCount > 0 && herbAviaries.get(i).fullness < herbAviaries.get(i).aviary.length)) {
                    Random r = new Random();
                    int random = r.nextInt(Herbivores.getAnimals().size());
                    herbAviaries.get(i).addAnimal(ZooFactory.getAnimal(random, Herbivores.getAnimals(), "herbivores"), j);
                    herbAviaries.get(i).fullness++;
                    herbCount--;
                    System.out.println("random: " + random);
                    System.out.println("Carnivores: " + herbAviaries.get(i).aviary[j].name);
                    System.out.println("herbCount: " + herbCount);
                  } else if (herbAviaries.get(i).fullness == herbAviaries.get(i).aviary.length) {
                    flag = 0;
                    System.out.println("No room");
                    System.out.println("Next aviary");
                  } else if (herbCount == 0) {
                    System.out.println("There are no more animals");
                    break;
                  }
                  System.out.println("***");
                }
                System.out.println("Finish " + i + " aviary");
                System.out.println("herbCount: " + herbCount);
                System.out.println();
              }
            } catch (IOException e) {
              throw new RuntimeException("Invalid input");
            }
          } else {
            System.out.println("A zoo cannot exist without animals");
            System.out.println("Try again");
            System.out.println();
            printHelp();
          }

          System.out.println("Animals added");
          System.out.println("Do you want to feed animals? Y/N");
          System.out.println("Input:");
          answer = br.readLine();
          if (answer.equalsIgnoreCase("y")) {
            try {
              String feed = "";
              while (!feed.equalsIgnoreCase("feed")) {
                System.out.println("Feed the carnivores?");
                System.out.println("Input:");
                feed = br.readLine();
              }
              for (int i = 0; i < carnAviaries.size(); i++) {
                int flag = 1;
                System.out.println("***");
                for (int j = 0; j < carnAviaries.get(i).aviary.length; j++) {
                  if ((flag == 1 && carnAviaries.get(i).aviary[j] != null) && (carnAviaries.get(i).aviary[j].fullness <= 0)) {
                    Random r = new Random();
                    int random = r.nextInt(AnimalFood.getFoods().size());
//                    Food food = FoodFactory.getFood(random, AnimalFood.getFoods(), "animal");
                    Food food = FoodFactory.getFood(random, PlantFood.getFoods(), "plant");
//                    new AnimalFood(food.name).giveFood(carnAviaries.get(i).aviary[j]);
                    new PlantFood(food.name).giveFood(carnAviaries.get(i).aviary[j]);
                    System.out.println("random: " + random);
                    System.out.println("food: " + food.name + " fullness: " + food.fullness);
                    System.out.println("Carnivores: " + carnAviaries.get(i).aviary[j].name + " fullness: " + carnAviaries.get(i).aviary[j].fullness);
                  } else if (carnAviaries.get(i).aviary[j] == null) {
                    System.out.println("No animals");
                    break;
                  } else if (carnAviaries.get(i).aviary[j].fullness >= 0) {
                    flag = 0;
                    System.out.println("The animal is not hungry");
                  }
                  System.out.println("***");
                }
                System.out.println("Finish " + i + " aviary");
                System.out.println();
              }

              feed = "";
              while (!feed.equalsIgnoreCase("feed")) {
                System.out.println("Feed the herbivores?");
                System.out.println("Input:");
                feed = br.readLine();
              }
              for (int i = 0; i < herbAviaries.size(); i++) {
                int flag = 1;
                System.out.println("***");
                for (int j = 0; j < herbAviaries.get(i).aviary.length; j++) {
                  if ((flag == 1 && herbAviaries.get(i).aviary[j] != null) && (herbAviaries.get(i).aviary[j].fullness <= 0)) {
                    Random r = new Random();
                    int random = r.nextInt(PlantFood.getFoods().size());
                    Food food = FoodFactory.getFood(random, PlantFood.getFoods(), "plant");
                    new PlantFood(food.name).giveFood(herbAviaries.get(i).aviary[j]);
                    System.out.println("random: " + random);
                    System.out.println("food: " + food.name + " fullness: " + food.fullness);
                    System.out.println("Carnivores: " + herbAviaries.get(i).aviary[j].name + " fullness: " + herbAviaries.get(i).aviary[j].fullness);
                  } else if (herbAviaries.get(i).aviary[j] == null) {
                    System.out.println("No animals");
                    break;
                  } else if (herbAviaries.get(i).aviary[j].fullness >= 0) {
                    flag = 0;
                    System.out.println("The animal is not hungry");
                  }
                  System.out.println("***");
                }
                System.out.println("Finish " + i + " aviary");
                System.out.println();
              }
            } catch (IOException e) {
              throw new RuntimeException("Invalid input");
            }
          } else {
            System.out.println("Animals starve to death");
            System.out.println("Try again");
            System.out.println();
            printHelp();
          }
        } catch (IOException e) {
          throw new RuntimeException("Invalid input");
        }
      } else if (str.equalsIgnoreCase(help)) {
        printHelp();
      }
    } while (!str.equalsIgnoreCase(exit));
    System.out.println("Goodbye");
  }
}

package AtSchool;

import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * Zoo!
 */
public class App {
  private static final Logger log = LogManager.getLogger(App.class);
//  private static String jsonCarnAviaries;
//  private static String jsonHerbAviaries;
//  private static Gson gsonC = new Gson();
//  private static Gson gsonH = new Gson();

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

  public static void main(String[] args) {
    InputStream in = System.in;
    BufferedReader br = new BufferedReader(new InputStreamReader(in));
    String str = "";
    String start = "start";
    String exit = "exit";
    String help = "help";

    printHelp();

    do {
//      System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss SSS", Locale.ENGLISH)));
      System.out.println(DateTimeFormatter.ISO_INSTANT.format(ZonedDateTime.now()));
      System.out.println("Welcome to the cyber zoo!");
      System.out.println("************");
      System.out.println("Input:");
      try {
        str = br.readLine();
      } catch (IOException e) {
        log.error("Invalid input");
        e.printStackTrace();
      }

      if (str.equalsIgnoreCase(start)) {
        try {
          System.out.println("Enter the number of Carnivores:");
          int carnCount = Integer.parseInt(br.readLine());
          System.out.println("Enter the number of Herbivores:");
          int herbCount = Integer.parseInt(br.readLine());
          System.out.println("Enter the size of aviares:");
          int size = Integer.parseInt(br.readLine());
          System.out.println("Enter the number of aviares:");
          int num = Integer.parseInt(br.readLine());
          System.out.println("***");
          log.info("carnCount: " + carnCount);
          log.info("herbCount: " + herbCount);
          log.info("size: " + size);
          log.info("num: " + num);
          System.out.println("***");
          Type collectionCarn = new TypeToken<Collection<CarnAviary>>(){}.getType();
          Type collectionHerb = new TypeToken<Collection<HerbAviary>>(){}.getType();
//          ArrayList<CarnAviary> carnAviaries = gsonC.fromJson(jsonCarnAviaries, collectionCarn);
//          ArrayList<HerbAviary> herbAviaries = gsonH.fromJson(jsonHerbAviaries, collectionHerb);
          ArrayList<CarnAviary> carnAviaries = null;
          ArrayList<HerbAviary> herbAviaries = null;
          if (carnAviaries != null) {
            for (int i = 0; i < carnAviaries.size(); i++) {
              System.out.println(carnAviaries.get(i));
            }
          }
          if (herbAviaries != null) {
            for (int i = 0; i < herbAviaries.size(); i++) {
              System.out.println(herbAviaries.get(i));
            }
          }
          if (carnAviaries == null) {
            carnAviaries = new ArrayList<>();
            for (int i = 0; i < num; i++) {
              carnAviaries.add(new CarnAviary(size));
            }
          }
          if (herbAviaries == null) {
            herbAviaries = new ArrayList<>();
            for (int i = 0; i < num; i++) {
              herbAviaries.add(new HerbAviary(size));
            }
          }


//          for (int i = 0; i < num; i++) {
//            carnAviaries.add(new CarnAviary(size));
//            herbAviaries.add(new HerbAviary(size));
//          }
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
                    log.info("random: " + random);
                    log.info("carnivores: " + carnAviaries.get(i).aviary[j].name);
                    log.info("carnCount: " + carnCount);
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
                log.info("finish " + i + " aviary");
                log.info("carnCount: " + carnCount);
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
                    log.info("random: " + random);
                    log.info("herbivores: " + herbAviaries.get(i).aviary[j].name);
                    log.info("herbCount: " + herbCount);
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
                log.info("finish " + i + " aviary");
                log.info("herbCount: " + herbCount);
                System.out.println();
              }
            } catch (IOException e) {
              log.error("Invalid input");
              e.printStackTrace();
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
                    log.info("random: " + random);
                    log.info("food: " + food.name + " fullness: " + food.fullness);
                    log.info("carnivores: " + carnAviaries.get(i).aviary[j].name + " fullness: " + carnAviaries.get(i).aviary[j].fullness);
                  } else if (carnAviaries.get(i).aviary[j] == null) {
                    System.out.println("No animals");
                    break;
                  } else if (carnAviaries.get(i).aviary[j].fullness >= 0) {
                    flag = 0;
                    System.out.println("The animal is not hungry");
                  }
                  System.out.println("***");
                }
                log.info("finish " + i + " aviary");
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
                    log.info("random: " + random);
                    log.info("food: " + food.name + " fullness: " + food.fullness);
                    log.info("herbivores: " + herbAviaries.get(i).aviary[j].name + " fullness: " + herbAviaries.get(i).aviary[j].fullness);
                  } else if (herbAviaries.get(i).aviary[j] == null) {
                    System.out.println("No animals");
                    break;
                  } else if (herbAviaries.get(i).aviary[j].fullness >= 0) {
                    flag = 0;
                    System.out.println("The animal is not hungry");
                  }
                  System.out.println("***");
                }
                log.info("finish " + i + " aviary");
                System.out.println();
              }
            } catch (IOException e) {
              log.error("Invalid input");
              e.printStackTrace();
            }
          } else {
            System.out.println("Animals starve to death");
            System.out.println("Try again");
            System.out.println();
            printHelp();
          }
//          jsonCarnAviaries = gsonC.toJson(carnAviaries);
//          jsonHerbAviaries = gsonH.toJson(herbAviaries);
        } catch (IOException e) {
          log.error("Invalid input");
          e.printStackTrace();
        }
      } else if (str.equalsIgnoreCase(help)) {
        printHelp();
      }
    } while (!str.equalsIgnoreCase(exit));
    System.out.println("Goodbye");
  }
}

package AtSchool;

import org.junit.Test;

public class Kotik {
    @Test
    public void example1() {
        Kotik kotik = new Kotik();
        kotik.prettiness = 9999;
        kotik.name = "Рыжый";
        kotik.weight = 6327;//в граммах

    }

    @Test
    public void example2() {
        Kotik kotik1; // Объявление переменной
        Kotik kotik2; // Объявление переменной
        kotik1 = new Kotik(); // инициализация переменной
        kotik2 = kotik1; //Переприсваивание ссылки
        kotik1.prettiness = 9999;
        kotik1.name = "Рыжый";
        kotik1.weight = 6327;//в граммах
        System.out.println(kotik2.name + " - " + kotik2.prettiness);
    }

    @Test
    public void example3() {
        Kotik kotik1; // Объявление переменной
        kotik1 = new Kotik(); // инициализация переменной
        kotik1.prettiness = 9999;
        kotik1.name = "Рыжый";
        kotik1.weight = 6327;//в граммах
        kotik1.meow = "Кря кря";
        kotik1.sayMeow();
    }

    int prettiness;
    int weight;
    String name;
    String meow;

    //Конструктор без параметров, он идентичен конструктору по умолчанию, 
    //который сюда бы подставила Java,    
    // Но она его не подставит, по той причине, 
    //что ниже определяется другой конструктор, с параметрами.
    public Kotik() {
    }

    public Kotik(int prettiness, int weight, String name, String meow) {this.prettiness = prettiness;
        this.weight = weight;this.name = name;this.meow = meow;}


    void setKotik(int prettiness, String name, int weight, String meow) {
        this.prettiness = prettiness;
        this.weight = weight;
        this.name = name;
        this.meow = meow;
    }

    int giveMeMoney() {
        return 100;
    }

    void sayMeow() {
        System.out.println(name + " говорит " + meow);
    }
}

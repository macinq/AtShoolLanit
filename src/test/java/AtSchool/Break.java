package AtSchool;

import org.junit.Test;

public class Break {
    @Test
    public void example1() {
        for (int i = 0; i < 100; i++) {
            if (i == 10) break; // выход из цикла, если значение
            // переменной i равно 10
            System.out.println("i: " + i);
        }

    }

    @Test
    public void example2() {
        for (int i = 0; i < 3; i++) {
            System.out.print(" Пpoxoд " + i + " : ");
            for (int j = 0; j < 100; j++) {
                if (j == 10)
                    break; //выход из цикла, значение
                // переменной j равно 10
                System.out.print(j + " ");
            }
            System.out.println();
        }
        System.out.println("Циклы завершены.");
    }

    @Test
    public void example3() {
        block1:
        {
            System.out.println("Это какой-то код");
            System.out.println("которые выполнится до этого момента");
            if (true) break block1;
            System.out.println("а до этого момента не даст выполниться break");
        }
    }

    @Test
    public void example4() {
        outer:
        for (int i = 0; i < 3; i++) {
            System.out.print("Пpoxoд " + i + ": ");
            for (int j = 0; j < 100; j++) {
                if (j == 10)
                    break outer; // выход из обоих цикло
                System.out.print(j + " ");
            }
            System.out.println("Этa строка не будет выводиться");
        }
        System.out.println("Циклы завершены.");
    }
}

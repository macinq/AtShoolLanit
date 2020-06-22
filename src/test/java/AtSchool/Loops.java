package AtSchool;

import org.junit.Test;

public class Loops {

    @Test
    public void whileLoop() {
        int n = 10;
        while (n > 0) {
            System.out.println(" тaкт " + n);
            n--;
        }
    }

    @Test
    public void doWhileLoop() {
        int n = 10;
        do {
            System.out.println(" тaкт " + n);
            n--;
        } while (n > 0);

    }

    @Test
    public void forLoop() {
        for (int n = 10; n > 0; --n) {
            System.out.println(" тaкт " + n);
        }
    }

}

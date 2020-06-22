package AtSchool;

import org.junit.Test;

public class Continue {
    @Test
    public void example1() {
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) continue;
            System.out.println(i);
        }
    }

    @Test
    public void example2() {
        outer:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (j > i) {
                    System.out.println();
                    continue outer;
                }
                System.out.print(" " + (i * j));
            }
        }
    }
}

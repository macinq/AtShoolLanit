package AtSchool;

import org.junit.Test;

public class Arrays {

    @Test
    public void example(){
        int array1[] = new int[3];
        int[] array2 = new int[4];

        for (int i = 0; i < array1.length; i++) {
            array1[i] = i;
        }

        for (int i = 0; i < array2.length; i++) {
            array2[i] = i;
        }

        int[][] multiDimArray = new int[2][];
        multiDimArray[0] = array1;
        multiDimArray[1] = array2;

        for (int i = 0; i < multiDimArray.length; i++) {
            for (int j = 0; j < multiDimArray[i].length; j++) {
                System.out.print(multiDimArray[i][j] + " ");
            }
            System.out.println();
        }

    }
}

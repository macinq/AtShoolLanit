package AtSchool;

import org.junit.Test;

public class AreasForVariables {

  @Test
  public void Example1() {
    int a = 4;
    if (a > 3) {
      int b = 4;
    }
    for (int i = 0; i < 5; ++i) {
      // Ошибка
      // System.out.println(b);
      // Переменная из верхнего блока
      System.out.println(a);
      // Переменная из этого блока
      System.out.println(i);
    }

    //Ошибка
    //Переменная i существует только в теле цикла for
    //System.out.println(i);
  }

}



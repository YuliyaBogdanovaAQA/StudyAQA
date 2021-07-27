package school.lesson1;


public class HomeworkApp {

      public static void main (String[] args) {

        printThreeWords ();

        checkSumSing ();

        printColor(0);

        compareNumbers();

    }

    public static void printThreeWords () {   //2
        System.out.println("Orange" + "\nBanana" + "\nApple");
    }

    public static void checkSumSing() {    //3
        int a = 5;
        int b = 7;
        int sum = a+b;
        if (sum >= 0)
            System.out.println("Сумма положительная");
        else
            System.out.println("умма отрицательная");
    }

    public static void printColor(int value) {     //4
        if (value <=0)
            System.out.println("Красный");
        else if (value >0 && value<=100)
            System.out.println("Желтый");
        else
            System.out.println("Зеленый");
    }

    public static void compareNumbers() {     //5
        int a = 7;
        int b = 90;
        if (a>=b)
            System.out.println("a>=b");
        else
            System.out.println("a<b");
    }

}

package school.lesson2;

public class HomeWorkTwo {

    public static void main(String[] args) {

        int[] arrayTaskSix = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};                //6
        for (int i = 0; i < arrayTaskSix.length; i++) {
            if (arrayTaskSix[i] == 1)
                arrayTaskSix[i] = 0;
            else
                arrayTaskSix[i] = 1;
        }

        int[] arrayTaskSeven = new int[100];                                //7
        for (int s : arrayTaskSeven) {
            ++arrayTaskSeven[s];
        }

        int[] arrayTaskEight = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};       //8
        for (int s = 0; s < arrayTaskEight.length; s++) {
            if (arrayTaskEight[s] < 6)
                arrayTaskEight[s] = arrayTaskEight[s] * 2;
        }

        int i = 7;                                                          //9
        int[][] arrayTaskNine = new int[i][i];
        for (i = 0; i < arrayTaskNine.length; i++) {
            for (int j = 0, b = arrayTaskNine[i].length - 1; j < arrayTaskNine[i].length; j++, b--) {
                if (i == j || i == b)
                    arrayTaskNine[i][j] = 1;
            }
        }
    }

    static boolean taskOne(int a, int b) {                                        //1
        int sum = a + b;
        return (sum >= 10) && (sum <= 20);
    }

    static void taskTwo(int a) {                                                 //2
        String str = a >= 0 ? "The number is positive" : "The number is negative";
        System.out.println(str);
    }

    static boolean taskThree(int a) {                                            //3
        return a < 0;
    }

    static void taskFour(String str, int a) {                                   //4
        int i = 0;
        while (i < a) {
            System.out.println(str);
            i++;
        }
    }

    static boolean taskFive(int a) {                                          //*
        return (a % 4 == 0) && (a % 100 != 0) || (a % 400 == 0);
    }

}
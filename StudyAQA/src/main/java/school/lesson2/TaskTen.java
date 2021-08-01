package school.lesson2;

import java.util.Arrays;

public class TaskTen {

    public static void main(String[] args) {

//* Вариант 1.
        int[] arrayTen = new int[20];
        int max = 0;
        int min = 100;


        for (int i = 0; i < arrayTen.length; i++) {
            arrayTen[i] = numberForFill(200, 100);
            System.out.print(arrayTen[i] + " ");

            if (arrayTen[i] < min) {
                min = arrayTen[i];
            }
            if (arrayTen[i] > max) {
                max = arrayTen[i];
            }
        }
        System.out.println("\nmin = " + min);
        System.out.println("max = " + max);

//* Вариант 2. Можно выбрать любой другой тип сортировки или использовать встроенный
        bubbleSort(arrayTen); // можно и так:
        // Arrays.sort(arrayTen);

        System.out.println("\nMAX =  " + arrayTen[arrayTen.length - 1]);
        System.out.println("MIN = " + arrayTen[0]);

//**
        int[] my = {5, 15, 10, 5, 5, 10, 10, 2};
        if (findingEqualSum(my) == true)
            System.out.println("\nБаланс найден");
        else
            System.out.println("\nБаланс не найден");

//***
        System.out.println("\nСмещение массивов:");
        int[] myTwo = {1, 2, 3, 4, 5, 6, 7, 8};
        shiftArray(myTwo, 2);

    }

    static int[] filledArrayTen(int len, int initialValue) {                      //10
        int[] arrayTen = new int[len];
        for (int s : arrayTen) {
            arrayTen[s] = initialValue;
        }
        return arrayTen;
    }

    static int numberForFill(int ranges, int min) {
        return (int) (Math.random() * ranges - min);
    }

    public static void bubbleSort(int[] array) {              //* использую этот, т.к самый простой в реализации
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int swap = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = swap;
                }
            }
        }
    }

    static boolean findingEqualSum(int[] array) {             //**
        int allSum = 0;
        int currentRightSum = 0;
        for (int i = 0; i < array.length; i++) {
            allSum += array[i];
        }
        for (int i = 0; i < array.length; i++) {
            currentRightSum += array[i];
            if ((allSum - currentRightSum) == currentRightSum) {
                return true;
            }
        }
        return false;
    }

    /*Написать метод, которому на вход подается одномерный массив и число n
    (может быть положительным, или отрицательным),
    при этом метод должен сместить все элементы массива на n позиций.
    Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
    Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1]
    при n = -2 (на два влево) -> [ 6, 1, 3, 5 ]. При каком n в какую сторону сдвиг можете выбирать сами.
     */
    static void shiftArray(int[] array, int n) {                  //***
        int a = 1;
        if (n >= 0) {                             // при n смещаю вправо
            while (a <= n) {
                for (int i = array.length; i > 0; i--) {
                    for (int j = 0; j < a; j++) {
                        int swap = array[array.length - 1];
                        array[array.length - 1] = array[array.length - i];
                        array[array.length - i] = swap;
                        j++;
                    }
                }
                a++;
            }
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + " ");
            }
        } else {                                   // при -n смещаю влево
            while (a <= -n) {
                for (int i = array.length - 1; i > 0; i--) {
                    for (int j = 0; j < a; j++) {
                        int swap = array[j];
                        array[j] = array[i - j];
                        array[i - j] = swap;
                        j++;
                    }
                }
                a++;
            }
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + " ");
            }
        }
    }
}
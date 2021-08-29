package shcool.lesson5;

import java.util.Arrays;

class Elements<T> {
    private T arrElement;

    public Elements(T arrElement) {
        this.arrElement = arrElement;
    }

    public static <T> void swapElements(T[] array, int indexOne, int indexTwo) {
        T swap = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = swap;
    }
}

public class TaskOne {
    public static void main(String[] args) {

        String[] arrayOne = {"fjgksh", "32564", "porefjed", "35485", "@hghv"};
        Integer[] arrayTwo = {1, 2, 3, 4, 5, 6};
        Double[] arrayThree = {1.325, 5.364, 2.0, 8931.000, 45768.23};

        Elements.swapElements(arrayOne, 1, 4);
        System.out.println(" Array after swap: " + Arrays.toString(arrayOne));
        Elements.swapElements(arrayTwo, 1, 4);
        System.out.println(" Array after swap: " + Arrays.toString(arrayTwo));
        Elements.swapElements(arrayThree, 2, 0);
        System.out.println(" Array after swap: " + Arrays.toString(arrayThree));
    }
}

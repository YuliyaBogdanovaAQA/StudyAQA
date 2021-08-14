package shcool.lesson6;

class MyArraySizeException extends Exception {
    public MyArraySizeException(int sizeArray) {
        super("The size of array not: " + sizeArray);
    }
}

class MyArrayDataException extends Exception {
    public MyArrayDataException(int row, int column) {
        super("Incorrect data in point number: " + row + "/" + column);
    }
}

public class HomeWorkSix {
    public static void main(String[] args) {
        String[][] myArray = new String[4][7];
        String[][] myArray2 = new String[4][4];

        try {
            TaskTwo(myArray,4,7);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }

        String[][] forCheck = {{"1", "1", "1", "1"},
                {"1", "1", "kdngkj", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "jhv"}};

        try {
            TaskTwo(forCheck, 4, 4);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }
    }

    public static void TaskTwo(String[][] array, int sizeOfRow, int sizeOfColumn) throws MyArraySizeException, MyArrayDataException {
        int sumElements = 0;
        if (array.length != sizeOfRow) {
            throw new MyArraySizeException(sizeOfRow);
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != sizeOfColumn) {
                throw new MyArraySizeException(sizeOfColumn);
            }
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sumElements += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        System.out.println("sum = " + sumElements);
    }
}
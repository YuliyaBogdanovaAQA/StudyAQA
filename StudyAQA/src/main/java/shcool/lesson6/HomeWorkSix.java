package shcool.lesson6;

class MyArrayException extends Exception {
    public MyArrayException(String message) {
        super(message);
    }
}

class MyArraySizeException extends MyArrayException {
    public MyArraySizeException(int i, int j) {
        super("The size of array not 4x4. Size of the checked array is " + i + "x" + j);
    }
}

class MyArrayDataException extends MyArrayException {
    public MyArrayDataException(String message) {
        super(message);
    }
}

public class HomeWorkSix {
    public static void main(String[] args) {
        String[][] myArray = new String[6][4];
        try {
            TaskTwo(myArray);
        } catch (MyArrayException e) {
            e.printStackTrace();
        }

        String[][] myArray2 = new String[4][5];
        try {
            TaskTwo(myArray2);
        } catch (MyArrayException e) {
            e.printStackTrace();
        }

        String[][] forCheck = {{"1", "1", "1", "1"},
                {"1", "1", "kdngkj", "1"},
                {"1", "jgyu", "1", "1"},
                {"1", "1", "1", "jhv"}};

        try {
            TaskTwo(forCheck);
        } catch (MyArrayException e) {
            e.printStackTrace();
        }
    }

    static void TaskTwo(String[][] array) throws MyArrayException {
        int sumElements = 0;
        for (int i = 0; i < array.length; i++) {
            if (4 != array.length | 4 != array[i].length) throw new MyArraySizeException(array.length, array[i].length);
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sumElements += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    Throwable x = new MyArrayDataException("Incorrect data in point with index: " +
                            i + "/" + j + " " + e.getMessage());
                    x.printStackTrace();
                }
            }
        }
        System.out.println("sum = " + sumElements);
    }
}
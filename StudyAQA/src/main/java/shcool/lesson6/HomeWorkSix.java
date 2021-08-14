package shcool.lesson6;

class MyArraySizeException extends Exception {
    public MyArraySizeException() {
        super("The size of array not 4");
    }
}

class MyArrayDataException extends Exception {
    public MyArrayDataException(String message) {
        super(message);
    }
}

public class HomeWorkSix {
    public static void main(String[] args) {
        String[][] myArray = new String[4][4];
        String[][] myArray2 = new String[4][4];

        String[][] forCheck = {{"1", "1", "1", "1"},
                {"1", "1", "kdngkj", "1"},
                {"1", "jgyu", "1", "1"},
                {"1", "1", "1", "jhv"}};

        try {
            TaskTwo(forCheck);
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
    }

    public static void TaskTwo(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int sumElements = 0;
        if (array.length != 4) {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sumElements += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    Throwable x = new MyArrayDataException("Incorrect data in point with index: " +
                            i +"/" + j + " " + e.getMessage());
                    x.printStackTrace();
                }
            }
        }
        System.out.println("sum = " + sumElements);
    }
}
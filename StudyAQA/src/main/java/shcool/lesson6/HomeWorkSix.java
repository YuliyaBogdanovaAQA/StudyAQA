package shcool.lesson6;

class MyArraySizeException extends Exception {
    public MyArraySizeException(String message) {
        super(message);
    }
}

class MyArrayDataException extends Exception {
    public MyArrayDataException(String message) {
        super(message);
    }
}

public class HomeWorkSix {
    public static void main(String[] args) {
        String[][] myArray = new String[4][7];
        String[][] myArray2 = new String[4][4];

      /*  try {
            TaskTwo(myArray,4,7);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }*/

        String[][] forCheck = {{"1", "1", "1", "1"},
                {"1", "1", "kdngkj", "1"},
                {"jgjb", "1", "1", "1"},
                {"1", "1", "1", "jhv"}
                };

        try {
            TaskTwo(forCheck, 4, 3);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }
    }

    public static void TaskTwo(String[][] array, int sizeOfRow, int sizeOfColumn) throws MyArraySizeException, MyArrayDataException {
        int sumElements = 0;
        if (array.length != sizeOfRow) {
            throw new MyArraySizeException("The number of rows not: " +sizeOfRow);
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != sizeOfColumn) {
                throw new MyArraySizeException("The number of columns not: "+ sizeOfColumn);
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
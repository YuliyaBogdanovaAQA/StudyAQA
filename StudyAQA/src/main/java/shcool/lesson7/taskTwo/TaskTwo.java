package shcool.lesson7.taskTwo;

import au.com.bytecode.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("ALL")
public class TaskTwo {

    private static final String FILE_SEPARATOR = ";";

    public static void main(String[] args) {

        try {
            CSVReader reader = new CSVReader(new FileReader("taskTwo.csv"), ';', '"', 0);
            List<String[]> allRows = reader.readAll();
            reader.close();
            for (String[] row : allRows) {
                System.out.println(Arrays.toString(row));
            }
            AppData arrHeader = new AppData(allRows.get(0));
            System.out.println(Arrays.toString(arrHeader.getHeader()));

            int[][] arrInt = new int[allRows.size()][arrHeader.getHeader().length];
            AppData arrDataInt = new AppData(arrInt);
            for (int k = 1; k < allRows.size(); k++) {
                for (int j = 0; j < arrHeader.getHeader().length; j++) {
                    try {
                        arrInt[k][j] = Integer.parseInt(allRows.get(k)[j]);
                    } catch (NumberFormatException e) {
                        Throwable x = new MyArrayDataException("Incorrect data in point with index: " +
                                k + "/" + j + " " + e.getMessage());
                        x.printStackTrace();
                    }
                }
            }
            System.out.println("arrDataInt");
            for (int k = 1; k < allRows.size(); k++) {
                for (int j = 0; j < arrHeader.getHeader().length; j++) {
                    System.out.print(arrDataInt.getData()[k][j]);
                }
                System.out.println();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
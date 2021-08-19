package shcool.lesson7.taskTwo;

import au.com.bytecode.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("ALL")
public class TaskTwo {

    private static final char FILE_SEPARATOR = ';';
    private String nameFile;

    private static void printReader(List<String[]> list) {
        System.out.println("Read file CSV:");
        for (String[] s : list) {
            System.out.println(Arrays.toString(s));
        }
    }

    private static void CSVtoArrays(String nameFile) {
        try {
            CSVReader reader = new CSVReader(new FileReader(nameFile), FILE_SEPARATOR, '"', 0);
            List<String[]> allRows = reader.readAll();
            reader.close();
            printReader(allRows);                                                                  // only for control !!!
            AppData arrHeader = new AppData(allRows.get(0));
            System.out.println("Headers array:\n" + Arrays.toString(arrHeader.getHeader()));       // only for control !!!
            int[][] arrInt = new int[allRows.size()][arrHeader.getHeader().length];
            AppData arrDataInt = new AppData(arrInt);
            for (int i = 1; i < allRows.size(); i++) {
                for (int j = 0; j < allRows.get(i).length; j++) {
                    try {
                        arrInt[i][j] = Integer.parseInt(allRows.get(i)[j]);
                    } catch (NumberFormatException e) {
                        Throwable x = new MyArrayDataException("Incorrect data in point with index: " +
                                i + "/" + j + " " + e.getMessage());
                        x.printStackTrace();
                    }
                }
            }
            System.out.print("\nDatas array:\n");                                      //only for control
            for (int i = 1; i < allRows.size(); i++) {
                for (int j = 0; j < allRows.get(i).length; j++) {
                    System.out.print(arrDataInt.getData()[i][j]);
                }
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CSVtoArrays("taskTwo.csv");
    }
}
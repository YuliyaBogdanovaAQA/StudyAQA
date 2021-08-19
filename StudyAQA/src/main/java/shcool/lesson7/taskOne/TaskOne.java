package shcool.lesson7.taskOne;

import java.io.*;
import java.util.ArrayList;

public class TaskOne {

    private static final char FILE_SEPARATOR = ';';

    private static void writeToCSV(ArrayList<Pets> petsList) {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("pets.csv"), "UTF-8"));
            for (Pets pet : petsList) {
                StringBuffer stBuf = new StringBuffer();
                stBuf.append(pet.getType());
                stBuf.append(FILE_SEPARATOR);
                stBuf.append(pet.getName());
                stBuf.append(FILE_SEPARATOR);
                stBuf.append(pet.getAge() == 0 ? "not defined" : pet.getAge());
                stBuf.append(FILE_SEPARATOR);
                stBuf.append(pet.getAddress());
                stBuf.append(FILE_SEPARATOR);
                for (int i = 0; i < pet.getVisitVet().length; i++) {          // How i can check miss data???
                    stBuf.append(pet.getVisitVet()[i]);
                    stBuf.append(FILE_SEPARATOR);
                }
                bw.write(stBuf.toString());
                bw.newLine();
            }
            bw.flush();
            bw.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        ArrayList<Pets> petsList = new ArrayList<Pets>();
        petsList.add(new Pets("dog", "Sharik", 5, "Smolenskaya str.,4/6, 25", new String[]{"25/06/2020", "15/08/2021"}));
        petsList.add(new Pets("cat", "Pushok", 3, "Smolenskaya str.,4/2, 37", new String[]{"17/06/2020", "21/08/2021"}));
        petsList.add(new Pets("hamster", "Orange", "Smolenskaya str.,1/6, 47", new String[]{"25/09/2020", "15/08/2021"}));
        petsList.add(new Pets("parrot", "Shustrik", 0, "Smolenskaya str.,4/6, 25", new String[]{"25/06/2020", "15/08/2021", "27/08/2021"}));
        writeToCSV(petsList);
    }
}
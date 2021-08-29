//Принимаю, что HOME является дубликатом home и проверяю уникальность значений, без учета регистра символов.

package shcool.lesson8;

import java.util.*;

public class TaskOne {

    public static void main(String[] args) {
        String[] myWords = {"String", "Home", "Cafe", "News", "Cat",
                "STRING", "HOME", "CAFE", "NEWS", "CAT",
                "string", "home", "cafe", "news", "car"};
        counterReplica(myWords);
        uniqueWords(myWords);
    }

    public static void counterReplica(String[] myArray) {
        Map<String, Integer> words = new HashMap<String, Integer>();
        for (String str : myArray) {
            words.put(str.toLowerCase(Locale.ROOT), words.get(str.toLowerCase(Locale.ROOT)) == null ? 1 : (words.get(str.toLowerCase(Locale.ROOT)) + 1));
        }
        System.out.println(words);
    }

    public static void uniqueWords(String[] myArray) {
        Set<String> unique = new HashSet<>();
        for (int i = 0; i < myArray.length; i++) {
            unique.add(myArray[i].toLowerCase(Locale.ROOT));
        }
        for (String str : unique) {
            System.out.println(str);
        }
    }
}
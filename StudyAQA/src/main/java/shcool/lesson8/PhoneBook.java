package shcool.lesson8;

import java.util.*;

public class PhoneBook {
    private HashMap<String, List<String>> myPhoneBook;

    public PhoneBook() {
        this.myPhoneBook = new HashMap<String, List<String>>();
    }

    public void printInfo() {
        for (Map.Entry entry : this.myPhoneBook.entrySet()) {
            System.out.println("Name: " + entry.getKey() + "\nphones:\n"
                    + entry.getValue());
        }
    }

    public void add(String name, String phone) {
        List<String> phoneNumber = new ArrayList<String>();
        if (this.myPhoneBook.containsKey(name)) {
            if (this.myPhoneBook.get(name).toString().contains(phone)) {
                System.out.println("Person with name : " + name + " and phones: "
                        + phone + " had already exist");
            } else {
                phoneNumber = this.myPhoneBook.get(name);
                phoneNumber.add(phone);
                this.myPhoneBook.put(name, phoneNumber);
            }
        } else {
            phoneNumber.add(phone);
            this.myPhoneBook.put(name, phoneNumber);
        }
    }

    public void get(String name) {
        if (this.myPhoneBook.containsKey(name)) {
            System.out.println("Name: " + name + "\nphones:\t" + this.myPhoneBook.get(name).toString()
                    .replace('[', ' ').replace(']', ' '));
        } else
            System.out.println("The person with name " + name + " isn't in this phone book");
    }

    public static void main(String[] args) {
        PhoneBook myPhoneBook = new PhoneBook();

        myPhoneBook.add("Ivanov", "+375293256542");
        myPhoneBook.add("Alekseeva", "+375293255842");
        myPhoneBook.add("Sergantov", "+375297896542");
        myPhoneBook.add("Egorov", "+375293254142");
        myPhoneBook.add("Andreeva", "+375293256982");
        myPhoneBook.add("Ivanov", "+375293256542");         //replica for check
        myPhoneBook.add("Ivanov", "+375293256533");
        myPhoneBook.add("Ivanov", "+375293256533");         //replica for check
        myPhoneBook.get("Ivanov");
        myPhoneBook.get("Sidorov");
        myPhoneBook.get("Sergantov");

        //myPhoneBook.printInfo();                                      //only for control
    }
}
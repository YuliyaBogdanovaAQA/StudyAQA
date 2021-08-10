package school.lesson4;

import java.util.ArrayList;
import java.util.List;

class Payment {
    public Expenses expenses;
    private int currentMoney = 0;

    public Payment(int currentMoney) {
        this.currentMoney = currentMoney;
    }

    public int getCurrentMoney() {
        return currentMoney;
    }

    public class Expenses {
        String nameExpenses;
        int prise;

        public Expenses(String nameExpenses, int prise) {
            this.nameExpenses = nameExpenses;
            this.prise = prise;
        }

        public String getNameExpenses() {
            return nameExpenses;
        }

        public int getPrise() {
            return prise;
        }

        public void setNameExpenses(String nameExpenses) {
            this.nameExpenses = nameExpenses;
        }

        public void setPrise(int prise) {
            this.prise = prise;
        }

        public void print() {
            System.out.println("Name of expense: " + getNameExpenses() + "\tprice: " + getPrise());
        }
    }
}
public class TaskSix {
    public static void main(String[] args) {
        List<Payment.Expenses> purchases = new ArrayList<Payment.Expenses>();
        purchases.add(new Payment(300).new Expenses("Phone", 120));
        purchases.add(new Payment(300).new Expenses("Champoo", 15));

        for (Payment.Expenses list : purchases) {
            list.print();
            System.out.println();
        }
    }
}

package school.lesson4;

import java.util.ArrayList;
import java.util.List;

class Park {
    public Info info;
    public String namePark;

    public Park(String namePark) {
        this.namePark = namePark;
    }

    public void setNamePark(String namePark) {
        this.namePark = namePark;
    }

    public String getNamePark() {
        return namePark;
    }

    public class Info {
        String nameAttraction, prise, workTime;

        public Info(String nameAttraction, String prise, String workTime) {
            this.nameAttraction = nameAttraction;
            this.prise = prise;
            this.workTime = workTime;
        }

        public String getNameAttraction() {
            return nameAttraction;
        }

        public void setNameAttraction(String nameAttraction) {
            this.nameAttraction = nameAttraction;
        }

        public String getPrice() {
            return prise;
        }

        public void setPrise(String prise) {
            this.prise = prise;
        }

        public String getWorkTime() {
            return workTime;
        }

        public void setWorkTime(String workTime) {
            this.workTime = workTime;
        }

        public void print() {
            System.out.print("Name of park: " + getNamePark() + "\nattraction: " + getNameAttraction() + "\tprice: " +
                    getPrice() + "\tworking hours: " + getWorkTime());
        }
    }
}

public class TaskSeven {
    static public void main(String[] args) {
        List<Park.Info> info = new ArrayList<Park.Info>();
        info.add(new Park("Mazurino").new Info("Ferris wheel", "12", "10:00-19:00"));
        info.add(new Park("Mazurino").new Info("Chamber of horrors", "15", "11:00-18:00"));

        for (Park.Info list : info) {
            list.print();
            System.out.println();
        }
    }
}

package school.lesson3;

import javax.naming.Name;

public class HomeWorkThree {

    public static class Empoloyee {
        private String name;
        private String position;
        private String email;
        private String phone;
        private int salary;
        private int age;

        public Empoloyee(String FIO, String position, String email, String phone, int salary, int age) {
            this.name = FIO;
            this.position = position;
            this.email = email;
            this.phone = phone;
            this.salary = salary;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public String getPosition() {
            return position;
        }

        public String getEmail() {
            return email;
        }

        public String getPhone() {
            return phone;
        }

        public int getSalary() {
            return salary;
        }

        public int getAge() {
            return age;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public void setSalary(int salary) {
            this.salary = salary;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void printInfo() {
            System.out.println(String.format("Full name: %s \nPosition: %s \nEmail: %s \nPhone: %s \nSalary: %d \nAge: %d \n",
                    name, position, email, phone, salary, age));
        }
    }

    public static void main(String[] args) {
        Empoloyee[] empoloyees = new Empoloyee[5];
        empoloyees[0] = new Empoloyee("Barikin Igor Andreevich", "manager", "BarikinIA@mail.ru",
                "235-78-91", 700, 41);
        empoloyees[1] = new Empoloyee("Cergantov Andrey Sergeevich", "bookkeeper", "CergantovAS@mail.ru",
                "235-77-32", 520, 54);
        empoloyees[2] = new Empoloyee("Fedorov Oleg Aleksandrovich", "engineer", "FedorovOA@mail.ru",
                "235-65-74", 410, 23);
        empoloyees[3] = new Empoloyee("Alekseeva Anna Evgenievna", "worker", "AlekseevaAE@mail.ru",
                "231-67-85", 310, 34);
        empoloyees[4] = new Empoloyee("Kulikina Alina Eduardovna", "director", "KulikinaAE@mail.ru",
                "235-35-85", 1200, 51);

        for (int i = 0; i < empoloyees.length; i++) {
            if (empoloyees[i].age > 40) {
                empoloyees[i].printInfo();
            }
        }
    }
}
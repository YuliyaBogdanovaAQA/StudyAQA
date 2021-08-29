package shcool.lesson7.taskOne;

public class Pets {
    private String type;
    private String name;
    private int age;
    private String address;
    private String[] visitVet;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String[] getVisitVet() {
        return visitVet;
    }

    public void setVisitVet(String[] visitVet) {
        this.visitVet = visitVet;
    }

    public Pets(String type, String name, int age, String address, String[] visitVet) {

        this.type = type;
        this.name = name;
        this.age = age;
        this.address = address;
        this.visitVet = visitVet;
    }

    public Pets(String type, String name, String address, String[] visitVet) {
        this.type = type;
        this.name = name;
        this.address = address;
        this.visitVet = visitVet;
    }
}
package model;

public class Student extends Person {

    private String id;
    private int age;

    private static int totalStudents = 0;

    public Student(String name, int age, String id) {
        super(name);
        this.age = age;
        this.id = id;
        totalStudents++;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static int getTotalStudents(){
        return  totalStudents;
    }
}

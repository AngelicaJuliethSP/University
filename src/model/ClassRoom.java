package model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ClassRoom {

    private String name;
    private String classroom;
    private Teacher teacher;
    private List<Student> students;

    public ClassRoom(String name, String classroom, Teacher teacher, List<Student> students) {
        this.name = name;
        this.classroom = classroom;
        this.teacher = teacher;
        this.students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent (Student student){
        students.add(student);
    }
}

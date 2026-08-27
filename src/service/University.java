package service;

import model.ClassRoom;
import model.Student;
import model.Teacher;

import java.util.ArrayList;
import java.util.List;

public class University {

    private List<Teacher> teachers;
    private List <Student> students;
    private List<ClassRoom> classes;

    public University() {
        this.teachers = new ArrayList<>();
        this.students = new ArrayList<>();
        this.classes = new ArrayList<>();
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<ClassRoom> getClasses() {
        return classes;
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addClass(ClassRoom classRoom) {
        classes.add(classRoom);
    }

    public boolean addStudentToClass(Student student, ClassRoom classRoom) {
        if (!students.contains(student)) {
            students.add(student);
        }
        classRoom.addStudent(student);
        return true;
    }

    public List<ClassRoom> findClassesByStudentId(String studentId) {
        List<ClassRoom> result = new ArrayList<>();
        for (ClassRoom c : classes) {
            for (Student s : c.getStudents()) {
                if (s.getId().equals(studentId)) {
                    result.add(c);
                    break;
                }
            }
        }
        return result;
    }

    public ClassRoom findClassByName(String name) {
        for (ClassRoom c : classes) {
            if (c.getName().equalsIgnoreCase(name)) {
                return c;
            }
        }
        return null;
    }
}

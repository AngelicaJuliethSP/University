package io;

import model.ClassRoom;
import model.Student;
import model.Teacher;

import java.util.List;

public class ConsolePrinter {

    public void printAllTeachers(List<Teacher> teachers) {
        System.out.println("\n--- TEACHERS LIST ---");
        for (Teacher t : teachers) {
            System.out.println("Name: " + t.getName()
                    + " | Base Salary: " + t.getBaseSalary()
                    + " | Calculated Salary: " + t.calculateSalary()
                    + " | Type: " + t.getClass().getSimpleName());
        }
    }

    public void printAllClasses(List<ClassRoom> classes) {
        System.out.println("\n--- CLASSES LIST ---");
        for (ClassRoom c : classes) {
            System.out.println("- " + c.getName() + " (Room: " + c.getClassroom() + ")");
        }
    }

    public void printClassDetail(ClassRoom c) {
        System.out.println("\n--- CLASS DETAIL: " + c.getName() + " ---");
        System.out.println("Classroom: " + c.getClassroom());
        Teacher t = c.getTeacher();
        System.out.println("Teacher: " + t.getName() + " (" + t.getClass().getSimpleName() + ")");
        System.out.println("Students:");
        for (Student s : c.getStudents()) {
            System.out.println("  - " + s.getName() + " | ID: " + s.getId() + " | Age: " + s.getAge());
        }
    }

    public void printStudentClasses(List<ClassRoom> foundClasses, String studentId) {
        if (foundClasses.isEmpty()) {
            System.out.println("No classes found for student with ID: " + studentId);
            return;
        }
        System.out.println("\n--- CLASSES FOR STUDENT ID " + studentId + " ---");
        for (ClassRoom c : foundClasses) {
            System.out.println("- " + c.getName());
        }
    }

    public void printMenu() {
        System.out.println("\n===== UNIVERSITY MENU =====");
        System.out.println("a. Print all teachers");
        System.out.println("b. Print all classes (select one for detail)");
        System.out.println("c. Create a new student and add to a class");
        System.out.println("d. Create a new class");
        System.out.println("e. List classes of a student by ID");
        System.out.println("f. Exit");
        System.out.print("Select an option: ");
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}

package app;

import model.*;
import service.University;
import io.ConsolePrinter;
import io.ConsoleReader;

import java.util.List;

public class Main {

    private static University university = new University();
    private static ConsolePrinter printer = new ConsolePrinter();
    private static ConsoleReader reader = new ConsoleReader();

    public static void main(String[] args) {
        initializeData();
        runMenu();
    }

    private static void initializeData() {
        // 2 full time teachers
        FullTimeTeacher t1 = new FullTimeTeacher("Carlos Ramirez", 2000000, 5);
        FullTimeTeacher t2 = new FullTimeTeacher("Ana Torres", 2200000, 8);

        // 2 part time teachers
        PartTimeTeacher t3 = new PartTimeTeacher("Laura Gomez", 50000, 10);
        PartTimeTeacher t4 = new PartTimeTeacher("Pedro Diaz", 45000, 12);

        university.addTeacher(t1);
        university.addTeacher(t2);
        university.addTeacher(t3);
        university.addTeacher(t4);

        Student s1 = new Student("Juan Perez", "001", 20);
        Student s2 = new Student("Maria Lopez", "002", 21);
        Student s3 = new Student("Andres Ruiz", "003", 19);
        Student s4 = new Student("Sofia Castro", "004", 22);
        Student s5 = new Student("Diego Mora", "005", 20);
        Student s6 = new Student("Valentina Rios", "006", 23);

        university.addStudent(s1);
        university.addStudent(s2);
        university.addStudent(s3);
        university.addStudent(s4);
        university.addStudent(s5);
        university.addStudent(s6);

        ClassRoom c1 = new ClassRoom("Java Basics", "Room 301", t1);
        c1.addStudent(s1);
        c1.addStudent(s2);

        ClassRoom c2 = new ClassRoom("Databases", "Room 302", t2);
        c2.addStudent(s2);
        c2.addStudent(s3);

        ClassRoom c3 = new ClassRoom("Web Development", "Room 303", t3);
        c3.addStudent(s4);
        c3.addStudent(s5);

        ClassRoom c4 = new ClassRoom("Software Architecture", "Room 304", t4);
        c4.addStudent(s5);
        c4.addStudent(s6);

        university.addClass(c1);
        university.addClass(c2);
        university.addClass(c3);
        university.addClass(c4);
    }
    private static void runMenu() {
        boolean running = true;

        while (running) {
            printer.printMenu();
            String option = reader.readLine("").trim().toLowerCase();

            switch (option) {
                case "a":
                    optionPrintTeachers();
                    break;
                case "b":
                    optionPrintClasses();
                    break;
                case "c":
                    optionCreateStudent();
                    break;
                case "d":
                    optionCreateClass();
                    break;
                case "e":
                    optionFindClassesByStudent();
                    break;
                case "f":
                    running = false;
                    printer.printMessage("Goodbye!");
                    break;
                default:
                    printer.printMessage("Invalid option. Try again.");
            }
        }
    }

    private static void optionPrintTeachers() {
        printer.printAllTeachers(university.getTeachers());
    }

    private static void optionPrintClasses() {
        printer.printAllClasses(university.getClasses());

        String className = reader.readLine("\nEnter class name to see details (or press Enter to skip): ");

        if (!className.isBlank()) {
            ClassRoom found = university.findClassByName(className);
            if (found != null) {
                printer.printClassDetail(found);
            } else {
                printer.printMessage("Class not found.");
            }
        }
    }

    private static void optionCreateStudent() {
        String name = reader.readLine("Student name: ");
        String id = reader.readLine("Student ID: ");
        int age = reader.readInt("Student age: ");

        Student newStudent = new Student(name, id, age);

        String className = reader.readLine("Enter the class name to add this student to: ");
        ClassRoom targetClass = university.findClassByName(className);

        if (targetClass == null) {
            printer.printMessage("Class not found. Student was not added to any class.");
            return;
        }

        university.addStudentToClass(newStudent, targetClass);
        printer.printMessage("Student added successfully to " + targetClass.getName());
    }

    private static void optionCreateClass() {
        String name = reader.readLine("Class name: ");
        String classroom = reader.readLine("Classroom (e.g. Room 305): ");

        printer.printAllTeachers(university.getTeachers());
        String teacherName = reader.readLine("Enter the name of the teacher for this class: ");

        Teacher selectedTeacher = null;
        for (Teacher t : university.getTeachers()) {
            if (t.getName().equalsIgnoreCase(teacherName)) {
                selectedTeacher = t;
                break;
            }
        }

        if (selectedTeacher == null) {
            printer.printMessage("Teacher not found. Class was not created.");
            return;
        }

        ClassRoom newClass = new ClassRoom(name, classroom, selectedTeacher);
        university.addClass(newClass);
        printer.printMessage("Class '" + name + "' created successfully.");
    }

    private static void optionFindClassesByStudent() {
        String id = reader.readLine("Enter student ID: ");
        List<ClassRoom> found = university.findClassesByStudentId(id);
        printer.printStudentClasses(found, id);
    }

    }
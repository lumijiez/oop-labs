package org.lumijiez;

import org.lumijiez.base.Grade;
import org.lumijiez.base.NameSurnameGroup;
import org.lumijiez.data.DataDeserializer;
import org.lumijiez.data.DataSerializer;
import org.lumijiez.managers.Manager;

import java.util.Scanner;

public class Main {
    public static NameSurnameGroup readNSG() {
        String name = sc.nextLine();
        String surname = sc.nextLine();
        String group = sc.nextLine();
        return new NameSurnameGroup(name, surname, group);
    }
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Manager studentManager = DataDeserializer.deserialize();

        boolean exit = false;
        while (!exit) {
            System.out.println("===== Student Management System =====");
            System.out.println("1. Show Students");
            System.out.println("2. Show Groups");
            System.out.println("3. Show Grades of a Student");
            System.out.println("4. Add Grade to Student");
            System.out.println("5. Add Student");
            System.out.println("6. Remove student");
            System.out.println("7. Exit and save");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> studentManager.printStudents();
                case 2 -> studentManager.printGroups();
                case 3 -> studentManager.printGrades(readNSG());
                case 4 -> studentManager.addGrade(readNSG(), new Grade(sc.nextLine(), sc.nextInt()));
                case 5 -> studentManager.addStudent(readNSG());
                case 6 -> studentManager.removeStudent(readNSG());
                case 7 -> {
                    DataSerializer.serialize(studentManager);
                    exit = true;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }

            if (!exit) {
                System.out.println("Press Enter to continue...");
                sc.nextLine();
            }
        }

        System.out.println("Goodbye!");
    }
}
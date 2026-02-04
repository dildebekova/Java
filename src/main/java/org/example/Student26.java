package org.example;

import java.util.Scanner;

public class Student26 {
    private String name;
    private int age;
    private String major;
    private double gpa;

    public Student26(String name, int age, String major, double gpa) {
        this.name = name;
        this.age = age;
        this.major = major;
        setGpa(0.0);
    }

    public Student26(String name, int age, double gpa) {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }

    public Student26(String name) {
        this.name = name;
    }

    public Student26(String name, String major) {
        this.name = name;
        this.major = major;
    }

    public Student26(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        if (gpa < 0.0 || gpa > 4.0) {
            System.out.println("GPA must be between 0.0 and 4.0");
        } else {
            this.gpa = gpa;
        }
    }
    void displayInfo(){
        System.out.println("Студент: " + getName());
        System.out.println("Возраст: " + getAge() + " лет");
        System.out.println("Средний балл (GPA): " + getGpa());
        System.out.println("Профессия : "+ major);
    }

    public boolean isExcellent() {
        return gpa >= 3.5;
    }

}

class StudentUtils {
    Student26[] list;
    int freeIndex=0;

    public StudentUtils(int n) {
        list= new Student26[n];
    }

    public void addStudent(Student26 s){
        if (freeIndex==list.length){
            System.out.println("Мест нет");
            return;
        }
        list[freeIndex]=s;
        freeIndex++;

    }

    void printStudents() {
        if (freeIndex == 0) {
            System.out.println("Список студентов пуст.");
            return;
        }

        System.out.println("\n========== ВСЕ СТУДЕНТЫ ==========");
        for (int i = 0; i < freeIndex; i++) {
            System.out.println("Студент #" + (i + 1) + ":");
            list[i].displayInfo();
            System.out.println("----------------------------------");
        }
    }

    void printStudentsGPA(double minGpa) {
        if (freeIndex == 0) {
            System.out.println("Список студентов пуст.");
            return;
        }

        System.out.println("\nСтуденты с GPA ≥ " + minGpa + ":");
        for (int i = 0; i < freeIndex; i++) {
            if (list[i].getGpa() >= minGpa) {
                list[i].displayInfo();
                System.out.println("---------------------");
            }
        }
    }

    double calculateAverageGPA(){
        if (freeIndex==0){
            return 0.0;
        }
        double sum=0.0;
        for(int i=0; i <freeIndex; i++){
            sum+=list[i].getGpa();
        }
        return sum/freeIndex;
    }

    Student26 findStudentByName(String name){
        if(name==null || freeIndex==0){
            return null;
        }
        for (int i=0; i<freeIndex; i++){
            if (list[i].getName().equalsIgnoreCase(name)){
                return list[i];
            }
        }
        return null;
    }
}


class SMS {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("How many students do you want to enter? ");
        int n = scan.nextInt();
        scan.nextLine();

        StudentUtils utils = new StudentUtils(n);


        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter data for student #" + (i + 1));

            System.out.print("Name: ");
            String name = scan.nextLine();

            System.out.print("Age: ");
            int age = scan.nextInt();

            System.out.print("GPA: ");
            double gpa = scan.nextDouble();
            scan.nextLine();

            Student26 student = new Student26(name, age, gpa);
            utils.addStudent(student);
        }


        int choice;
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Display all students");
            System.out.println("2. Display excellent students (GPA ≥ 3.5)");
            System.out.println("3. Calculate average GPA");
            System.out.println("4. Search student by name");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 1:
                    utils.printStudents();
                    break;
                case 2:
                    utils.printStudentsGPA(3.5);
                    break;
                case 3:
                    System.out.println("Average GPA: " + utils.calculateAverageGPA());
                    break;
                case 4:
                    System.out.print("Enter student name: ");
                    String searchName = scan.nextLine();
                    Student26 found = utils.findStudentByName(searchName);
                    if (found != null) {
                        found.displayInfo();
                    } else {
                        System.out.println("Student not found");
                    }
                    break;
                case 5:
                    System.out.println("Goodbye 👋");
                    break;
                default:
                    System.out.println("Invalid option");
            }

        } while (choice != 5);

        scan.close();
    }
}

/**/
package org.example;

class Student {
    private String name;
    private int age;
    private double gpa;

    private static int studentCount=0;

//    public Student(String name, int age) {
//        this.name = name;
//        this.age = age;
//        this.gpa = 0.0;
//        studentCount++;
//
//    }
    public Student(String name, int age, double gpa) {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
        studentCount++;
    }
    void displayInfo(){
        System.out.println("Студент: " + name);
        System.out.println("Возраст: " + age + " лет");
        System.out.println("Средний балл (GPA): " + gpa);
        System.out.println("-".repeat(30));

    }
    public boolean isExcellent() {
        return gpa >= 3.5;
    }
    public static void displayStudentCount() {
        System.out.println("Общее количество созданных студентов: " + studentCount);
    }

    public String getName() {
        return name;
    }
}
class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Адилет", 20, 3.5);
        Student student2 = new Student("Алтын", 22, 4.7);
        Student student3 = new Student("Алина", 19, 3.2);
        Student student4 = new Student("Элай", 21, 3.8);

        System.out.println("ИНФОРМАЦИЯ О СТУДЕНТАХ:");
        System.out.println("=".repeat(30));
        student1.displayInfo();
        student2.displayInfo();
        student3.displayInfo();
        student4.displayInfo();

        System.out.println("ПРОВЕРКА УСПЕВАЕМОСТИ:");
        System.out.println("=".repeat(30));
        System.out.println(student1.getName() + " - отличник? " + student1.isExcellent());
        System.out.println(student2.getName() + " - отличник? " + student2.isExcellent());
        System.out.println(student3.getName() + " - отличник? " + student3.isExcellent());
        System.out.println(student4.getName() + " - отличник? " + student4.isExcellent());

        System.out.println();
        Student.displayStudentCount();
    }
}
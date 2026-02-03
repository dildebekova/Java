package org.example;

import java.util.Scanner;

class lab1 {
    String name;
    int age;
    double high;
    boolean isStudent;
    char firstChar;

    public lab1(double high, int age, boolean isStudent, char firstChar, String name) {
        this.high = high;
        this.age = age;
        this.isStudent = isStudent;
        this.firstChar = firstChar;
        this.name = name;
    }

    public static void main(String[] args) {
        lab1 s = new lab1(1.60, 19, true, 'N', "Nazima");
        System.out.println(s.name + " " + s.age + " " + s.high + " " + " " + s.isStudent + " " + s.firstChar);
        System.out.println(s);
    }
}
class As2 {
    int num = 7;
    double nm=7;

    public static void main(String[] args){
        As2 num=new As2();
        System.out.println(num.num+" : "+num.num/2);
        System.out.println(num.nm+" : "+num.nm/2);
        //При делении целых чисел (int) результат тоже является целым числом, поэтому дробная часть отбрасывается.
        //При использовании типа double деление выполняется с сохранением дробной части.
    }
}
class Calculator{
    int a;
    int b;
    public static void main(String[] args){
        Calculator c = new Calculator();
        c.a=100;
        c.b=5;
        System.out.println(c.a+c.b);
        System.out.println(c.a-c.b);
        System.out.println(c.a/c.b);
        System.out.println(c.a*c.b);
        System.out.println(c.a%c.b);
    }
}
class As3{
    int age;
    boolean hasStudentCard;

    public As3(int age, boolean hasStudentCard) {
        this.age = age;
        this.hasStudentCard = hasStudentCard;

    }

    public static void main(String[] args){
        As3 person=new As3(19, true);
        if( person.age<18 || person.hasStudentCard){
            System.out.println("Discount allowed");
        } else {
            System.out.println("No discount");
        }

    }
}
class As4{
    int grade;

    public As4(int grade) {
        this.grade = grade;
    }

    public static void main(String[] args){
        As4 g=new As4(79);

        if (g.grade >= 90 && g.grade <= 100) {
            System.out.println("A");
        } else if (g.grade >= 80 && g.grade <= 89) {
            System.out.println("B");
        } else if (g.grade >= 70 && g.grade <= 79) {
            System.out.println("C");
        } else if (g.grade >= 60 && g.grade <= 69) {
            System.out.println("D");
        } else if (g.grade >= 0 && g.grade < 60) {
            System.out.println("F");
        } else {
            System.out.println("Некорректная оценка");
        }
    }
}

class As5{
      int dayNumber;

    public As5(int dayNumber) {
        this.dayNumber = dayNumber;
    }

    public static void main(String[] args){
        As5 day = new As5(3);

        switch (day.dayNumber) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sanday");
                break;
            default:
                System.out.println("Wrong day");
        }
    }
}
class As6{
    public static void main(String[] args){
        for(int i=1;i<=10; i++ ){
            System.out.println(i+ " ");
        }
        System.out.println("\n");

        for (int i =1; i<=20; i++){
            if(i%2==0){
                System.out.println(i+" ");
            }
        }
        System.out.println("\n");
    }
}
class As7{
    public static void main(String[] args){
        int n=200;
        int sum=0;
        for (int i=1;i<=n ; i++){
            sum+=i;

        }
        System.out.println("Sum is " + n +" = "+sum);
    }
}

class As8{
    public static void main(String[] args){
        int n=9;
        int result=0;
        for(int i =1; i<=n;i++){
            for (int j =1; j<=n; j++){
                result=i*j;
                System.out.println(i+ " * "+j+" = "+result);
            }
        }
    }
}
class As9{
    public static void main(String[] args) {
     int num=17;
     boolean isPrime=true;

     if(num<=1){
         isPrime=false;
     } else if(num==2){
         isPrime=true;
     } else if(num%2==0){
         isPrime=false;
     } else{
         for(int i = 3; i*i<=num; i+=2){
             if (num%i==0){
                 isPrime=false;
                 break;
             }
         }
     }

     if(isPrime){
         System.out.println(num + " — простое число");
     } else{
         System.out.println(num + " — составное число");
     }
    }
}
class As10{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число для вычисления факториала: ");
        int n = scanner.nextInt();

        if (n<1){
            System.out.println("Ошибка: факториал определён только для неотрицательных чисел");
            scanner.close();
            return;
        }
        long fac=1;
        for(int i=2; i<=10; i++){
            fac*=i;

        }
        System.out.println(n + "! = " + fac);
        scanner.close();

    }
}


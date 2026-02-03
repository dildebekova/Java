package org.example;

class DordoiCorporation {

    public static void calculatePay(double basePay, int hours, int employeeNumber) {

        if (basePay < 8.0) {
            System.out.println("Employee " + employeeNumber +
                    ": Error: Base pay is below minimum wage");
            return;
        }

        if (hours > 60) {
            System.out.println("Employee " + employeeNumber +
                    ": Error: Hours worked exceed maximum allowed");
            return;
        }

        double totalPay;

        if (hours <= 40) {
            totalPay = hours * basePay;
        } else {
            int overtimeHours = hours - 40;
            totalPay = (40 * basePay) + (overtimeHours * basePay * 1.5);
        }

        System.out.printf("Employee %d: Total pay: $%.2f%n",
                employeeNumber, totalPay);
    }

    public static void main(String[] args) {
        calculatePay(7.50, 35, 1);
        calculatePay(8.20, 47, 2);
        calculatePay(10.00, 73, 3);
    }
}
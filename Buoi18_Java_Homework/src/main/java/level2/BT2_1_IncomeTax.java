package level2;

import java.util.Scanner;

public class BT2_1_IncomeTax {
    public static void main(String[] args) {
        System.out.println("Hãy nhập vào thu nhập hàng năm (đơn vị - triệu đồng): ");
        Scanner scanner = new Scanner(System.in);
        double income = scanner.nextDouble();

        double interest = calculateIncomeTax(income);

        String result = interest == 0 ? "Thu nhập không hợp lệ" : "Thuế suất phải trả là " + interest + " triệu đồng.";

        System.out.println(result);
    }

    static double calculateIncomeTax (double income) {
        double interestRate = 0;
        System.out.println(income);
        if (income < 0) return 0;
        else if (income >= 0) interestRate = 5;
        else if (income > 5) interestRate = 10;
        else if (income > 10) interestRate = 15;
        else if (income > 18) interestRate = 20;
        else if (income > 32) interestRate = 25;
        else if (income > 52) interestRate = 30;
        else if (income > 80) interestRate = 35;

        return income * (interestRate/100);
    }
}

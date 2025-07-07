package level1;

import java.util.Scanner;

public class BT1_3_TinhTongSoChan {
    public static void main(String[] args) {
        // Viết hàm tính tổng các số chẵn từ 0 đến một số nguyên dương n cho trước
        Scanner scanner = new Scanner(System.in);
        int n;
        do {
            System.out.println("Hãy nhập vào số nguyên dương n:");
            n = scanner.nextInt();
        } while (n<0);

        int sum = sumEvenArr(n);

        System.out.println("Tổng các số chẵn từ 0 đến " + n + " là " + sum);
    }

    public static int sumEvenArr (int n) {
        int sum = 0;

        for (int i = 0; i <= n; i += 2) {
            sum += i;
        }

        return sum;
    }
}

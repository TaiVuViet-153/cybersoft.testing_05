package level1;

import java.util.Scanner;

public class BT1_2_SecondMax {
    public static void main(String[] args) {
        // Tìm giá trị lớn thứ 2 trong mảng. Trả về giá trị đặc biệt nếu mảng có ít hơn 2 phần tử
        // Gọi hàm tạo mảng số nguyên
        int[] inputInteger = inputInteger();
        int secondMax = findSecondMax(inputInteger);

        System.out.println("Phần tử lớn hai trong mảng số nguyên là: " + secondMax);

    }

    public static int[] inputInteger() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hãy nhập số lượng phần tử mảng:");
        int n = scanner.nextInt();

        // Tạo mảng chứa các số nguyên
        int[] listNumber = new int[n];

        // Gán giá trị vào từng phần tử mảng
        for (int i = 0; i < listNumber.length; i++) {
            System.out.println("Số nguyên thứ " + (i+1));
            listNumber[i] = scanner.nextInt();
        }

        return listNumber;
    }

    public static int findSecondMax(int[] listNumber) {
        // Kiểm tra số phần tử mảng nhỏ hơn 2
        if (listNumber.length < 2) {
            return Integer.MIN_VALUE;
        }

        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        // Duyệt qua các phần tử mảng;
        for (int num: listNumber) {
            // Nếu phần tử mảng lớn hơn số Max thì gán Max cho secondMax và Max sẽ bằng phần tử mảng
            if (num > max) {
                secondMax = max;
                max = num;
            } else if (num > secondMax && num < max) {
                // phần tử mảng lớn hơn secondMax và nhỏ hơn Max thì cập nhật lại secondMax
                secondMax = num;
            }
        }

        return secondMax;
    }
}

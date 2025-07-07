package level1;

import java.util.Scanner;

public class BT1_4_DemTuTrongChuoi {
    public static void main(String[] args) {
        // Viết hàm đếm số ừ trong một chuỗi
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hãy nhập chuỗi: ");
        String inputString = scanner.nextLine();

        int result = countWords(inputString);

        System.out.println("Tổng số từ trong chuỗi là: " + result);
    }

    public static int countWords (String inputString) {
        String[] words = inputString.trim().split("\\s+");
        // trim(): để loại bỏ khoảng trắng đầu và cuối của chuỗi
        // split(): tách chuỗi thành các phần tử mảng có kiểu String, điều kiện tách là \\s+: khoảng trắng

        // Kiểm tra rỗng
        if (inputString.trim().isEmpty()) {
            return 0;
        }

        return words.length;
    }
}

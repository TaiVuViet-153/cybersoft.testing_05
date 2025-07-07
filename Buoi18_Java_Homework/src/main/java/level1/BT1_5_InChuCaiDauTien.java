package level1;

import java.util.Scanner;

public class BT1_5_InChuCaiDauTien {
    public static void main(String[] args) {
        // Viết hàm in ra chữ cái đầu tiên của mỗi từ trong chuỗi
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hãy nhập vào chuỗi:");
        String inputString = scanner.nextLine();

        String result = firstCharacterList(inputString);

        System.out.println("Chuỗi các ký tự đầu tiên là: " + result);
    }

    public static String firstCharacterList(String inputString) {
        String[] words = inputString.trim().split("\\s+");

        String result = "";
        for (String word: words) {
            // charAt(0): xuất ra ký tự đầu tiên của chuỗi word
            result += word.charAt(0) + " ";
        }

        return result.toUpperCase();
    }
}

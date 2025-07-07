package level1;

import java.util.Scanner;

public class BT1_1_XoaNguyenAm {
    public static void main(String[] args) {
        // Xoá nguyên âm trong chuỗi được nhập vào từ bàn phím.
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hãy nhập vào chuỗi cần xử lý");
        String inputString = scanner.nextLine();

        String output = handleString(inputString);

        System.out.println("Chuỗi sau khi xử lý: " + output);
    }

    public static boolean isVowel (char letter) {
        // Danh sách nguyên âm
        char[] vowels = {'a', 'e', 'u', 'i', 'o'};

        // Chuyển về chữ thường để kiểm tra
        letter = Character.toLowerCase(letter);

        // Duyệt qua danh sách nguyên âm
        for (char vowel: vowels) {
            // Nếu character truyền vào là nguyên âm thì return true
            if (letter == vowel) {
                return true;
            }
        }

        // Nếu không phải nguyên âm thì return false
        return false;
    }

    public static String handleString (String inputString) {
        String output = "";

        for (int i = 0; i < inputString.length(); i++) {
            // charAt cho phép log ra từng ký tự theo index
            char letter = inputString.charAt(i);
            System.out.println("Ký tự: " + letter);
            // Kiểm tra nếu không phải nguyên âm thì cộng chuỗi
            if (!isVowel(letter)) {
                output += letter;
            }
        }

        // Trả về chuỗi đã xử lý
        return output;
    }
}

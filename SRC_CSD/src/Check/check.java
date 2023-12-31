/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Check;

/**
 *
 * @author Admin
 */
public class check {

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean isVowel(char character) {
        char lowerChar = Character.toLowerCase(character);
        return lowerChar == 'a' || lowerChar == 'e' || lowerChar == 'i' || lowerChar == 'o' || lowerChar == 'u';
    }

    public static boolean isPalindrome(String str) {
        // Loại bỏ khoảng trắng và đổi thành chữ thường (lowercase) để so sánh
        str = str.replaceAll("\\s", "").toLowerCase();

        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false; // Nếu không giống nhau, không phải là chuỗi palindrome
            }
            left++;
            right--;
        }

        return true; // Nếu đi qua hết vòng lặp mà không trả về false, là chuỗi palindrome
    }
}

import java.util.Scanner;

public class PasswordStrengthIndicator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        int length = password.length();
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowercase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecialChar = true;
            }
        }

        int strength = 0;

        if (length > 8) {
            strength = 3; // Strong
        } else if (length > 6) {
            strength = 2; // Medium
        } else if (length >= 5) {
            strength = 1; // Weak
        } else {
            strength = 0; // Very Weak
        }

        if (hasUppercase) {
            strength++;
        }
        if (hasLowercase) {
            strength++;
        }
        if (hasDigit) {
            strength++;
        }
        if (hasSpecialChar) {
            strength++;
        }

        String strengthMessage = "";
        if (strength >= 5) {
            strengthMessage = "Very Strong";
        } else if (strength == 4) {
            strengthMessage = "Strong";
        } else if (strength == 3) {
            strengthMessage = "Medium";
        } else if (strength == 2) {
            strengthMessage = "Weak";
        } else {
            strengthMessage = "Very Weak";
        }

        System.out.println("Password Strength: " + strengthMessage);

        scanner.close();
    }
}

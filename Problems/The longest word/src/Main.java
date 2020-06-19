import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] strings = input.split(" ");
        String max = "";
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].length() > max.length()) {
                max = strings[i];
            }
        }

        System.out.println(max);
    }
}
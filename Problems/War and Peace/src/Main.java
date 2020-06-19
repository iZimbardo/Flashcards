import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> wordsCounter = new HashMap<>();

        String[] input = scanner.nextLine().toLowerCase().split(" ");

        int value;
        for (int i = 0; i < input.length; i++) {
            value = 0;
            for (String s : input) {
                if (input[i].equals(s)) {
                    value++;
                }
            }
            wordsCounter.put(input[i], value);
        }

        for (var entry : wordsCounter.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }


    }
}
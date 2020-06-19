import java.util.Scanner;
import java.util.TreeSet;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeSet<String> set = new TreeSet<>();

        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            set.add(scanner.nextLine());
        }

        for (String item : set) {
            System.out.println(item);
        }
    }
}
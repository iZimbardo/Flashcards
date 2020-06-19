import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random;

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int max;
        int min = k;
        int seed = 0;
        int randNumber = 0;

        for (int i = a; i <= b; i++) {
            random = new Random(i);
            max = 0;
            for (int j = 0; j < n; j++) {
                randNumber = random.nextInt(k);
                if (randNumber > max) {
                    max = randNumber;
                }
            }
            if (max < min) {
                min = max;
                seed = i;
            }
        }

        System.out.println(seed);
        System.out.println(min);
    }
}
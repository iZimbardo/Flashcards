import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> words = new HashSet<>();

        int size = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < size; i++) {
            words.add(scanner.nextLine().toLowerCase());
        }

        int lines = scanner.nextInt();
        scanner.nextLine();

        Set<String> texts = new HashSet<>();
        for (int i = 0; i < lines; i++) {
            String[] splitText = scanner.nextLine().toLowerCase().split(" ");
            texts.addAll(Arrays.asList(splitText));
//            texts.add(scanner.nextLine());
        }

        TreeSet<String> result = new TreeSet<>(texts);
        result.removeAll(words);

        for (String s : result) {
            System.out.println(s);
        }



    }
}
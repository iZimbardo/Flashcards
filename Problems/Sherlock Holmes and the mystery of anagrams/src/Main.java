import java.util.*;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        char[] firstW = scanner.nextLine().toLowerCase().toCharArray();
        char[] secondW = scanner.nextLine().toLowerCase().toCharArray();
        Map<Character, Integer> firstMap = new HashMap<>();
        Map<Character, Integer> secondMap = new HashMap<>();

        for (int i = 0; i < firstW.length; i++) {
            if (firstMap.containsKey(firstW[i])) {
                firstMap.put(firstW[i], firstMap.get(firstW[i]) + 1);
            } else {
                firstMap.put(firstW[i], 1);
            }
        }

        for (int i = 0; i < secondW.length; i++) {
            if (secondMap.containsKey(secondW[i])) {
                secondMap.put(secondW[i], secondMap.get(secondW[i]) + 1);
            } else {
                secondMap.put(secondW[i], 1);
            }
        }
//
//        for (Map.Entry<Character, Integer> pair : firstMap.entrySet()) {
//            System.out.println(pair.getKey() + " " + pair.getValue());
//        }
//
//        System.out.println();
//        for (Map.Entry<Character, Integer> pair : secondMap.entrySet()) {
//            System.out.println(pair.getKey() + " " + pair.getValue());
//        }

        if (firstMap.equals(secondMap)) {
            System.out.println("yes");
        } else {
            System.out.println("no");

        }

    }
}
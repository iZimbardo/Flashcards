import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> inputs = new ArrayDeque<>();
        Deque<Integer> firstQ = new ArrayDeque<>();
        Deque<Integer> secondQ = new ArrayDeque<>();

        int numberOfTasks = scanner.nextInt();

        for (int i = 0; i < numberOfTasks * 2; i++) {
            inputs.add(scanner.nextInt());
        }

        int firstSum = 0;
        int secondSum = 0;
        while (!inputs.isEmpty()) {
            if (firstSum <= secondSum) {
                firstQ.offer(inputs.poll());
                firstSum += inputs.poll();
            } else {
                secondQ.offer(inputs.poll());
                secondSum += inputs.poll();
            }
        }

        firstQ.forEach(e -> System.out.print(e + " "));
        System.out.println();
        secondQ.forEach(e -> System.out.print(e + " "));

    }
}
package flashcards;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.util.List;

public class Card {
    private static Scanner scanner;
    private static List<String> logs;
    private Map<String, String> card; //Key - term, Value - definition
    private Map<String, Integer> mistakes; //Key term, Value - number of mistakes
    private String[] args;

    public Card(String[] args) {
        scanner = new Scanner(System.in);
        card = new LinkedHashMap<>();
        logs = new ArrayList<>();
        mistakes = new LinkedHashMap<>();
        this.args = args;

    }

    public void action() {

        for (int i = 0; i < args.length - 1; i++) {
            if ("-import".equals(args[i])) {
                loadCards(args[i + 1]);
            }
        }

        while (true) {
            output("Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats):");
            String choice = getInput();
            switch (choice) {
                case "add":
                    add();
                    break;
                case "remove":
                    remove();
                    break;
                case "import":
                    loadCards();
                    break;
                case "export":
                    saveCards();
                    break;
                case "ask":
                    ask();
                    break;
                case "log":
                    log();
                    break;
                case "hardest card":
                    hardestCard();
                    break;
                case "reset stats":
                    resetStats();
                    break;
                case "exit":
                    exit();
                    break;
                default:
            }
        }
    }

    private void add() {
        output("The card:");
        String term = getInput();
        if (card.containsKey(term)) {
            output("The card \"" + term + "\" already exists.\n");
            return;
        }

        output("The definition of the card:");
        String definition = getInput();
        if (card.containsValue(definition)) {
            output("The definition \"" + definition + "\" already exists.\n");
            return;
        }

        card.put(term, definition);
        mistakes.put(term, 0);
        output("The pair (\"" + term +"\":\"" + definition +"\") has been added.\n");
    }

    private void remove() {
        output("The card:");
        String cardToRemove = scanner.nextLine();
        if (card.containsKey(cardToRemove)) {
            card.remove(cardToRemove);
            mistakes.remove(cardToRemove);
            output("The card has been removed.\n");
        } else {
            output("Can't remove \"" + cardToRemove +"\": there is no such card.\n");
        }

    }

    // import cards from file
    private void loadCards(String fileName) {
        String term;
        String definition;
        int numberOfMistakes = 0;
        int counter = 0;
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                term = scanner.nextLine();
                definition = scanner.nextLine();
                numberOfMistakes = Integer.parseInt(scanner.nextLine());
                card.put(term, definition);
                mistakes.put(term, numberOfMistakes);
                counter++;
            }
            output(counter + " cards have been loaded.");
        } catch (FileNotFoundException e) {
            output("File not found.\n");
        }
    }

    private void loadCards() {
        String fileName = getInput();
        String term;
        String definition;
        int numberOfMistakes = 0;
        int counter = 0;
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                term = scanner.nextLine();
                definition = scanner.nextLine();
                numberOfMistakes = Integer.parseInt(scanner.nextLine());
                card.put(term, definition);
                mistakes.put(term, numberOfMistakes);
                counter++;
            }
            output(counter + " cards have been loaded.\n");
        } catch (FileNotFoundException e) {
            output("File not found.\n");
        }
    }

    // save cards to file
    private void saveCards() {
        int counter = 0;
        output("File name:");
        String fileName = getInput();
        try (PrintWriter pw = new PrintWriter(new File(fileName))) {
            for (Map.Entry<String, String> pair : card.entrySet()) {
                pw.println(pair.getKey());
                pw.println(pair.getValue());
                pw.println(mistakes.get(pair.getKey()));
                counter++;
            }
            output(counter + " cards have been saved.\n");
        } catch (FileNotFoundException e) {
            output("File not found.\n");
        }
    }

    private void saveCards(String fileName) {
        int counter = 0;
        try (PrintWriter pw = new PrintWriter(new File(fileName))) {
            for (Map.Entry<String, String> pair : card.entrySet()) {
                pw.println(pair.getKey());
                pw.println(pair.getValue());
                pw.println(mistakes.get(pair.getKey()));
                counter++;
            }
            output(counter + " cards have been saved.\n");
        } catch (FileNotFoundException e) {
            output("File not found.\n");
        }
    }

    private void ask() {
        Random random = new Random();
        List<String> values = new ArrayList<>(card.values());
        String answer;
        String definition;

        output("How many times");
        int howManyTimes = Integer.parseInt(getInput());

        for (int i = 0; i < howManyTimes; i++) {
            definition = values.get(random.nextInt(values.size()));
            output("Print the definition of \"" + getKeyByValue(definition) + "\":");
            answer = getInput();
            if (answer.equals(definition)) {
                output("Correct answer");
//                mistakes.put(getKeyByValue(definition), 0);
            } else {
                if (card.containsValue(answer)) {
                    output("Wrong answer. The correct one is \"" + card.get(getKeyByValue(definition)) + "\", you've just written the definition of \"" + getKeyByValue(answer) + "\".");
                } else {
                    output("Wrong answer. The correct one is \"" + card.get(getKeyByValue(definition)) +"\".");
                }
                mistakes.put(getKeyByValue(definition), (mistakes.get(getKeyByValue(definition)) + 1));
            }
        }
    }

    private void log() {
        output("File name:");
        String fileName = getInput();
        try (PrintWriter pw = new PrintWriter(new File(fileName))) {
            for (String line : logs) {
                pw.println(line);
            }
            output("The log has been saved.\n");
        } catch (FileNotFoundException e) {
            output("File not found.\n");
        }
    }

    private void hardestCard() {
        int mostMistake = 1;
        List<String> listOfMistakes = new ArrayList<>();
        for (Map.Entry<String, Integer> pair : mistakes.entrySet()) {
            if (pair.getValue() >= mostMistake) {
                listOfMistakes.add(pair.getKey());
                mostMistake = pair.getValue();
            }
        }

        if (listOfMistakes.isEmpty()){
            output("There are no cards with errors.\n");
            return;
        }

        if (listOfMistakes.size() == 1) {
            output("The hardest card is \"" + listOfMistakes.get(0) + "\". You have " + mostMistake + " errors answering it.");
        } else {
            String result = "";
            for (int i = 0; i < listOfMistakes.size() - 1; i++) {
                result += "\"" + listOfMistakes.get(i) + "\", ";
            }

            result += "\"" + listOfMistakes.get(listOfMistakes.size() - 1) + "\".";
            output("The hardest card are " + result + ". You have " + mostMistake + " errors answering it.");
        }
    }

    private void resetStats() {
        for (String key: mistakes.keySet()) {
            mistakes.put(key, 0);
        }
        output("Card statistics has been reset.");
    }

    private void exit() {
        output("Bye bye!");

        for (int i = 0; i < args.length - 1; i++) {
            if ("-export".equals(args[i])) {
                saveCards(args[i + 1]);
            }
        }

        System.exit(-1);
    }

    private String getKeyByValue(String value) {
        for (Map.Entry<String, String> pair  : card.entrySet()) {
            if (pair.getValue().equals(value)) {
                return pair.getKey();
            }
        }
        return "null";
    }

    private static String getInput() {
        String input = scanner.nextLine();
        logs.add(input);
        return input;
    }

    private static void output(String s) {
        logs.add(s);
        System.out.println(s);
    }

    private void printMistakes() {
        System.out.println("\nMISTAKES:");
        for (Map.Entry<String, Integer> pair  : mistakes.entrySet()) {
            System.out.println(pair.getKey() + " : " + pair.getValue());
        }
        System.out.println();
    }

}
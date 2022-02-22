package ListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P04ListOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = sc.nextLine();
        while (!input.equals("End")) {
            String[] commandLine = input.split("\\s+");
            String command = commandLine[0];

            switch (command) {
                case "Add":
                    numbers.add(Integer.parseInt(commandLine[1]));
                    break;
                case "Remove":
                    if (Integer.parseInt(commandLine[1])>numbers.size() || Integer.parseInt(commandLine[1])<0) {
                        System.out.println("Invalid index");
                    } else {
                        numbers.remove(Integer.parseInt(commandLine[1]));
                    }
                    break;
                case "Insert":
                    if (Integer.parseInt(commandLine[2])>numbers.size() || Integer.parseInt(commandLine[2])<0) {
                        System.out.println("Invalid index");
                    } else {
                        numbers.add(Integer.parseInt(commandLine[2]), Integer.parseInt(commandLine[1]));
                    }
                    break;
                case "Shift":
                    if (commandLine[1].equals("left")) {
                        for (int i = 0; i < Integer.parseInt(commandLine[2]); i++) {
                            numbers.add(numbers.get(0));
                            numbers.remove(0);
                        }
                    } else {
                        for (int i = 0; i < Integer.parseInt(commandLine[2]); i++) {
                            numbers.add(0, numbers.get(numbers.size()-1));
                            numbers.remove(numbers.size()-1);
                        }
                    }
                    break;
            }
            input = sc.nextLine();
        }
        for (int element : numbers) {
            System.out.print(element + " ");
        }
    }
}

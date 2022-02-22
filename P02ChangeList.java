package ListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02ChangeList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = sc.nextLine();
        while (!input.equals("end")) {
            String[] inputArray = input.split("\\s+");
            if (inputArray[0].equals("Delete")) {
                for (int i = 0; i < numbers.size(); i++) {
                    if (numbers.get(i) == Integer.parseInt(inputArray[1])) {
                        numbers.remove(i);
                    }
                }
            } else if (inputArray[0].equals("Insert")) {
                numbers.add(Integer.parseInt(inputArray[2]), Integer.parseInt(inputArray[1]));
            }
            input = sc.nextLine();
        }
        for (int var : numbers) {
            System.out.print(var + " ");
        }
    }
}

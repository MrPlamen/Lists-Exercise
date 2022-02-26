package ListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05BombNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String[] commands = sc.nextLine().split(" ");
        int bombTarget = Integer.parseInt(commands[0]);
        int bombReach = Integer.parseInt(commands[1]);
        while (numbersList.contains(bombTarget)) {
            int beginning = numbersList.indexOf(bombTarget) - bombReach;
            int end = numbersList.indexOf(bombTarget) + bombReach;
            if (beginning < 0) {
                beginning = 0;
            }
            if (end > numbersList.size() - 1) {
                end = numbersList.size() - 1;
            }
            for (int j = beginning; j <= end; j++) {
                numbersList.remove(beginning);
            }
        }

        int sum = 0;
        for (Integer position : numbersList) {
            sum += position;
        }
        System.out.println(sum);
    }
}

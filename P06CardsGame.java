package ListsExercise;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P06CardsGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> deckOne = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> deckTwo = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while (deckOne.size() > 0 && deckTwo.size() > 0) {
            for (int i = 0; i < deckOne.size(); i++) {
                if (deckOne.get(0) < deckTwo.get(0)) {
                    deckTwo.add(deckTwo.get(0));
                    deckTwo.add(deckOne.get(0));
                    deckOne.remove(0);
                    deckTwo.remove(0);
                } else if (deckOne.get(0) > deckTwo.get(0)) {
                    deckOne.add(deckOne.get(0));
                    deckOne.add(deckTwo.get(0));
                    deckTwo.remove(0);
                    deckOne.remove(0);
                } else {
                    deckOne.remove(0);
                    deckTwo.remove(0);
                }
                if (deckTwo.size() == 0) {
                    int sumOne = 0;
                    for (Integer element : deckOne) {
                        sumOne += element;
                    }
                    System.out.printf("First player wins! Sum: %d", sumOne);
                    break;
                }
                if (deckOne.size() == 0) {
                    int sumTwo = 0;
                    for (int j = 0; j < deckTwo.size(); j++) {
                        sumTwo += deckTwo.get(j);
                    }
                    System.out.printf("Second player wins! Sum: %d", sumTwo);
                    break;
                }
            }
        }
    }
}

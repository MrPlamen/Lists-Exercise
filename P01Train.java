package ListsExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01Train {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> train = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int maxCapacity = Integer.parseInt(sc.nextLine());
        int passengers = 0;

        String line = sc.nextLine();
        while (!line.equals("end")) {
            String[] data = line.split("\\s+");
            if (data[0].equals("Add")) {
                train.add(Integer.parseInt(data[1]));
            } else {
                passengers = Integer.parseInt(data[0]);
                for (int i = 0; i < train.size(); i++) {
                    if (((train.get(i) + passengers)) > maxCapacity) {
                        continue;
                    } else {
                        train.set(i, (train.get(i) + passengers));
                        break;
                    }
                }
            }
            line = sc.nextLine();
        }
        for (int wagon : train) {
            System.out.print(wagon + " ");
        }
    }
}

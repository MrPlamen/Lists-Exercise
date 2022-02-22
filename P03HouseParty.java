package ListsExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P03HouseParty {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numberOfGuests = Integer.parseInt(sc.nextLine());
        List<String> guests = new ArrayList<>();

        for (int i = 0; i < numberOfGuests; i++) {
            String line = sc.nextLine();
            String[] data = line.split("\\s+");
            String name = data[0];
            if (!line.contains("not")) {
                if (guests.contains(name)) {
                    System.out.printf("%s is already in the list!\n", name);
                } else {
                    guests.add(name);
                }
            } else {
                if (guests.contains(name)) {
                    guests.remove(name);
                } else {
                    System.out.printf("%s is not in the list!\n", name);
                }
            }
        }
        for (String var : guests) {
            System.out.println(var);
        }
    }
}

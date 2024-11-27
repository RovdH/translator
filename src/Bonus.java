import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;

public class Bonus {

    public static void main(String[] args) {

        // In de code staan op verschillende plekken comments tussen "/*...*/" als hint wat je moet doen
        HashSet<Integer> secretnumber = randomnumbergenerator();
        String stringnumber = setToStringConverter(secretnumber);
        feedback(stringnumber);

    }

    public static HashSet<Integer> randomnumbergenerator() {

        java.util.Random random = new java.util.Random();
        HashSet<Integer> set = new HashSet<Integer>();

        while (set.size() < 4) {
            set.add(random.nextInt(10));
        }
        return set;
    }

    public static String setToStringConverter(HashSet<Integer> secretnumber) {
        StringBuilder sb = new StringBuilder();
        for (Integer i : secretnumber) {
            sb.append(i);
        }
        return sb.toString();
    }


    public static void feedback(String stringnumber) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("+ = juiste nummer op de juiste plek, O = juiste nummer verkeerde plek, X = verkeerde nummer");
        boolean speel = true;
        while (speel) {
            StringBuilder feedback = new StringBuilder();
            System.out.println("Doe (nog) een gok, Let op vul 4 getallen in.");
            String guess = scanner.nextLine();
                if (Objects.equals(guess, stringnumber)) {
                    System.out.println("gefeliciteerd je hebt het goed");
                    speel = false;
                } else {
                    for (int i = 0; i < 4; i++) {
                        if (guess.substring(i, i + 1).equals(stringnumber.substring(i, i + 1))) {
                            feedback.append("+");
                        } else if (stringnumber.contains(guess.substring(i, i + 1))) {
                            feedback.append("0");
                        } else {
                            feedback.append("X");
                        }
                    }
                }
            System.out.println(feedback.toString());
        }
    }
}

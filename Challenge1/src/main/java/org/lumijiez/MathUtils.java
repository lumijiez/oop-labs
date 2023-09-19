package org.lumijiez;

public class MathUtils {
    public static void printSumMultiples(int number) {
        int sum = 0;
        for(int x = 0; x < number; x++) sum += (x % 3 == 0 || x % 5 == 0) ? x : 0;
        System.out.println("The sum of all multiples of 3 and 5 is: " + sum);
    }

    // Nested as fuck, but 1 line
    public static void printNextPerfectSqr(double number) {
        System.out.println(Math.pow(Math.ceil(Math.sqrt((number == Math.pow(Math.ceil(Math.sqrt(number)), 2) ? number + 1 : number))), 2));
    }

    // Streams seemed useful here
    public static void printIsNarcissistic(int number) {
        System.out.println(String.valueOf(number).chars()
                .mapToObj(Character::getNumericValue)
                .map(n -> (int) Math.pow(n, String.valueOf(number).length()))
                .reduce(0, Integer::sum) == number ? "Narcissistic" : "NOT");
    }
}

